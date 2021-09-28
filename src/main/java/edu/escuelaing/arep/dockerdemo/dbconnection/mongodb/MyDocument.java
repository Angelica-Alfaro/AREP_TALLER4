package edu.escuelaing.arep.dockerdemo.dbconnection.mongodb;

import java.util.Date;

public class MyDocument {
	
	String string;
	Date date;
	
	public MyDocument(){}
	
	public  MyDocument(String string, Date date) {
		this.string = string;
		this.date = date;
	}
	
	public  MyDocument(String string) {
		this.string = string;
		this.date = new Date();
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
