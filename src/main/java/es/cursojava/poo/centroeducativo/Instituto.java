package es.cursojava.poo.centroeducativo;

public class Instituto {
    public static void main(String[] args) {
        //Creamos un alumno con el constructor por defecto
        Alumno alumno1 = new Alumno("María", "Gómez", 17, 10, "mariago1907@gmail.com");

        //Creamos las asignaturas y se las damos al alumno2
        Alumno alumno2 = new Alumno("Pedro", "Martínez", 19, 5, "martinezpedro@gmail.com");
        String[] asignaturasAlumno2 = {"Matemáticas", "Lengua", "Inglés", "Física", "Química", "Historia"};
        alumno2.setAsignaturas(asignaturasAlumno2);

        //Creamos un alumno con asignaturas de forma directa pasando todos los datos al constructor
        String[] asignaturasAlumno3 = {"Matemáticas", "Lengua", "Inglés", "Física", "Química", "Filosofía"};
        Alumno alumno3 = new Alumno("Ana", "Sánchez", 20, 3, "sanchez2222@gmail.com", asignaturasAlumno3);

        //Creamos un alumno dándole los datos de forma directa
        Alumno alumno4 = new Alumno();
        alumno4.setNombre("Juan");
        alumno4.setApellido("José Pérez");
        alumno4.setEdad(18);
        alumno4.setNotaMedia(7);
        alumno4.setEmail("juanjo2006@gmail.com");
        alumno4.setAsignaturas(new String[]{"Matemáticas", "Lengua", "Inglés", "Física", "Química", "Historia", "Educación Física"});

        //Creamos un array de alumnos
        // String[] alumnos = new String[4];         
        // alumnos[0] = alumno1.getNombre();        //De esta manera solo se guarda el nombre del alumno
        // alumnos[1] = alumno2.getNombre();        
        // alumnos[2] = alumno3.getNombre();        
        // alumnos[3] = alumno4.getNombre();        
        
        //Creamos un array de alumnos
        Alumno[] alumnos = {alumno1, alumno2, alumno3, alumno4};

        //Recorremos el array de alumnos
        
        //for tradcional
        for (int i = 0; i < alumnos.length; i++) {
            Alumno alumno = alumnos[i];
            System.out.println(alumno.getNombre());     //System.out.println(alumnos[i].getNombre());
            alumno.estudiar();

            String[] asigns = alumno.getAsignaturas();
            // for (String asignatura : asigns) {
            //     System.out.println("\t" + asignatura);
            // }
            if(asigns!=null) {
                for (String asignatura : asigns) {
                    System.out.println("\t" + asignatura);
                }
            }
        }
        
        //for each
        // for (Alumno alunmno : alumnos) {
        //     Alumno alumno = alumnos[i];
        //     System.out.println(alumno.getNombre);
        //     alumno.estudiar();

        //     String[] asigns = alumno.getAsignaturas();
        //     if(asigns!=null) {
        //         for (String asignatura : asigns) {
        //             System.out.println("\t" + asignatura);
        //         }
        //     }        
        // }
    }
}
