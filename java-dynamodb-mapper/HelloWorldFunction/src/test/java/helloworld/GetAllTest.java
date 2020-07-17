package helloworld;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.apache.logging.log4j.core.util.ReflectionUtil;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class GetAllTest {

  private DynamoDBMapper mapper = mock(DynamoDBMapper.class);

//  @Test
//  public void test1() {
//    UpdateOne classUnderTest = new UpdateOne();
//    classUnderTest.updateDB(mapper, "", "");
//
//    classUnderTest.setMapper(mock(DynamoDBMapper.class));
//    Status status = new Status();
//    UUID id = UUID.randomUUID();
//    status.setId(id);
//    when(classUnderTest.updateDB(mapper, );)
//    when(mapper.load(Status.class, eq(any(Object.class)))).thenReturn(status);
//    classUnderTest.handleRequest(null, null);
//  }
}
