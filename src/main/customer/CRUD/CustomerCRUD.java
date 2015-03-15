package customer.CRUD;

import customer.business.model.Customer;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.management.Query;
import java.util.List;

/**
 * Created by DOTIN SCHOOL 3 on 3/14/2015.
 */
public class CustomerCRUD {
    public static boolean addCustomerToDB(Customer customer) throws Exception {
        SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();
        boolean done = false;
        try {
            Transaction tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
            List<Customer> customers = null;
            customers = session.createQuery("from Customer").list();
            done = true;

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            session.close();
            return done;
        }
    }

    public static List getCustomerEmail(Customer customer) {
        SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();
        List results=null;
        try {
            String hql = "FROM Customer C WHERE C.email='" + customer.getEmail() + "'";
             results = session.createQuery(hql).list();

        } finally {
            session.close();
            return results;
        }

    }
}
