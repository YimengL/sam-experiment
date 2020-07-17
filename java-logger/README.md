# java-logger

```shell script
$ sam build
```

```shell script
$ sam package --output-template-file package.yaml --s3-bucket yimeng-test-bucket1
```

```shell script
$ sam deploy --template-file package.yaml --stack-name SamJavaLogger --capabilities CAPABILITY_IAM
```
