# POC project (Java, DynamoDB mapper)

## Use the SAM CLI to build and test locally

Build your application with the `sam build` command.

```shell script
java-dynamodb-mapper$ sam build
```

The SAM CLI installs dependencies defined in `HelloWorldFunction/pom.xml`, creates a deployment package, and saves it in
the `.aws-sam/build` folder.

Test a single function by invoking it directly with a test event. An event is a JSON document that represents the input
that the function receives from the event source. Test events are included in the `events` folder in this project.

Run functions locally and invoke them with the `sam local invoke` command.

```shell script
java-dynamodb-mapper$ sam local invoke HelloWorldFunction --event events/event.json
```

The SAM CLI can also emulate your application's API. Use the `sam local start-api` to run the API locally on port 3000.

```shell script
java-dynamodb-mapper$ sam local start-api
java-dynamodb-mapper$ curl http://localhost:3000/
```

The SAM CLI reads the application template to determine the API's routes and the functions that they invoke. The
`Events` property on each function's definition includes the route and method for each path.

```yaml
      Events:
        HelloWorld:
          Type: Api
          Properties:
            Path: /hello
            Method: get
```

## Unit tests

Tests are defined in the `HelloWorldFunction/src/test` folder in this project.

```shell script
$ mvn -f HelloWorldFunction/pom.xml test
```

```shell script
$ sam package --s3-bucket yimeng-test-bucket1 --output-template-file package.yaml
```

## Deploy

```shell script
$ sam deploy --template-file package.yaml --stack-name SamDynamodb --capabilities CAPABILITY_IAM
```

## Cleanup

To delete the sample application that you created, use the AWS CLI. Assuming you used your project name for the stack
name, you can run the following:

```shell script
$ aws cloudformation delete-stack --stack-name SamDynamodb
```

## Experiment 1

Try to reproduce a bug mentioned in https://github.com/awslabs/aws-sam-cli/issues/1569

```shell script
# build the project
$ sam build
```

```shell script
$ sam package --template-file template.yaml --output-template-file package.yaml --s3-bucket yimeng-test-bucket1
```

probably correct command:
```shell script
$ sam package --output-template-file package.yaml --s3-bucket yimeng-test-bucket1
```

```shell script
# Deploy the sam
$ sam deploy --template-file package.yaml --stack-name SamDynamodb --capabilities CAPABILITY_IAM
```
