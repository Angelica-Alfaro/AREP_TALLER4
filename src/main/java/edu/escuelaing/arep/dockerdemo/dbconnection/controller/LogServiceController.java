package edu.escuelaing.arep.dockerdemo.dbconnection.controller;

import static spark.Spark.get;
import static spark.Spark.post;

import edu.escuelaing.arep.dockerdemo.dbconnection.service.LogServiceMongoDB;

public class LogServiceController {
	
	public LogServiceController(LogServiceMongoDB myLogServiceMongoDB) {
		get("hello", (req,res) -> "Hello Docker!");
        get("string", (req,res) -> myLogServiceMongoDB.read(req,res));
        post("string", (req, res) -> myLogServiceMongoDB.create(req,res));
	}
}
