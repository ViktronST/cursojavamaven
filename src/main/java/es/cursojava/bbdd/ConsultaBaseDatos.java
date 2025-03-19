package es.cursojava.bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.cursojava.utiles.UtilidadesBD;

public class ConsultaBaseDatos {
    private static final String CONSULTA_EMPLEADOS = "SELECT id, nombre, edad, salario FROM empleados";
    private static final String CONSULTA_EMPLEADOS_EDAD = "SELECT id, nombre, edad FROM empleados WHERE edad > 30";
    private static final String CONSULTA_EMPLEADOS_SALARIO = "SELECT id, nombre, edad, salario FROM empleados WHERE edad > 30 ORDER BY salario DESC";
    public static void main(String[] args) {
        
        Connection conexion = UtilidadesBD.crearConexion();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(CONSULTA_EMPLEADOS_SALARIO);   // .executeQuery() ejecuta la consulta.
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                double salario = rs.getDouble("salario");

                System.out.println("Registro [ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Salario: " + salario + "]");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilidadesBD.cerrarConexion(conexion);
            try {
                st.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("TERMINA");
        
    }
}
