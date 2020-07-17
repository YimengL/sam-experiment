package helloworld;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class UpdateOne implements RequestHandler<APIGatewayProxyRequestEvent , APIGatewayProxyResponseEvent> {
  private static final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
  private static final DynamoDBMapper mapper = new DynamoDBMapper(client);


  @Override
  public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent sqsEvent, Context context) {
    Status status = mapper.load(Status.class, UUID.fromString("0d0168f1-7fb3-4878-bd0f-51d9b5db1ca2"));
    Payload payload = status.getNewPayload();
    payload.setBody("new" + LocalDateTime.now().toString());
    status.setNewPayload(payload);
    mapper.save(status);
    return null;
  }

}
