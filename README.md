# GoGato!
#### A Social Media Application

## What is GoGato?
GoGato is a social media site where users can share stories that interest them.
Users can comment on posts and discover new trending topics. 
Read something cool? Leave a like to give the author GoGato points!

## What is the GoGato application comprised of?
The GoGato backend was built using Java Spring Boot.
The Posts and Users API currently function independently. However, there is 
potential the application to transition to a microservices architecture in the future.

GoGato's frontend was built with the React.js library.

## Site Design and Functionality

TBD

## Posts API

The GoGato Posts API provides the following functionalities:
* Create/Update/Delete Posts
* Retrieve a Post by userId
* Retrieve all Posts
* Create a Like
* Retrieve a Like by userId
* Retrieve all Likes
* Update/Delete Like by userId

### Route Table
| POSTS                  | Description          |
|------------------------|----------------------|
| /post                  |                      |
| /post/userid/:userid   | Get post by userid   |
| /post/userid/:parentid | Get post by parentid |
| /post/create           | Create a new post    |

| LIKES           | Description                         |
|-----------------|-------------------------------------|
| /likes          | GET: Return list of Likes           |
|                 | POST: Create a Like                 |
| /likes/{userId} | GET: Return list of Likes by userId |
|                 | PUT: Update a Like for {userId}     |
|                 | DELETE: Delete a like for {userId}  |

## Users API

The GoGato Users API provides the following functionalities:
* Create/Register a User
* Login/Validate a User
* Find a User by userId or username
* Update a User's firstName, lastName and aboutMe
* Update a User's points

The Users API is documented via Swagger OpenAPI and JavaDocs.
It utilizes a static BCrypt hash which permits the API to build a password security platform that encrypts passwords. 
The API is documented with Swagger and JavaDocs. 
The API connects to a PostgreSQL database that is hosted on AWS that allows us to deploy servers efficiently. 
The tables for the RDMS are created via Spring JPA with Hibernate.


### Users controller

Please see Swagger documentation for a full description of requests.

| USERS                | Description                         |
|----------------------|-------------------------------------|
| /users               | POST: Create a new User             |
|                      | GET: Get all Users                  |
| /users/{identifier}/ | GET: Get User by userId or Username |
| /users/{identifier}/ | PUT: Update a User's points         |

| LOGIN  | Description                       |
|--------|-----------------------------------|
| /login | POST: Verify a User's credentials |

| PROFILES                     | Description                 |
|------------------------------|-----------------------------|
| /profiles/{identifier}/about | PUT: Update a User's points |
| /profiles/{identifier}/name  | PUT: Update a User's name   |