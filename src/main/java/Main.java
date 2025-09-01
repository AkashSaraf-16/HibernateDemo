import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook Pro");
        l3.setRam(16);

        Alien a1 = new Alien();
        a1.setId(1);
        a1.setName("Virendra");
        a1.setTech("JS");

        Alien a2 = new Alien();
        a2.setId(2);
        a2.setName("Akash");
        a2.setTech("DSA");

        Alien a3 = new Alien();
        a3.setId(3);
        a3.setName("Mintu");
        a3.setTech("Java");

        a1.setLaptops(Arrays.asList(l2, l3));
        a2.setLaptops(Arrays.asList(l2, l1));
        a3.setLaptops(Arrays.asList(l3));

        l1.setAliens(Arrays.asList(a2));
        l2.setAliens(Arrays.asList(a1, a2));
        l3.setAliens(Arrays.asList(a3));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        transaction.commit();

        session.close();
        sf.close();
    }
}
