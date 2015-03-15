package customer.business.model.actions;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import customer.CRUD.CustomerCRUD;
import customer.business.exception.ExistenceEmailException;
import customer.business.logic.CustomerLogic;
import customer.business.model.Customer;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DOTIN SCHOOL 3 on 3/14/2015.
 * @author Samira
 */
public class CustomerAction extends ActionSupport implements ModelDriven {

    private String firstName;
    private String lastName;
    private String age;
    private String email;

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
        boolean valid = CustomerLogic.checkAge(customer);
        if (!valid) {
            addFieldError("age", "illegal age!");
        }
        if (!CustomerLogic.checkEmailFormat(customer.getEmail())) {
            addFieldError("email", "non valid email");
        }
        try {
            if (!CustomerLogic.checkEmailExistence(customer)) {
                addFieldError("email", "duplicate email");
            }
        } catch (ExistenceEmailException e) {
            e.printStackTrace();
        }
    }

    public String addCustomer() throws Exception {
        if (CustomerCRUD.addCustomerToDB(customer)) {
           addActionMessage("***Congratulation***");
            return SUCCESS;
        } else
            return ERROR;
    }


    public String listCustomer() throws Exception {

        SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext().getAttribute("SessionFactory");
        Session session = sessionFactory.openSession();

        customers = session.createQuery("from Customer").list();

        return SUCCESS;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}







