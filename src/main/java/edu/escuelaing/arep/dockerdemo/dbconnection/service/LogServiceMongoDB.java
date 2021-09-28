package edu.escuelaing.arep.dockerdemo.dbconnection.service;

import java.util.ArrayList;

import edu.escuelaing.arep.dockerdemo.dbconnection.mongodb.MyDocument;
import edu.escuelaing.arep.dockerdemo.dbconnection.mongodb.MongoDB;
import spark.Request;
import spark.Response;

public class LogServiceMongoDB {
	public static MongoDB mongoDB;
	
	public LogServiceMongoDB(){
		mongoDB = MongoDB.getInstance();
	}
	
	public ArrayList<MyDocument> getString (Request req, Response res) {
		res.type("application/json");
		ArrayList<MyDocument> allStrings = mongoDB.getString();
		ArrayList<MyDocument> lastTenStrings = new ArrayList<>();
		for(int i = allStrings.size()-10; i < allStrings.size(); i++) {
			if(i >= 0) {
				lastTenStrings.add(allStrings.get(i));
			}
		}
	  return lastTenStrings;
	 }
}
