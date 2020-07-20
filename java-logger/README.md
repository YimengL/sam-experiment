# java-logger

```shell script
# build the code
$ sam build
```

```shell script
# package & upload the code to aws s3
$ sam package --output-template-file package.yaml --s3-bucket yimeng-test-bucket1
```

```shell script
# deploy the resource, i.e. lambda functions
$ sam deploy --template-file package.yaml --stack-name SamJavaLogger --capabilities CAPABILITY_IAM
```

### Experiment:

2 lambda function: LoggerFunctionWARN & LoggerFunctionDEBUG
* Exact same code
* use different environment variable
* LoggerFunctionWARN set log level to WARN
* LoggerFunctionDEBUG set log level to DEBUG
* Set the environment variable in template.yaml
* Use the environment variable in resources/log4j2.xml

```shell script
# invoke function1
$ sam local invoke LoggerFunctionWARN

# invoke function2
$ sam local invoke LoggerFunctionDEBUG
```
