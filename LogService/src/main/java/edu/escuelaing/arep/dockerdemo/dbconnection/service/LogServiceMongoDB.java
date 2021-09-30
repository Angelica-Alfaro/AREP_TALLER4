package edu.escuelaing.arep.dockerdemo.dbconnection.service;

import java.util.ArrayList;

import com.google.gson.Gson;

import edu.escuelaing.arep.dockerdemo.dbconnection.mongodb.MyDocument;
import edu.escuelaing.arep.dockerdemo.dbconnection.mongodb.MongoDB;
import spark.Request;
import spark.Response;

public class LogServiceMongoDB {
	public static MongoDB mongoDB;
	
	public LogServiceMongoDB(){
		mongoDB = MongoDB.getInstance();
	}
	
	public String read (Request req, Response res) {
		Gson gson=new Gson();
		res.type("application/json");
		ArrayList<MyDocument> allStrings = MongoDB.read();
		ArrayList<MyDocument> lastTenStrings = new ArrayList<>();
		for(int i = allStrings.size() - 1; i >= allStrings.size() - 10; i--) {
			if(i >= 0) {
				lastTenStrings.add(allStrings.get(i));
			}
		} 
		return gson.toJson(lastTenStrings);
	 }

	public String create(Request req, Response res) {
		MongoDB.create(req.body());
		return read(req, res);
	}
}
