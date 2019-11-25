package org.mql.shop.mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.DB;

public class DataSource {
	private String host;
	private int port;
	
	public DataSource() {
		
	}

	public DataSource(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public MongoClient getConnexion() {
		try {
			MongoClient mongoClient = new MongoClient(host, port);
			System.out.println("Connexion bien établie!");
			return mongoClient;
		}
		catch (Exception e) {
			System.out.println("Erreur de connexion : " + e.getMessage());
			return null;
		}
	}
}
