# Khoa's Spark REST API

## What is this project?
This is a REST api project implemented in Java with the Spark Java micro web framework. The main purpose of this project is to 
demonstrate my understanding of REST API, knowledge of backend development, knowledge of Java web framework

## What is some of my consideration?
- The application will be operated under UTC timezone. All data will be stored and processed in UTC timezone. May add a flag for each
api to specify returned timezone
- Add an api key for security demonstration. I might make an authorization and authentication server later, we may use it for
authenticate this REST api in the future
- Data is returned in JSON format