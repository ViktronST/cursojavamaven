package es.cursojava.hibernate.ejercicios.carreracaballos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.utiles.UtilidadesHibernate;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ServicioCaballo {
    private Validator validator;

    public ServicioCaballo() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public List<CaballoCarrera> filtrarCaballosValidos(List<CaballoCarrera> caballos) {
        List<CaballoCarrera> caballosValidos = new ArrayList<>();

        for (CaballoCarrera caballo : caballos) {
            Set<ConstraintViolation<CaballoCarrera>> violaciones = validator.validate(caballo);

            if (violaciones.isEmpty()) {
                caballosValidos.add(caballo);
            } else {
                System.out.println("Caballo descartado: " + caballo.getNombre());
                for (ConstraintViolation<CaballoCarrera> v : violaciones) {
                    System.out.println("   - " + v.getMessage());
                }
            }
        }
        return caballosValidos;
    }

    public void insertarCaballos(List<CaballoCarrera> caballos) {
        try (Session session = UtilidadesHibernate.getSession()) {
            Transaction tx = session.beginTransaction();
    
            for (CaballoCarrera caballo : caballos) {
                session.persist(caballo);
            }
    
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
