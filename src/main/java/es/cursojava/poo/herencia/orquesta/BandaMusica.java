package es.cursojava.poo.herencia.orquesta;

public class BandaMusica {
    private String nombre;

    public BandaMusica(String nombre) {
        this.nombre = nombre;
    }
    public static void main(String[] args) {
        BandaMusica banda = new BandaMusica("Los Desafinados");
        banda.empezarConcierto();
    }

    private void empezarConcierto() {
        Instrumento[] instrumentos = crearInstrumentos();
        afinarInstrumentos(instrumentos);
        tocarInstrumentos(instrumentos);
    }

    private Instrumento[] crearInstrumentos() {
        System.out.println("Creando instrumentos.");
        Guitarra guitarra = new Guitarra("Gibson", "Cuerda Acústica");
        Guitarra bajo = new Guitarra(4, "Bajo", "Cuerda");
        GuitarraElectrica guitarraElectrica = new GuitarraElectrica("Feder", "Eléctrica", 12.5);
        Piano piano = new Piano("Yamaha", "Cuerda Percutida", 7, "Acústico");
        Tambor tambor = new Tambor("Millenium", "Membrana", "Cuero");

        Instrumento[] instrumentos = {guitarra, bajo, guitarraElectrica, piano, tambor};
        System.out.println("Instrumentos creados. Total: " + instrumentos.length);
        return instrumentos;
    }

    private void afinarInstrumentos(Instrumento[] instrumentos) {
        System.out.println("\n= = = = Afinando los instrumentos = = = =");
        for (Instrumento instrumento : instrumentos) {
            instrumento.afinar();
        }
    }

    private void tocarInstrumentos(Instrumento[] instrumentos) {
        System.out.println("\n- - - - Empiezan a tocar - - - -");
        for (Instrumento instrumento : instrumentos) {            
            if(instrumento instanceof Tambor) {             //instrumento.getClass().getName().equals("Tambor")
                Tambor tambor = (Tambor)instrumento;        //instrumento.getClass().getName().contains("Tambor"), tambien nos serviría.
                tambor.aporrear();
            }else {
                instrumento.tocar();
            }
        }
        System.out.println(" __________________________");
        System.out.println("| El concierto a terminado |");
    }
}
