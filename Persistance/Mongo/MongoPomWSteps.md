# Pom needed

1. Spring Data MongoDB
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>
```
# Steps needed

## In the repository
1. Import the mongo template
```
@Autowired
private MongoTemplate mongoTemplate;
```
2. Create the method (Important thing to note is you are taking in a document)
```
public List<Document> findTvShowsByLanguage(String lang){
        //create a criteria - {language}
        Criteria criteria = Criteria.where(FIELD_LANGUAGE).is(lang);

        //create a query
        Query query = Query.query(criteria);
        
        //perform the query
        
        // List<Document> results = 
        return template.find(query,Document.class,COLLECTION_TVSHOWS);
    }
```
3. Set the Criteria and throw it into query
```
public List<Document> findTvShowByType(String type, int limit, int skip){

            Criteria criteria = Criteria.where(FIELD_TYPE).regex(type,"i");
            
            //create a query and sort
            Query query = Query.query(criteria)
                .with(Sort.by(Direction.DESC,FIELD_RATING_AVERAGE))
                .limit(20)
                .skip(skip);

            //projections
            query
                .fields()
                .exclude(FIELD_UNDERSCORE_ID)
                .include(FIELD_ID,FIELD_NAME,FIELD_RATING_AVERAGE);
            
            return template.find(query,Document.class,COLLECTION_TVSHOWS);
    }
```
4. To insert (day27)
```
public void insertComment(Comment comment) {
        //convert to document
        Document doc = comment.toDocument();
        //insert into collection
		template.insert(doc, COLLECTION_COMMENTS);
    }

//alternatively (to return the id)
public String insertComment(Comment comment) {
        //convert to document
        Document doc = comment.toDocument();
        String id = "";
        //insert into collection
		template.insert(doc, COLLECTION_COMMENTS);
        return id = doc .getObjectId()
    }
```
## In the model
1. Convert document to the model (Can be changed according to what is needed)
```
public static TVShow create (Document doc){
        TVShow tvShow= new TVShow();
		//adjustable 
        tvShow.setId(doc.getInteger(FIELD_ID));
        tvShow.setName(doc.getString(FIELD_NAME));
        tvShow.setUrl(doc.getString(FIELD_URL));
        tvShow.setType(doc.getString(FIELD_TYPE));
        return tvShow;
    }
```
2.


## In the service
