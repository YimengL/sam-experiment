import logging
import datetime
import json
import boto3

logger = logging.getLogger()
logger.setLevel(logging.INFO)

BUCKET = "local-test-demo-bucket"

client = boto3.client('s3')

def lambda_handler(event, context):
    logger.info("hello2 START")
    logger.info(event)
    
    json_data = json.loads(client.get_object(Bucket=BUCKET, Key=event.get('key'))['Body'].read())
    logger.info("[END] loading data")

    logger.info(json_data.keys())

    response = {}

    return response
