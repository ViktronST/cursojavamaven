package es.cursojava.ficheros;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
    	LocalDateTime datetime = LocalDateTime.now();   // Nos da la fecha local del equipo.
        System.out.println(datetime);
    	System.out.println(datetime.getYear());
    	System.out.println(datetime.getMonthValue());
    	//System.out.println(datetime.getMonth());
    	
    	Instant instant = Instant.now();    // Da la hora zulú, GPT-0, la del meridiano 0.
    	System.out.println(instant);        // instant tiene diferentes métodos a datetime.
    	//Ruta relativa a la carpeta del proyecto
        String nombreArchivo2 = "./recursos/java3.txt";  // SIEMPRE hay que acostumbrarse a poner rutas RELATIVAS.
        
        String fecha1 = datetime.getYear() + "_" + datetime.getMonthValue() + "_" + datetime.getDayOfMonth();

        LocalDate date = LocalDate.now();
        String fecha2 = "" + date;

        Date fecha = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String fecha3 = df.format(fecha);

        String nombreArchivo = "./recursos/Viktor_" + fecha3 + ".txt"; 

        

        ArchivoServicio service = new ArchivoServicio();
        //service.mostrarContenidoDirectorio("C:\\Users\\Tardes\\");
        service.crearArchivo(nombreArchivo);
        System.out.println(nombreArchivo);
    }
}
