# Pom needed
1. Manually add in Json
```
        <!-- https://mvnrepository.com/artifact/org.glassfish/jakarta.json -->
		<dependency>
			<groupId>org.glassfish</groupId>
			<artifactId>jakarta.json</artifactId>
			<version>2.0.1</version>
		</dependency>
```
2. Spring Data JDBC
```
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
```
3. JDBC API
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
```
4. MYSQL Driver
```
        <dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
```
