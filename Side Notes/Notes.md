# Useful stuff
1. Converting to JsonObject
```
public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("[Field name]", [Value])
                .add("comment", getComment())
                .build();
}
```
2. Document to object
```
public static Comment create(Document d) {
        Comment c = new Comment();
        c.setCharId(d.getObjectId("charId").toString());
        c.setComment(d.getString("comment"));
        return c;
    }
```
3. Object to Document
```
public Document toDocument() {
		Document doc = new Document();
		doc.put("c_id", getCId());
		doc.put("user", getUser());
		doc.put("rating", getRating());
		doc.put("c_text", getCText());
		return doc;
	}
```
4. UUID
```
        String Id = UUID.randomUUID().toString().substring(0, 8);
```