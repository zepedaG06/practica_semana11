package ni.edu.uam.facturacion_prac.run;

import org.openxava.util.*;

/**
 * Execute this class to start the application.
 */

public class facturacion_prac {

	public static void main(String[] args) throws Exception {
		DBServer.start("facturacion_prac-db"); // To use your own database comment this line and configure src/main/webapp/META-INF/context.xml
		AppServer.run("facturacion_prac"); // Use AppServer.run("") to run in root context
	}

}
