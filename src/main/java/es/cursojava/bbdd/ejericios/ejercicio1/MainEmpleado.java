package es.cursojava.bbdd.ejericios.ejercicio1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.cursojava.utiles.UtilidadesBD;

public class MainEmpleado {
    private static final String CONSULTA_EMPLEADOS = "SELECT * FROM empleados";

    private static final String CONSULTA_EDAD_EMPLEADOS = "SELECT ID, NOMBRE, EDAD, SALARIO, FECHA_CONTRATACION FROM EMPLEADOS";

    private static final String CONSULTA_EQUIPO_EMPLEADOS = "SELECT e.nombre AS nombre_empleado, eq.nombre AS nombre_equipo" +
                                                            " FROM empleados e" +
                                                            " JOIN equipos_trabajo eq ON e.equipo_id = eq.id";

    private static final String CONSULTA_EQUIPO_Y_EMPLEADOS = "SELECT e.id AS id_empleado, e.nombre AS nombre_empleado, e.edad, e.salario," + 
                                                            " e.departamento_id, e.fecha_contratacion, e.equipo_id," + 
                                                            " eq.id AS id_equipo_trabajo, eq.nombre AS nombre_equipo, eq.fecha_creacion" + 
                                                            " FROM empleados e" + 
                                                            " JOIN equipos_trabajo eq ON e.equipo_id = eq.id";

                                                        
    public static void main(String[] args) {
        MainEmpleado empleado = new MainEmpleado();
        empleado.mostrarEmpleado();
        empleado.crearListaEmpleados();
        empleado.consultaEmpleadoEdad(0,0);
        empleado.crearMapa();
        empleado.crearMapa2();
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

        System.out.println("==============================================================");
        System.out.println(listaEmpleados.size());
    }

    private List<Empleado> consultaEmpleadoEdad(int edadConsultada, double salarioConsultado) {
        List<Empleado> empleados = new ArrayList<>();

        Connection conexion = UtilidadesBD.crearConexion();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            String query = CONSULTA_EDAD_EMPLEADOS + " WHERE 1=1 ";

            if (edadConsultada!=0){
                query+= " AND EDAD>"+edadConsultada;
            }

            if (salarioConsultado!=0){
                query+= " AND SALARIO>"+salarioConsultado;
            }

            System.out.println(query);

            rs = st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                int edad = rs.getInt("EDAD");
                double salario = rs.getDouble("SALARIO");

                System.out.println("Registro.[ id: "+ id + ", nombre: "+ nombre
                + ", edad: " + edad + ", salario: "+salario+ "]");

                Empleado emp = new Empleado(id, nombre, edad, salario);
                empleados.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            UtilidadesBD.cerrarConexion(conexion);
            try {
                st.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("==============================================================");
        System.out.println("Num empleados: " + empleados.size());

        return empleados;
    }

    private Map<String, List<Empleado>> crearMapa() {
        Map<String, List<Empleado>> mapaEmpleados = new HashMap<>();

        Connection conexion = UtilidadesBD.crearConexion();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(CONSULTA_EQUIPO_EMPLEADOS);
    
            while (rs.next()) {
                String nombreEquipo = rs.getString("NOMBRE_EQUIPO");
                String nombreEmpleado = rs.getString("NOMBRE_EMPLEADO");

                // De esta manera NO nos sirve, ya que solo guarda el último empleado por culpa del 'new ArrayList<>()'.
                //mapaEmpleados.put(nombreEquipo, new ArrayList<>());

                mapaEmpleados.putIfAbsent(nombreEquipo, new ArrayList<>());
    
                mapaEmpleados.get(nombreEquipo).add(new Empleado(nombreEmpleado));

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

        System.out.println("==============================================================");
        for (String equipo : mapaEmpleados.keySet()) {
            List<Empleado> empleados = mapaEmpleados.get(equipo);
    
            System.out.print("Nombre Equipo: " + equipo + " - Número Empleados: " + empleados.size() + " - Empleados: ");
    
            for (Empleado emp : empleados) {
                System.out.print(emp.getNombre() + ", ");
            }
            System.out.println();
        }
        
        return mapaEmpleados;
    }
    
    // = = = = = = = = MAPA CON TODOS LOS DATOS DE LA TABLA EQUIPO Y EMPLEADO = = = = = = = = 
    private Map<Equipo, List<Empleado>> crearMapa2() {
        Map<Equipo, List<Empleado>> mapaEmpleados = new HashMap<>();
    
        Connection conexion = UtilidadesBD.crearConexion();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(CONSULTA_EQUIPO_Y_EMPLEADOS);
    
            while (rs.next()) {
                int idEmpleado = rs.getInt("ID_EMPLEADO");
                String nombreEmpleado = rs.getString("NOMBRE_EMPLEADO");
                int edad = rs.getInt("EDAD");
                double salario = rs.getDouble("SALARIO");
                int departamentoId = rs.getInt("DEPARTAMENTO_ID");
                Date fechaContratacion = rs.getDate("FECHA_CONTRATACION");
                int equipoId = rs.getInt("EQUIPO_ID");
            
                int idEquipoTrabajo = rs.getInt("ID_EQUIPO_TRABAJO");
                String nombreEquipo = rs.getString("NOMBRE_EQUIPO");
                Date fechaCreacion = rs.getDate("FECHA_CREACION");
    
                Empleado empleado = new Empleado(idEmpleado, nombreEmpleado, edad, salario, departamentoId, fechaContratacion, equipoId);
                
                Equipo equipo = new Equipo(idEquipoTrabajo, nombreEquipo, fechaCreacion);
    
                mapaEmpleados.putIfAbsent(equipo, new ArrayList<>());
    
                mapaEmpleados.get(equipo).add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                UtilidadesBD.cerrarConexion(conexion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        System.out.println("==============================================================");
        for (Equipo equipo : mapaEmpleados.keySet()) {
            List<Empleado> empleados = mapaEmpleados.get(equipo);
    
            System.out.print("Nombre Equipo: " + equipo.getNombre() + " - Empleado: ");
    
            for (Empleado emp : empleados) {
                System.out.print(emp.getNombre());
            }
            System.out.println();
        }
    
        return mapaEmpleados;
    }

}
