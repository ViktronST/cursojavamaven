package es.cursojava.bbdd.ejericios.ejercicio1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import es.cursojava.utiles.Utilidades2;
import es.cursojava.utiles.UtilidadesBD;

public class MainEmpleado {
    private static final String CONSULTA_EMPLEADOS = "SELECT * FROM empleados";
    public static void main(String[] args) {
        MainEmpleado empleado = new MainEmpleado();
        empleado.mostrarEmpleado();
        empleado.crearListaEmpleados();
        empleado.pedirEdadEmpleado();
        empleado.mostrarEdadEmpleado();
    }

    private void mostrarEmpleado() {
        Connection conexion = UtilidadesBD.crearConexion();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(CONSULTA_EMPLEADOS);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                double salario = rs.getDouble("salario");
                int departamentoId = rs.getInt("departamento_id");
                Date fechaContratacion = rs.getDate("fecha_contratacion");
                int equipoId = rs.getInt("equipo_id");

                System.out.println("\nRegistro [\n\tID: " + id + ", \n\tNombre: " + nombre + ", \n\tEdad: " + edad 
                                    + ", \n\tSalario: " + salario + ", \n\tDepartamento_ID: " + departamentoId 
                                    + ", \n\tFecha de contratacion: " + fechaContratacion + ", \n\tEquipo_ID: " + equipoId + "]");
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

        System.out.println("\nTERMINA");
    }

    private void crearListaEmpleados() {
        List<Empleado> listaEmpleados = new ArrayList<>();

        Connection conexion = UtilidadesBD.crearConexion();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(CONSULTA_EMPLEADOS);
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                double salario = rs.getDouble("salario");
                int departamentoId = rs.getInt("departamento_id");
                Date fechaContratacion = rs.getDate("fecha_contratacion");
                int equipoId = rs.getInt("equipo_id");

                Empleado empleado = new Empleado(id, nombre, edad, salario, departamentoId, fechaContratacion, equipoId);
                listaEmpleados.add(empleado);
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

        System.out.println(listaEmpleados.size());
    }

    private int pedirEdadEmpleado() {
        Utilidades2.pideDatoNumerico("Introduzca una edad: ");
        return edad;
    }

    private void mostrarEdadEmpleado() {
        

    }
}
