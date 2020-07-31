import logging
import datetime

logger = logging.getLogger()
logger.setLevel(logging.INFO)

def lambda_handler(event, context):
    logger.info("hello1 START")
    logger.info(event)

    response = {}
    response['type'] =  event.get('type')
    response['timestamp'] = str(datetime.datetime.now())
    response['message'] = 'Hello World'

    return response
