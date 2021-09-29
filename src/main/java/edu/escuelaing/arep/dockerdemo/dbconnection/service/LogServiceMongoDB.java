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
	
	public ArrayList<MyDocument> read (Request req, Response res) {
		res.type("application/json");
		ArrayList<MyDocument> allStrings = MongoDB.read();
		ArrayList<MyDocument> lastTenStrings = new ArrayList<>();
		for(int i = allStrings.size() - 1; i >= allStrings.size() - 10; i--) {
			if(i >= 0) {
				lastTenStrings.add(allStrings.get(i));
			}
		}
	  return lastTenStrings;
	 }

	public ArrayList<MyDocument> create(Request req, Response res) {
		MongoDB.create(req.body());
		return read(req, res);
	}
}
