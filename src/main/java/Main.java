import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args){
        Student s1 = new Student();

        s1.setsName("Rahul");
        s1.setRollNo(3);
        s1.setAge(23);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1);
        transaction.commit();

        session.close();
        sf.close();
    }
}
