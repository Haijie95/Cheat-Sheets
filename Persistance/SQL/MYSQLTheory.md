# Theory

## What is MySQL

1. Its a **Relational** data base
2. It has **Fields** which are like columns
3. It has **Record** which are rows
4. It has **Relationships** 1 to many or 1 to 1
5. It has **Schema** which referes to the organisation of data
6. Which leads to **Tables** which are part of the databases

## Data that can be store

1. int
2. char(64)
3. varchar(64)
4. enum('M','F')
> something like gender
5. date
6. blob

## What are key?
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