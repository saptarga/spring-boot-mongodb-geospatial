# SPRING BOOT - MONGODB - GEOSPATIAL

## Description
Simple project geospatial using java spring boot and mongodb

## Prerequisites
- Java JDK 11
- MongoDB Database
- Maven

## Installation

Step for installation:
- Create Database in MongoDB : `restaurantDB`
- Create `2dsphere` indexes support queries that calculate geometries on an earth-like sphere.
```
db.restaurantDB.createIndex({location:"2dsphere"});
```
- Clone project from github
```sh
# Clone this project from gitlab
git@github.com:saptarga/spring-boot-mongodb-geospatial.git

# Clears the target directory and builds the project
mvn clean install
```

## Run Project
You can start this project using
```sh
mvn clean spring-boot:run
```

## Example Request Rest API

### Request Add Restaurant
```http
POST /restaurant HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 312

{
    "name": "Restauran Ayam Bakar Spesial",
    "address": "Jl. Asia Afrika No.8, RT.1/RW.3, Senayan, Kecamatan Tanah Abang, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10270",
    "rate": "4.5",
    "latitude": -6.2288667,
    "longitude": 106.7845697
}
```

### Request Get Restaurant Nearby Location
```
GET /restaurant/nearby?latitude=-6.907329&longitude=107.603198&distance=5 HTTP/1.1
Host: localhost:8080
```

## Author
Created and maintained by saptarga ([@saptarga](https://www.linkedin.com/in/saptarga)).