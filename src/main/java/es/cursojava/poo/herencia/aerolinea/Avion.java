package es.cursojava.poo.herencia.aerolinea;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor  //Constructor vacío
@ToString
public class Avion {
    private int numTurbinas;
    private String marca;
    private int capacidad;
}
