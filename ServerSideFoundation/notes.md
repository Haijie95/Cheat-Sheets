# **Revision Notes**

---

## **Lesson Eleven**

### Run Springboot
1. Compile Mavern project
```
mvn compile
```
2. Package Mavern project
```
mvn package
```
3. Run Spring-boot locally
```
mvn spring-boot:run
```
4. Clean up the mavern project and remove target folder
```
mvn clean
```
### Railway deployment
1. Login to railway, this will launch your browser, and require login
```
railway login
```
2. Init your project to enable railway
```
railway init
```
3. Push to railway site
```
railway up
```
4. Click on the launched project
```
click the project in the middle area
```
5. Go to settings and generate domain/website
### Run with arguments
1. Spring boot port config / Arguments with mvn
```
mvn spring-boot:run -Dspring-boot.run.arguments=--port=8084
```
2. Setting the port number
```
set APP_PORT=8090
```

---

## **Lesson Twelve**

## **Lesson Thirteen**
### Run with different args
- Linux/Macos
```
mvn spring-boot:run -Dspring-boot.run.arguments=--dataDir=/opt/tmp/data
```
- Windows 10/11
```
mvn spring-boot:run -Dspring-boot.run.arguments=--dataDir=C:/data
```
### Git branching
- To branch out (change branch)
```
git checkout -b haijie
```
Purpose is to work on a version while not touching the present version
So as not to touch the Main
- To return to main
```
git checkout main
```

### Simple redis command
1. Get keys / return keys
```
keys *
```
2. To set a key and value
```
set key value
```
3. To get the value in the key 
```
get key
```
4. Delete key
```
delete key
```
5. Check exist
```
exists key
```
6. Get cart index 0 item
```
lindex cart 0
```

---

## **Lesson Fourteen**
1. Redis Config
Copy and paster xD

---

## **Lesson Sixteen**
### Rest Controller
1. Create all the models 
2. Make them return toJson value
3. Make Service -  it will contain all the methods for processing the data 
4. RedisConfig can copy paste
5. Mapping
- request mapping
- post mapping
- get mapping - must inclue the path
```
@GetMapping(path="{msId}")
```
6. Make the Rest controller
- remember to autowire the service


## **Lesson Seventeen**
### API
1. Know the URL to craft the URI
```
https://api.openweathermap.org/data/2.5/weather?q=<city>&appid=<API key>

```
2. Before testing we need to set the API Key
```
set OPEN_WEATHER_MAP_API_KEY=<API key>
```
3. Icon URL can be found here
```
https://openweathermap.org/weather-conditions
```
### For Fun
1. Go back button
```
<div class="back">
    <button onclick="history.back()">Go Back</button>
</div>
```

---
### Manual Dependency
1. JSON
```
</dependency>
	<!-- https://mvnrepository.com/artifact/org.glassfish/jakarta.json -->
	<dependency>
		<groupId>org.glassfish</groupId>
		<artifactId>jakarta.json</artifactId>
		<version>2.0.1</version>
</dependency>
```
2. JEDIS
```
<dependency>
	<groupId>redis.clients</groupId>
	<artifactId>jedis</artifactId>
	<version>4.3.1</version>
</dependency>
```
### Application Properties
1.Railway settings
```
spring.redis.host=${REDISHOST}
spring.redis.port=${REDISPORT}
spring.redis.username=${REDISUSER}
spring.redis.password=${REDISPASSWORD}
spring.redis.client.type=jedis
```
2. Local settings
```
spring.data.redis.host=${REDISHOST}
spring.data.redis.port=${REDISPORT}
spring.data.redis.username=
spring.data.redis.password=
spring.data.redis.client-type=jedis
```
3. Redis DotCom
```
spring.data.redis.password=${REDISDOTCOM_PASSWORD}
spring.data.redis.host=${REDISDOTCOM_HOST}
spring.data.redis.port=${REDISDOTCOM_PORT}
spring.data.redis.username=${REDISDOTCOM_USERNAME}
```

## Love Calculator
