package helloworld;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CreateOne implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
  private static final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
  private static final DynamoDBMapper dynamoDB = new DynamoDBMapper(client);

  /**
   *
   * @param requestEvent {@link APIGatewayProxyRequestEvent}(request) from the API Gateway
   * @param context 不知道
   * @return  {@link APIGatewayProxyResponseEvent}(response) of the API Gateway
   */
  @Override
  public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent requestEvent, Context context) {
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "text/plain");

    try {
//      String payload = requestEvent.getBody();
//      ObjectMapper objectMapper = new ObjectMapper();
//      Status item = objectMapper.readValue(payload, Status.class);
      Status item = new Status();
      item.setId(UUID.randomUUID());
      item.setPayload("July/14");
      // item.setExtraCol("new col July 14");
      dynamoDB.save(item);
      return new APIGatewayProxyResponseEvent()
          .withHeaders(headers)
          .withStatusCode(201)
          .withBody("201: CREATED");
    }
    catch (Exception e) {
      e.printStackTrace();
      return new APIGatewayProxyResponseEvent()
          .withHeaders(headers)
          .withStatusCode(400)
          .withBody("FAIL to CREATE");
    }
  }
}
