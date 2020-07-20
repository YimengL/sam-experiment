package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final Logger logger = LogManager.getLogger(App.class);

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        logger.error("[App]ERROR log");
        logger.warn("[App]WARN log");
        logger.info("[App]INFO log");
        logger.debug("[App]DEBUG log");
        logger.trace("[App]TRACE log");

        logger.warn("Log level: " + System.getenv("LOG_LEVEL"));

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        return response.withBody("hello").withStatusCode(200);
    }
}
