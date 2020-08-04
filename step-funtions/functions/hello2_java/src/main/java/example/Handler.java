package example;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;


public class Handler implements RequestHandler<Map<String,String>, String>{

  /**
   * Handler function that loads the data from S3 bucket based on the key in event.
   */
  @Override
  public String handleRequest(Map<String,String> event, Context context) {
    String fileName = event.getOrDefault("key", "partition-2020-08-03 15:56:09.708305.json");
    // System.out.println("File name: " + fileName);

    // Step 1: Build the Connection
    Instant start1 = Instant.now();
    AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
    Instant end1 = Instant.now();
    System.out.println(String.format("[Build Connection]: %s milli", Duration.between(start1, end1).toMillis()));

    // Step 2: Download the data from S3 Bucket based on the key
    Instant start2 = Instant.now();
    S3Object jsonOb = client.getObject(new GetObjectRequest("local-test-demo-bucket", fileName));
    Instant end2 = Instant.now();
    System.out.println(String.format("[Download Object from s3]: %s milli", Duration.between(start2, end2).toMillis()));

    // Step 3: deserialize the text data -> Map<String, Object>.
    ObjectMapper mapper = new ObjectMapper();
    try {
      Instant start3 = Instant.now();
      Map<String, Object> jsonMap = mapper.readValue(jsonOb.getObjectContent(), Map.class);
      Instant end3 = Instant.now();
      System.out.println(String.format("[Parse Object]: %s milli", Duration.between(start3, end3).toMillis()));
      // System.out.println("Content: ");
      // System.out.println(jsonMap.get("body"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "200 OK";
  }
}