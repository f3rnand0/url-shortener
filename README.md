# URL SHORTENER

## Description
This Kotlin Rest API (an MVP for the moment) shortens a URL by using Base64 encoding to return a hash, 
and once a hash comes as a request responds the corresponding URL.
To achieve this it stores in a memory database the URL and the hash. 


### Endpoints
1. /api/getHash: with a URL as request returns a hash using Base64 encoding 
2. /api/getURL: with a hash as request returns a URL

### Prerequisites
- You will need the following installed.
```
Kotlin 1.6 or above
Java 11 or above
Gradle 7.4.1 or above
```

### Building
- There are two ways to build this application. One way is to by getting a jar file using gradle, just run:
```
./gradlew build (Linux/Mac) or gradlew.bat build (Windows)
```
- The other way is to build a Docker image, so many instances can be easily executed at the same time. 
- The following command will create a docker image that can be used to create multiple containers: 
```
docker build --build-arg SERVER_PORT=8080 -t url-shortener .
```

### Executing
- To execute the application from a single jar, just run:
```
./gradlew bootRun (Linux/Mac) or gradlew.bat bootRun (Windows)
```
- To generate a container from the image of the previous step execute:
```
docker run -p 8080:8080 url-shortener
```