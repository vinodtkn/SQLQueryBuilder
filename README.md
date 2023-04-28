# SQLQueryBuilder
 
## Problem statement 1: 

Create a SQL query supporting various operators ( IN, LIKE, =, <=, >= , <>, BETWEEN etc) Assume the application you write can have a JSON in the below format to parse and create the expression 

{"columns":[{"operator":"IN","fieldName":"column1","fieldValue":"value"},{"operator":"Equal","fieldNa me":"column2","fieldValue":"value"}} 

As part of your assignment, please write C#/Java code to implement the following functionalities: - 

Read the JSON file.

Create an SQL QUERY as an output. 

## Problem statement 2: 

Extend the program further to support querying from multiple tables i.e., add support for sub-query or joins in the query builder

The idea of this problem should be to provide a generic solution to build SQL Query supporting any number of tables.

## Inputs:

QueryBuilder_Swagger_Spec_1.0.txt - Swagger specification for the API

Sample_Input_Json.txt - sample JSON inputs for possible api endpoints
