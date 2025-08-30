import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args){
        Alien a1 = new Alien();
        a1.setId(1);
        a1.setName("Virendra");
        a1.setTech("JS");


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        transaction.commit();

        session.close();
        sf.close();
    }
}
