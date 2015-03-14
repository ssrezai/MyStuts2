package customer.business.model.actions;

/**
 * Created by DOTIN SCHOOL 3 on 3/14/2015.
 */

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import customer.CRUD.CustomerCRUD;
import customer.business.logic.CustomerLogic;
import customer.business.model.Customer;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DOTIN SCHOOL 3 on 3/14/2015.
 */
public class CustomerAction extends ActionSupport implements ModelDriven {
    Customer customer = new Customer();
    List<Customer> customers = new ArrayList<Customer>();

    @Override
    public Object getModel() {
        return customer;
    }

    public String execute() {
        return "success";
    }

    public void validate() {
        if (this.customer.getFirstName() == null || this.customer.getFirstName().equals("")) {
            addFieldError("firstName", "please enter your name");
        }
        boolean valid=CustomerLogic.checkAge(customer);
        if (!valid) {
            addFieldError("age", "illegal age!");
        }
    }

    public String addCustomer() throws Exception {
        if(CustomerCRUD.addCustomerToDB(customer))
        {
            return SUCCESS;
        }
        else
            return ERROR;
    }


    public String listCustomer() throws Exception {

        SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();

        customers = session.createQuery("from Customer").list();

        return SUCCESS;

    }
}







