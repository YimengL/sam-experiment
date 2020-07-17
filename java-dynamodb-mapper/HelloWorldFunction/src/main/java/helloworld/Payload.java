package helloworld;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

@DynamoDBDocument
public class Payload {

  @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
  @DynamoDBAttribute(attributeName = "is_complete")
  private boolean complete;

  @DynamoDBAttribute(attributeName = "body")
  private String body;

  @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
  @DynamoDBAttribute(attributeName = "has_error")
  private boolean error;

  public boolean isComplete() {
    return complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }
}
