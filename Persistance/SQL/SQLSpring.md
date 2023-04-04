# SQL Spring boot
## Theory
Main: @Component
1.  @Service (class level)
2.  @Bean (function level)
3.  @Respository
## Depedency
1. Spring boot jdbc
```
		<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jdbc -->
    	<dependency>
        	<groupId>org.springframework.boot</groupId>
        	<artifactId>spring-boot-starter-jdbc</artifactId>
         	<version>3.0.2</version>
    	</dependency>
```
2.  Spring web
3.  Spring boot dev tools
4.  mysql driver
5.  spring data jpa
6.  lombok
## APplication properties
```
spring.datasource.url=jdbc:mysql://localhost/hotelreservation
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

```
## random
https:// whx.com.sg
POST        ->        CREATE
GET         ->        READ
PUT         ->        UPDATE
DELETE      ->        {ID} DELETE
protocol domain
whole thing is url

## day 2

## day3
1 to 1
an emp has only 1 address
employee->address(1)
An address link to only 1 employee
employee<-address(1)

1 to many
an employee has one or more dependants
employee->dependant(*)
one dependant can only link to one employee
employee<-dependant(1)

many to many not acceptable in database
an employee can work on many projects
employee->projects(*)
a project can have many employee working
employee<-projects(*)
must be resolved
employee(1)<->(*)employee project(*)<->projects(1)

foreign key is always on the many side

0 normal form(0NF) 
1nf         remove repeating group
2nf         eliminate redundant data
3nf         eliminate transitive dependenct            
4nf *** knwing up to 3nf not bad alr
refer to https://www.datanamic.com/support/database-normalization.html

add new user
adminstration
users and privileges
