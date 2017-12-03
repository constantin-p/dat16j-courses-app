# Spring Courses App

### Running locally

1. Clone the project: `git clone https://github.com/constantin-p/dat16j-courses-app.git`
2. Change the current working directory: `cd dat16j-courses-app`
3. Generate the config file: `cp _templates/application-template.properties src/main/resources/application-production.properties` and replace the placeholders
4. Set script permissions: `chmod +x run.sh` (NOTE: Only required if `run.sh` is not already executable)
5. Run the application : `./run.sh`

### Running on AWS

From the AWS Management Console:

1. Open the Elastic Beanstalk console (top nav: Services > search for: Elastic Beanstalk).

2. Choose Create New Application and use the following options:
  Predefined configuration: Java
  Source: Upload your own (Build the app locally and create a .zip from target/dat16j-courses-app-*.jar)
  
3. For Additional Resources select:
  - [x] Create a RDS DB instance
  - [x] Create this enviroment inside a VPC

4. For RDS Configuration specify a username and password for database access.

5. For VPC Configuration:
  Select the default VPC.
  Select at least two Availability Zones for each service.
  
6. For Permissions use the generated profiles.

#### After the launch process, configure Spring Boot:

Open the configuration page, and under Software Configuration, click the settings icon.
  Add the following environment variables:

| Property name               | Property value | *note        |
| --------------------------- | -------------- | ------------ |
| SERVER_PORT                 | 5000           |              |
| SPRING_DATASOURCE_URL       | jdbc:mysql://`DB_ENDPOINT`/`DB_NAME`  | Endpoint from the `Environment Configuration` page, under the Data Tier section. |
| SPRING_DATASOURCE_USERNAME  | DB_USER        | From step 4. |
| SPRING_DATASOURCE_PASSWORD  | DB_PASS        | From step 4. |



## License

This project is MIT licensed.
Please see the [LICENSE](LICENSE) file for more information.
