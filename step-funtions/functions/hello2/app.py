import logging
import datetime

logger = logging.getLogger()
logger.setLevel(logging.INFO)

def lambda_handler(event, context):
    logger.info("hello2 START")
    logger.info(event)

    response = {}

    return response
