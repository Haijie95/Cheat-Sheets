# Pom needed for redis
1. Add this dependency when generating springboot `Spring Data Redis (Access+Driver)`
```
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
```
2. Manually add in pom.xml
```
        <dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>4.3.1</version>
		</dependency>
```

# Steps needed
1.