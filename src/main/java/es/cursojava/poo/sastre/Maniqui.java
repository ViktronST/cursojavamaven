package es.cursojava.poo.sastre;

public class Maniqui {
    //Creamos la clase maniquí con los atributos id (identificador), pantalón, camisa y vestido.
    private int id;
    private Pantalon pantalon;
    private Camisa camisa;
    private Vestido vestido;

    //Creamos 3 cosntructores
    // 1. Contructor que inicialice con pantalón y camisa.
    public Maniqui(int id, Pantalon pantalon, Camisa camisa) {
        this.id = id;
        this.pantalon = pantalon;
        this.camisa = camisa;
    }

    // 2. Contructor que inicialice con vestido.
    public Maniqui(int id, Vestido vestido) {
        this.id = id;
        this.vestido = vestido;
    }

    // 3. Constructor por defecto
    public Maniqui(int id) {
        this.id = id;
    }

    //Desreferenciamos a los objetos maniqui para desvestirlos
    public void desvestir(){
        this.camisa = null;
        this.pantalon = null;
        this.vestido = null;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    // public void setId(int id) {          //Para no cambiar el id
    //     this.id = id;
    // }

    public Pantalon getPantalon() {
        return pantalon;
    }

    public void setPantalon(Pantalon pantalon) {
        this.pantalon = pantalon;
    }

    public Camisa getCamisa() {
        return camisa;
    }

    public void setCamisa(Camisa camisa) {
        this.camisa = camisa;
    }

    public Vestido getVestido() {
        return vestido;
    }

    public void setVestido(Vestido vestido) {
        this.vestido = vestido;
    }

}
