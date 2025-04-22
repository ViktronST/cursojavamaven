package es.cursojava.hibernate;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import es.cursojava.hibernate.entities.Cliente;
import es.cursojava.hibernate.entities.Pedido;
import es.cursojava.utiles.HibernateUtil;

public class OneToManyClientes {
    public static void main(String[] args) {


        // Abrir sesión
        Session session = HibernateUtil.getSession();

        try {
            // Iniciar transacción
            session.beginTransaction();

            // Crear cliente
            Cliente cliente1 = new Cliente();
            Cliente cliente2 = new Cliente();
            Cliente cliente3 = new Cliente();

            cliente1.setNombre("Eduardo Mendoza Gimenez");
            cliente2.setNombre("Juan Carlos III");
            cliente3.setNombre("EL PAPA");

            // Crear pedidos
            Pedido pedido11 = new Pedido();
            pedido11.setDescripcionPedido("Silla Gamer normal");
            pedido11.setFechaPedido(LocalDate.of(2025, 2, 12));
            pedido11.setCostePedido(235.99);

            Pedido pedido12 = new Pedido();
            pedido12.setDescripcionPedido("Pc Gamer + juego 'Supermarket 2026'");
            pedido12.setFechaPedido(LocalDate.of(2025, 1, 28));
            pedido12.setCostePedido(1253.25);

            Pedido pedido13 = new Pedido();
            pedido13.setDescripcionPedido("Monitor Gamer barato");
            pedido13.setFechaPedido(LocalDate.of(2025, 2, 2));
            pedido13.setCostePedido(182.5);

            Pedido pedido21 = new Pedido();
            pedido21.setDescripcionPedido("Silla de la Realeza + corona de regalo");
            pedido21.setFechaPedido(LocalDate.of(2001, 12, 25));
            pedido21.setCostePedido(25499.99);

            Pedido pedido22 = new Pedido();
            pedido22.setDescripcionPedido("Pc Gamer Real + juego 'Juego de Tronos'");
            pedido22.setFechaPedido(LocalDate.of(2012, 6, 10));
            pedido22.setCostePedido(50852.63);

            Pedido pedido23 = new Pedido();
            pedido23.setDescripcionPedido("Monitor Gamer Real de 60 pulgadas");
            pedido23.setFechaPedido(LocalDate.of(2018, 11, 1));
            pedido23.setCostePedido(9001.12);

            Pedido pedido24 = new Pedido();
            pedido24.setDescripcionPedido("Calentador de pies Real");
            pedido24.setFechaPedido(LocalDate.of(2025, 1, 1));
            pedido24.setCostePedido(500.21);

            Pedido pedido31 = new Pedido();
            pedido31.setDescripcionPedido("Silla Gamer Papal acolchada con plumas de angel");
            pedido31.setFechaPedido(LocalDate.of(2020, 4, 1));
            pedido31.setCostePedido(7300.00);

            Pedido pedido32 = new Pedido();
            pedido32.setDescripcionPedido("Pc Gamer Papal + juego 'El Vaticano 2: la resurrección'");
            pedido32.setFechaPedido(LocalDate.of(2021, 7, 8));
            pedido32.setCostePedido(33333.33);

            Pedido pedido33 = new Pedido();
            pedido33.setDescripcionPedido("Monitor Gamer Papal Anticristos");
            pedido33.setFechaPedido(LocalDate.of(2006, 6, 6));
            pedido33.setCostePedido(666.66);

            Pedido pedido34 = new Pedido();
            pedido34.setDescripcionPedido("La Biblia, edición bolsillo (10000 páginas)");
            pedido34.setFechaPedido(LocalDate.of(2024, 3, 17));
            pedido34.setCostePedido(1015.4);

            Pedido pedido35 = new Pedido();
            pedido35.setDescripcionPedido("Joyería Papal");
            pedido35.setFechaPedido(LocalDate.of(2006, 6, 6));
            pedido35.setCostePedido(150234.99);

            // Agregar libros al autor
            cliente1.getListaPedido().add(pedido11);
            cliente1.getListaPedido().add(pedido12);
            cliente1.getListaPedido().add(pedido13);

            cliente2.getListaPedido().add(pedido21);
            cliente2.getListaPedido().add(pedido22);
            cliente2.getListaPedido().add(pedido23);
            cliente2.getListaPedido().add(pedido24);

            cliente3.getListaPedido().add(pedido31);
            cliente3.getListaPedido().add(pedido32);
            cliente3.getListaPedido().add(pedido33);
            cliente3.getListaPedido().add(pedido34);
            cliente3.getListaPedido().add(pedido35);

            // Guardar autor (Cascade.ALL guarda los libros también)
            session.persist(cliente1);
            session.persist(cliente2);
            session.persist(cliente3);

            // Commit
            session.getTransaction().commit();

            // Nueva sesión para consultar
            session.beginTransaction();

            List<Cliente> listaCliente = session.createQuery("from Cliente", Cliente.class).getResultList();

            for (Cliente cliente : listaCliente) {
                System.out.println("Cliente: " + cliente.getNombre());
                for (Pedido pedido : cliente.getListaPedido()) {
                    System.out.println("  Pedidos: " + pedido.getDescripcionPedido());
                }
            }

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
