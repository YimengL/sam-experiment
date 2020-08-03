import logging
from datetime import datetime
import json
import boto3

logger = logging.getLogger()
logger.setLevel(logging.INFO)

BUCKET = "local-test-demo-bucket"


def lambda_handler(event, context):
    logger.info("hello2 START")
    logger.info(event)

    start1 = datetime.now()
    client = boto3.client('s3')
    end1 = datetime.now()
    logger.info("[Python][Build Connect]: " + str((end1 - start1).total_seconds() * 1000) + " milli")
    
    start2 = datetime.now()
    json_data = json.loads(client.get_object(Bucket=BUCKET, Key=event.get('key', 'partition-2020-08-03 15:56:09.708305.json'))['Body'].read())
    end2 = datetime.now()

    logger.info("[Python][Download + Parse JSON data]: "+ str((end2 - start2).total_seconds() * 1000) + " milli")
    

    logger.info(json_data.keys())

    response = {}

    return response
