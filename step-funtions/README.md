### prerequisite
* create a `parition.json` file under the dir: `functions/hello1`

### Use the SAM CLI to build locally

```bash
$ sam build --use-container
```

### Package

You need to create a s3 bucket in your AWS account, and replace the yimeng-test-bucket1 with your bucket name.

```bash
$ sam package --s3-bucket yimeng-test-bucket1 --output-template-file package.yaml
```

### Deploy

```bash
$ sam deploy --template-file package.yaml --stack-name SamStepFunctions --capabilities CAPABILITY_IAM
```

### Cleanup

To delete the sample application that you created, use the AWS CLI. Assuming you used your project name for the stack name, you can run the following:

```bash
aws cloudformation delete-stack --stack-name step-funtions
```
