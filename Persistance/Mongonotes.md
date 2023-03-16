# **MONGO**

## **Additional Dependency**
```
<dependency>
    <groupId>org.glassfish</groupId>
    <artifactId>jakarta.json</artifactId>
    <version>2.0.1</version>
</dependency>
```
## **Mongosh**
1. Show stuff
- show dbs
- show collections

2. How to drop database
>   - use the dbs
>   - db.dropDatabase()

## **Mongodb atlas**
1. New project
2. Give a project name
3. Go network access
- Set as the follow for access from anywhere
```
0.0.0.0/0
```
4. Build a database
5. Create a user
6. Click connect and get the url
7. Go terminal
8. set the url
```
set MONGO_URL=mongodb+srv://boardgames.xs6xvzk.mongodb.net/
```
9. Set user and pw
```
set USERNAME=tester
```
```
set PASSWORD=password12345
```
10. now to import
```
mongoimport %MONGO_URL% --username %USERNAME% --password %PASSWORD% -d bgg -c game --jsonArray --file ./game.json --drop
```
must be in the same directory
```
mongoimport %MONGO_URL% --username %USERNAME% --password %PASSWORD% -d boardgames -c comment --jsonArray --file comment.json
```

## LocalMongo
local import
mongoimport mongodb://localhost:27017 -d bgg -c games --jsonArray --file game.json
mongoimport mongodb://localhost:27017 -d bgg -c comments --jsonArray --file comment.json

spring.data.mongodb.uri=mongodb://localhost:27017
spring.data.mongodb.database=shows

## Railway MONGO
mongoimport --authenticationDatabase=admin "%MONGO_URL%" -d boardgames -c game --jsonArray --file ./game.json

mongoimport --authenticationDatabase=admin "%MONGO_URL%" -d boardgames -c comment --jsonArray --file ./comment.json

mongoimport --authenticationDatabase=admin "%MONGO_URL%" -d boardgames -c playstore --type=csv --headerline --file googleplaystore.csv

set MONGO_URL=mongodb://%MONGOUSER%:%MONGOPASSWORD%@%MONGOHOST%:%MONGOPORT% 

set MONGOUSER=
set MONGOPASSWORD=
set MONGOPORT=
set MONGOHOST=

spring.data.mongodb.uri=${MONGO_URL}