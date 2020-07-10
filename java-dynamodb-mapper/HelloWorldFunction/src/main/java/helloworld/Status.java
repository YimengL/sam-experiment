package helloworld;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.util.UUID;

@DynamoDBTable(tableName = "Status")
public class Status {

  @JsonProperty(value = "id", access = Access.WRITE_ONLY)
  private UUID id;

  @JsonProperty(value = "payload")
  private String payload;

  @JsonProperty(value = "extra_col")
  private String extraCol;

  @DynamoDBHashKey(attributeName = "id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @DynamoDBAttribute(attributeName="yimeng-test")
  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public String getExtraCol() {
    return extraCol;
  }

  public void setExtraCol(String extraCol) {
    this.extraCol = extraCol;
  }
}