# **Workshop 21**

---

## **DB system**
- The DB is handled by a DBMS(Data Base Management System) 
- DBMS uses 2 language DDL(Data definiton language) and DML(Data management language)
- Both uses Query

## **Some Theory** 
- A table is like a sheet for data storing
- Each record is a row
- Each column is a field
- Blob is image store as a string object

---

## **Basic Operations**
### **Create DB**
```
create database leisure;
```
Result: Should see "create database leisure" in action output with a green tick
Note: Can only create once
Error Output: if try again will show "Error Code: 1007. Can't create database 'leisure'; database exists"
Extra Note: ; is not really needed to run the code however it is needed if u want to run multiple codes to break them
### **Comment**
- '#' to comment line
- '/* ---- */ to block comment
### **Select DB**
```
use [DB name]
```
- See schema and [DB name] should appear and selected
### **AUTO_INCREMENT**
``` 
tutorial_id INT NOT NULL AUTO_INCREMENT
```
- It will auto generate and id in sequence increasing order
### **Use**
```
use leisure;                
```
- To specify which database to use
### **Create table**
```
create table tv_shows ();     -
```
- Create the table for the database
### **Field Creation**
```
    prog_id int not null,
    title char(64) not null,
    lang char(16) not null,
    official_site varchar(256),
    rating enum('G','NC16','PG','M18','R21') not null,  -> limit to these inputs
    user_rating float default '0.0',    -> can set default value
    release_date date,  -> date is just date in this format YYYY-MM-DD
    image blob, -> blob is like a string of code/data for pictures 
    primary key(prog_id)    -> Set Primary key
    constraint pk_prog_id primary key (prog_id),
	constraint chk_user_rating
		check(user_rating between 0.0 and 10.0)
```
### **Insert Data**
```
insert into tutorial 
(title,author,submission_dat)
values ('CS101','Matthew','2023-02-01');
```
- This will insert the data in the DB
- Its in the form below
```
insert into [tablename](field names) values (values matching the field names)
```
### **Select Data**
```
select * from tutorials  
```
- Read all from the table, it will show in a table below
```
select a.id, a.title from tutorial a
```
- Get a specific column
### **Alias**
```
select a.* from tutorial a
```
- Giving tutorial table an alias called a, can use a to callout the record
### **Limit**
```
limit 5 
```
- Only show first 5
### Offset
```
offset 5 
```
- Go to the first after 5 aka show 6th to 10th
### FIltering methods
#### With specific keywords
```
select a.* from tutorial a
where a.author = 'Matthew'
```
- Filter out records with matthew as the author
#### Words found inbetween words
```
select a.* from tutorial a
where a.author like '%a%'   
where a.author like 'a%'   
where a.author like '%a'   
```
1. show authors that has a in the middle
2. show authors that start with a
3. show authors that end with a
#### Inbetween dates
1. Method 1
```
select a.* from tutorial a
where submission_date >'2023-01-29' and submission_date <'2023-02-05';
```
- Filter this way to get the dates inbetween

2. Method 2
```
select a.* from tutorial a
where a.submission_date between '2023-01-29' and '2023-02-05';
```
- Will yield same result
#### Additional conditions
```
to add additional conditions just add a and <2nd condition>
```
### Count
```
select count(*) from employee
where 
Gender = 'M'
```
- Get the count of number of Male
```
select Gender, count(*) from employee
where 
Gender = 'M'
union
select Gender, count(*) from employee
where 
Gender = 'F'
```
- Get the count of male and female seperately

### Keys
1. Primary Key
> - Key that is the main identifier of the table usually an ID of sort
```
primary key(id),
```
2. Foreign Key
> - Key that is related to the current table, can be corelated
```
    foreign key (customer_id) references customer(id),
    foreign key (room_id) references room(id)
```
### Combining tables
```
select  resv.id resv_id, cust.id cust_id, cust.first_name, cust.last_name,
resv.start_date,resv.end_date,resv.total_cost,room.price,room.room_type 
from customer cust
inner join reservation resv
on cust.id=resv.customer_id
inner join room
on resv.room_id= room.id;
```
- Tables can be joined together via the use of inner join
### Distinct
```
select distinct cust.first_name, cust.last_name
from customer cust
inner join reservation resv
on cust.id=resv.customer_id
inner join room
on resv.room_id= room.id;
```
- Get unique value from the columns
### Arithmetic
```
select start_date, round(avg(total_cost),2) from reservation
where start_date='2023-02-01';
```
- This will avg the total cost and round to 2 decimal place
### Ascending or descending order
```
select * from customer 
order by first_name asc,last_name asc 
```
1. This will sort the first_name in an ascending order
2. This also has a precedence
3. first_name will be sorted first before sorting last_name
4. Only similar first_name will be reshuffled by the 2nd sorting
### Delete
```
delete from tv_shows where prog_id = 10001;
```
- Deleting rows that contain specific values
## How to get the EER Diagram
1. After the creation of all the tables
2. Go to database at the top
3. Reverse Engineer
4. Select the schema that you want
5. Next and finish
6. You should be able to see the EER diagram