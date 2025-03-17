package es.cursojava.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class ConexionBaseDatos {
    public static void main(String[] args) {

        conectaOracle2();
    }

    private static void conectaOracle() {
		String url_oracle = "jdbc:oracle:thin:lordvik/password@10.2.1.10:1522:XE";
		String url_oracle2 = "jdbc:oracle:thin:@10.2.1.10:1522:XE";
		String username = "lordvik";
		String password = "password";

		

		try  {
			// Class.forName("oracle.jdbc.driver.OracleDriver");    // Esto es para librarias mas antiguas.
			
            Connection connection = DriverManager.getConnection(url_oracle);
            //Connection connection = DriverManager.getConnection(url_oracle2, username, password);

			if (connection!=null) {
				System.out.println("Conexion establecida");
			}

		} catch (SQLException e) {  // Excepcion que viene de Connection.
			System.err.println("Ha habido un error " + e.getMessage());
            // e.printStackTrace();
		} // catch (ClassNotFoundException e) {    // Excepcion que viene de Class.forName().
		// 	e.printStackTrace();
		// }

	}
	
	// Versión más actualizada.
	private static void conectaOracle2() {
		String url_oracle = "jdbc:oracle:thin:lordvik/password@10.2.1.10:1522:XE";
		String url_oracle2 = "jdbc:oracle:thin:@10.2.1.10:1522:XE";
		String username = "lordvik";
		String password = "password";

        Connection connection = null;
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL(url_oracle);
			
			connection = ods.getConnection();
			if (connection!=null) {
				System.out.println("Conexion establecida");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



	}
}

