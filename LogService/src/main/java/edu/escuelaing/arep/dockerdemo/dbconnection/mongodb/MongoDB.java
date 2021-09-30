package edu.escuelaing.arep.dockerdemo.dbconnection.mongodb;

import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
	
	private static final MongoDB _instance = new MongoDB();

	public static MongoDB getInstance() {
		return _instance;
	}
	
	public static ArrayList<MyDocument> read() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://db")) {
        	
            MongoDatabase myMongoDB = mongoClient.getDatabase("myMongoDB");
            MongoCollection<Document> myCollection = myMongoDB.getCollection("myCollection");
            
            ArrayList<MyDocument> allStrings = new ArrayList<>();
            for(Document document : myCollection.find()) {
            	allStrings.add(new MyDocument((String)document.get("string"),(Date)document.get("date")));
            }
            return allStrings;
        }
	}

	public static void create(String string) {
		 try (MongoClient mongoClient = MongoClients.create("mongodb://db")) {
			 
             MongoDatabase myMongoDB = mongoClient.getDatabase("myMongoDB");
	         MongoCollection<Document> myCollection = myMongoDB.getCollection("myCollection");
	         
	         Document document = new Document("_id", new ObjectId());
	         MyDocument myDocument = new MyDocument(string);
	         document.append("string", myDocument.getString())
	                 .append("date", myDocument.getDate());

	         myCollection.insertOne(document);
	    }
	}
}
