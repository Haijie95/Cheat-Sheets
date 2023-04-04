# SQL statements to call
1. Get all (R) `public static final String selectAllSQL="select * from accounts";`
>   ```public List<Accounts> getAllAccount(){
        return jdbcTemplate.query(selectAllSQL, BeanPropertyRowMapper
        .newInstance(Accounts.class));
    }
    ```
2. Search by Id `public static final String findByAccIdSQL="select * from accounts where account_id= ?";`
>   ```
    public Accounts findByName(String accId){
        return jdbcTemplate.queryForObject(findByAccIdSQL,BeanPropertyRowMapper
        .newInstance(Accounts.class),accId);
    }
    ```
3. Update (U) `public static final String withdrawByAccId="update accounts set balance=balance-? where account_id=?";`
>   ```
    public Boolean withdraw(Accounts acc, Float amount){
        Integer result = jdbcTemplate.update(withdrawByAccId,amount,acc.getAccountId());
        return result > 0?true:false;
    }
    ```
4. Update `public static final String depositByAccId="update accounts set balance=balance+? where account_id=?";`
> Similar to above
5. Insert record (C) `insert into accounts values ("V9L3Jd1BBI","fred",100.00);`
> Similar to above

# Steps to do sql
1. Create schema
2. Create table
3. You may begin
4. To call in repo, first autowire the template
```
@Autowired
    JdbcTemplate jdbcTemplate;
```
