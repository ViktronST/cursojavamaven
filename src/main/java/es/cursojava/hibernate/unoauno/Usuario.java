package es.cursojava.hibernate.unoauno;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/*El lado propietario de la relación es el que tiene la anotación @JoinColumn.
mappedBy se usa en el lado no propietario, indicando el atributo en el otro lado que gestiona la relación.
Puedes usar cascade = CascadeType.ALL para que al guardar un Usuario, se guarde también su Direccion.
*/
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    /*
     * PERSIST: Guarda la dirección al guardar el usuario.
     * MERGE: Actualiza la dirección al actualizar el usuario.
     * REMOVE: Elimina la dirección al eliminar el usuario.
     * REFRESH: Actualiza la dirección al refrescar el usuario.
     * DETACH: Desvincula la dirección del usuario.
     * ALL: Aplica todos los cambios anteriores a la dirección.
     * NO: No aplica ningún cambio a la dirección.
     */

    // CascadeType.ALL : Sigue cualquier cambio que se haga en el usuario y lo aplica a la dirección.
    // fetch = FetchType.LAZY : Carga perezosa de la dirección, es decir, no se carga la dirección hasta que se accede a ella.
    @OneToOne(cascade = CascadeType.ALL, fetch = jakarta.persistence.FetchType.LAZY) // Carga perezosa (Lazy) de la dirección.
    //@OneToOne(cascade = CascadeType.ALL, fetch = jakarta.persistence.FetchType.EAGER) // Carga ansiosa (Eager) de la dirección.
    // Elimina la dirección SÓLO al eliminar el usuario.
    //@OneToOne(cascade = CascadeType.REMOVE)   
    //@OneToOne
    
    @JoinColumn(name = "direccion_id") // crea la foreign key en la tabla Usuario
    private Direccion direccion;

    public Usuario() {
    }

    public Usuario(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    
}