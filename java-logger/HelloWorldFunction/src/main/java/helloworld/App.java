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
        logger.error("[Yimeng]ERROR log");
        logger.warn("[Yimeng]WARN log");
        logger.info("[Yimeng]INFO log");
        logger.debug("[Yimeng]DEBUG log");
        logger.trace("[Yimeng]TRACE log");

        logger.warn("Log level: " + System.getenv("LOG_LEVEL"));

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        return response.withBody("hello").withStatusCode(200);
    }
}
