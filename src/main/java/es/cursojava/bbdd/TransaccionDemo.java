package es.cursojava.bbdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.cursojava.bbdd.ejericios.ejercicio1.Empleado;
import es.cursojava.utiles.UtilidadesBD;

public class TransaccionDemo {

    public static void main(String[] args) {
        TransaccionDemo demo = new TransaccionDemo();
        demo.testTransaction();
    }


    public static void testTransaction(Empleado empleado) throws SQLException {
        int contador = 100_000;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // Esto nos permite trabajar con el Date de java en el try, mientras tenemos importada 'java.sql.Date'.
            java.util.Date fecha = new java.util.Date();
            
            

            for (int i = 0; i < 1_000_000; i++) {
                
                conn = UtilidadesBD.crearConexion();
                conn.setAutoCommit(false);

                // Borramos la tabla.
                String delete = "DELETE FROM EMPLEADOS";
                ps = conn.prepareStatement(delete);
                int totalBorrados = ps.executeUpdate();
                System.out.println("Registros Eliminados: " + totalBorrados);
                ps.close();
                
                String insert = "INSERT INTO EMPLEADOS VALUES (?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(insert);
                
                ps.setInt(1, i);
                ps.setString(2, "nombre");
                ps.setInt(3, (int)(Math.random()*100));
                ps.setDouble(4, Math.random()*10_000);
                ps.setInt(5, 2);
                ps.setDate(6, null);
                ps.setInt(7, (int)(Math.random()*30/10));

                ps.executeUpdate();

                // if (i==contador) {
                //     contador += 100_000;
                // }

                if (i%contador==0) {
                    java.util.Date fecha2 = new java.util.Date();
                    long tiempoFinal = fecha2.getTime() - fecha.getTime();
                    System.out.println("Tiempo transcurrido para " + i + " registros = " + tiempoFinal);
                    Thread.sleep(2000);
                }

                if (i==999_999) {
                    throw new SQLException("Si");
                }

                ps.close();
            }

            conn.commit();
        } catch (Exception sqle) {

            System.out.println("Error" + sqle.getMessage());

            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }finally {

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

}
