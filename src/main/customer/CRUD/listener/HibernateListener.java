package customer.CRUD.listener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Created by DOTIN SCHOOL 3 on 3/14/2015.
 *
 */
public class HibernateListener implements ServletContextListener {
    private Configuration config;
    private SessionFactory factory;
    private String path = "/hibernate.cfg.xml";
    private static Class clazz = HibernateListener.class;
    public static final String KEY_NAME = clazz.getName();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {

            URL url = HibernateListener.class.getResource("/hibernate.cfg.xml");
            Configuration config = new Configuration();
            config.configure(url);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties()).build();
            SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
            servletContextEvent.getServletContext().setAttribute("SessionFactory", sessionFactory);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        SessionFactory sessionFactory = (SessionFactory) sce.getServletContext().getAttribute("SessionFactory");
        sessionFactory.close();
    }
}
