package org.mql.shop.mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;

public class Database {
	private DataSource dataSource;
	private DB db;
	private DBCollection coll;
	
	public Database(DataSource dataSource, String dbName) {
		this.dataSource = dataSource;
		db = dataSource.getConnexion().getDB(dbName);
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void connexion(String collectionName) {
		coll = db.getCollection(collectionName);
	}
	
	public void selectAll(String collectionName) {
		connexion(collectionName);
		
		DBCursor cursor = coll.find();
		
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	
	public void select(String collection, BasicDBObject searchQuery) {
		connexion(collection);
		DBCursor cursor = coll.find(searchQuery);
		
		while (cursor.hasNext()) {
		    System.out.println(cursor.next());
		}
	}
	
	public DBCollection getColl(String collectionName) {
		connexion(collectionName);
		return coll;
	}
}
