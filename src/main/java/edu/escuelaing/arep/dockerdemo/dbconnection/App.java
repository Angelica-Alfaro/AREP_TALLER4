package edu.escuelaing.arep.dockerdemo.dbconnection;
import edu.escuelaing.arep.dockerdemo.dbconnection.controller.LogServiceController;
import edu.escuelaing.arep.dockerdemo.dbconnection.service.LogServiceMongoDB;

import static spark.Spark.*;

/**
 * Communication  using java network management libraries
 * @author Angélica
 *
 */
public class App {
	
	/**
	 * Start the web server
	 * @param args - server connection
	 */
	public static void main(String[] args) {
		port(getPort());
		new LogServiceController( new LogServiceMongoDB() ); 
	}

	/**
	 * This method reads the default port as specified by the PORT variable in the
	 * environment.
	 *
	 * Heroku provides the port automatically so you need this to run the project on
	 * Heroku.
	 */
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; 
	}
}