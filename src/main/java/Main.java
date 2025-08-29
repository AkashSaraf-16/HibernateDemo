import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args){
        Student s1 = new Student();

        s1.setsName("Akash");
        s1.setRollNo(1);
        s1.setAge(27);

        Configuration cnfg = new Configuration();
        cnfg.addAnnotatedClass(Student.class);
        cnfg.configure();


        SessionFactory sf = cnfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(s1);
        transaction.commit();
    }
}
