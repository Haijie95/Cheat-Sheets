# Application properties to be added

1. Railway
```
spring.data.redis.host=${REDISHOST}
spring.data.redis.port=${REDISPORT}
spring.data.redis.username=${REDISUSER}
spring.data.redis.password=${REDISPASSWORD}
spring.redis.client.type=jedis
spring.data.redis.database=0
```
2. Local
```
spring.data.redis.host=localhost    
spring.data.redis.port=6379
spring.data.redis.username=
spring.data.redis.password=
spring.data.redis.client-type=jedis
```
3. Redis.com
```
spring.data.redis.password=${REDISDOTCOM_PASSWORD}
spring.data.redis.host=${REDISDOTCOM_HOST}
spring.data.redis.port=${REDISDOTCOM_PORT}
spring.data.redis.username=${REDISDOTCOM_USERNAME}
```