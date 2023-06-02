# MYSQL Query

## Basic function
**CRUD**
1. **C** -> Create
2. **R** -> Read
3. **U** -> Update
4. **D** -> Delete

## Basic Operations

### Create a Database
```
create database <database name>
```
### Use a Database
```
user <database name>
```
### Create a Table
```
CREATE TABLE <table name> (
  `id` int NOT NULL AUTO_INCREMENT,
  `displayname` varchar(45) NOT NULL,
  `email` varchar(55) NOT NULL,
  `cardname` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `cardcondition` varchar(15) NOT NULL,
  `defect` varchar(120) NOT NULL,
  `price` varchar(45) NOT NULL,
  `available` varchar(45) NOT NULL,
  `image` longblob NOT NULL,
  PRIMARY KEY (`id`)
)
```
> Auto increment will auto increase the value as the number of record increases

### Reading a table
1. Reading **all**
```
select * from <table name>
```
2. Limit the reading (eg. reading only 50 records)
```
select * from <table name> limit 50;
```
3. Limit what column u want
```
select id, name from <table name> limit 100 offset 1000;
```
> retrieving the first 100 record starting from the 1000, meaning will read from 1000 to 1100
4. Giving a condition when reading
```
select * from <table name> where id = 2;
```
5. Reading with wild card
```
select * from <table name> where name like "%john%"
```
6. Reading select for dates
```
select release_date from <table name> where date > “2012-01-01” and date < “2012-12-31";
```
7. Reading select for enum
```
select * from <table name> where ratings in (“M18”, “R21”);
```

### Insert
1. How to insert
```
insert into tutorial (title,author,submission_date) values ('CS101','Matthew','2023-02-01');

insert into <table name> (field names) values (values matching the field names)
```

### Count
1. Count by the condition
```
select count(*) 
from employee 
where 
Gender = 'M'
```
2. Get two seperate counts
```
select Gender, count(*) from employee
where 
Gender = 'M'
union
select Gender, count(*) from employee
where 
Gender = 'F'
```

### Combinining tables
```
select  resv.id resv_id, cust.id cust_id, cust.first_name, cust.last_name,
resv.start_date,resv.end_date,resv.total_cost,room.price,room.room_type 
from customer cust
inner join reservation resv
on cust.id=resv.customer_id
inner join room
on resv.room_id= room.id;
```
> Tables can be joined together via the use of inner join

### Distinct (Get unique value from the columns)
```
select distinct cust.first_name, cust.last_name
from customer cust
inner join reservation resv
on cust.id=resv.customer_id
inner join room
on resv.room_id= room.id;
```

### Arithmetic
```
select start_date, round(avg(total_cost),2) from reservation
where start_date='2023-02-01';
```
> This will avg the total cost and round to 2 decimal place

### Ascending or descending order
```
select * from customer 
order by first_name asc,last_name asc 
```
1. This will sort the first_name in an ascending order
2. This also has a precedence
3. first_name will be sorted first before sorting last_name
4. Only similar first_name will be reshuffled by the 2nd sorting

### Delete (Deleting rows that contain specific values)
```
delete from customer2 where id=6;
delete from customer2;
```

### Order By
```
select 'Feb 2023' as period, room_id,count(*) cnt from reservation
where start_date between '2023-02-01' and '2023-02-28'
group by room_id
order by cnt desc;
```
> Order them by the count in a descending order

### Union
```
select 'Feb 2023' as period, room_id, count(*) cnt
from reservation
where start_date between '2023-02-01' and '2023-02-28'
group by room_id
union
select 'Mar 2023' as period, room_id, count(*) cnt
from reservation
where start_date between '2023-03-01' and '2023-03-31'
group by room_id;
```
> Union will combine the results that you draw out and filter
> This case it will show feb and mar both together
> Note: Column must be the same

### Reset Count
```
ALTER TABLE tablename AUTO_INCREMENT = value;
```

## Other Matter

### Giving an alias
```
select a.* from tutorial a
```
- Giving tutorial table an alias called a, can use a to callout the record

### Comment
```
- '#' to comment line
- '/* ---- */ to block comment
```

### How to get the EER Diagram (from MYSQL workbench)
1. After the creation of all the tables
2. Go to database at the top
3. Reverse Engineer
4. Select the schema that you want
5. Next and finish
6. You should be able to see the EER diagram