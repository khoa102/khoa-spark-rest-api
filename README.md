# Khoa's Spark REST API

## What is this project?
This is a REST api project implemented in Java with the Spark Java micro web framework. The main purpose of this project is to 
demonstrate my understanding of REST API, knowledge of backend development, knowledge of Java web framework

## What is some of my consideration?
- The application will be operated under UTC timezone. All data will be stored and processed in UTC timezone. May add a flag for each
api to specify returned timezone
  - Logging is using local timezone for ease of debug. Can be set to UTC timezone by changing %d{yyyy-MM-dd HH:mm:ss:SSS} 
to %d{yyyy-MM-dd HH:mm:ss:SSS, UTC} in logback.xml
- Add logging system to log and debug system (Using logback)
- Add an api key for security demonstration. I might make an authorization and authentication server later, we may use it for
authenticate this REST api in the future
- Data is returned in JSON format
- Using H2 as in memory database

## Hibernate
- Hibernate allows one-session-per-request by specify "current_session_context_class" = "thread" in configuration.
- Session allows data to be cached once retrieved. Session also do only one update to the database after all change is made with the session. 
So, one-session-per-request is good because the same data is more likely to be accessed in the same session.
- Hibernate saveOrUpdate will decide save or update operation based on whether Id is assigned.
- Using Hibernate as a provider for JPA because JPA is more generic and allows the code to be loosely coupled with the provider. 
That means you can switch out Hibernate for another ORM framework if you want to.

## DAO pattern vs repository pattern
- DAO is closer to the database. It is almost a 1:1 mapping of a database table.
- Repository is Domain-Driven pattern. It represents a domain entity and not database entity. For example: A Domain Entity for Resume, 
may includes Education, WorkExperiences,...
- DAO pattern:
  - An interface: specifies what this DAO can do
  - An implementation: implementation for the interface
  - Entity: that DAO will put data into
  - Allow the business/service layer to be loosely coupled with the database implementation. Make it easier to mock or test the code
  - 