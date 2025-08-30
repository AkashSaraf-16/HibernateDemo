import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args){
        Student s1 = new Student();

        s1.setRollNo(1);
        s1.setsName("Akash S");
        s1.setAge(27);


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        // Update the student with rollno 1
//        session.merge(s1);
//        transaction.commit();

        // Remove the student with rollno 3

        Student studentToDelete = session.find(Student.class, 3);

        session.remove(studentToDelete);
        transaction.commit();



        session.close();
        sf.close();

        System.out.println(s1);
    }
}
