package org.mql.shop.console;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.mql.shop.mongoDB.DataSource;
import org.mql.shop.mongoDB.Database;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;


public class Examples {
	private Database db;
	public Examples() {
		connexion();
		ques01();
		ques02();
		ques03();
		ques04();
		ques05();
		ques06();
		ques07();
	}
	
	public void connexion() {
		DataSource ds = new DataSource("localhost", 27017);
		db = new Database(ds, "tp");
	}
	
	public void exp01() {
		db.selectAll("films");
	}
	
	public void ques01() {
		BasicDBObject doc = new BasicDBObject("annee", 1992);
		System.err.println("1.	Quels sont les films sortis en 1992 ?");
		db.select("films", doc);
	}
	
	public void ques02() {
		BasicDBObject doc = new BasicDBObject("$lt", 2000);
		BasicDBObject query = new BasicDBObject("annee", doc);
		System.err.println("2.	Quels sont les films sortis avant 2000 ?");
		db.select("films", query);
	}
	
	public void ques03() {
		BasicDBObject doc = new BasicDBObject("nom", "clint").append("prenom", "Eastwood");
		BasicDBObject query = new BasicDBObject("realisateur", doc);
		System.err.println("3.	Quels sont les films réalisés par Clint Eastwood ?");
		db.select("films", query);
	}
	
	public void ques04() {
		BasicDBObject doc = new BasicDBObject("realisateur.prenom", "clint");
		System.err.println("4.	Quels sont les films réalisés par quelqu'un prénommé clint?");
		db.select("films", doc);
	}
	
	public void ques05() {
		BasicDBObject doc = new BasicDBObject();
		doc.put("realisateur.prenom", "clint");
		doc.append("annee", new BasicDBObject("$lt", 2000));
		
		System.err.println("5.	Quels sont les films réalisés par quelqu'un prénommé clint avant 2000 ?");
		db.select("films", doc);
	}
	
	public void ques06() {
		BasicDBObject doc = new BasicDBObject();
		doc.put("acteurs",
				new BasicDBObject("nom", "Decaprio").append("prenom", "Leonardo")
		);
		
		System.err.println("6.	Quels sont les films dans lesquels joue Leonardo Decaprio ?");
		db.select("films", doc);
	}
	
	public void ques07() {
		BasicDBObject doc = new BasicDBObject();
		doc.put("acteurs.nom", "Decaprio");
		
		System.err.println("7.	Quels sont les films dans lesquels joue un Decaprio ?");
		db.select("films", doc);
	}
	
	public static void main(String[] args) {
		new Examples();
	}
}
