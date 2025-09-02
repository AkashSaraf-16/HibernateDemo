import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

//   Select * from laptop where ram=32 ->SQL
//        from Laptop where ram=32 -> HQL


//        Query query = session.createQuery("from Laptop where brand like 'Apple'", Laptop.class);
        String brand = "Asus";
//        Query query = session.createQuery("from Laptop where brand like ?1", Laptop.class);
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1", Object.class);
        query.setParameter(1, brand);
        List<Object[]> laptops = query.getResultList();


//        Laptop l1=session.get(Laptop.class, 3);
//        System.out.println(laptops);
        for(Object[] data: laptops){
            System.out.println((String)data[0]+ " " + (String)data[1]);
        }
        session.close();

        sf.close();


    }

}