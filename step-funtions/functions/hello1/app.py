import logging
import datetime
import boto3
from botocore.exceptions import ClientError


logger = logging.getLogger()
logger.setLevel(logging.INFO)

s3_client = boto3.client('s3')


def lambda_handler(event, context):
    logger.info("hello1 START")
    logger.info(event)

    current_time = str(datetime.datetime.now())

    key = f'partition-{current_time}.json'
    success = upload_file(key)

    response = {}
    response['update'] = True if success else False
    response['type'] =  event.get('type', 'default-type')
    response['timestamp'] = current_time
    response['message'] = 'Hello World'
    response['key'] = key

    logger.info(response)

    return response

def upload_file(key):
    try:
        s3_client.upload_file("partition.json", "local-test-demo-bucket", key)
        return True
    except ClientError as e:
        logger.error(e)
        return False
