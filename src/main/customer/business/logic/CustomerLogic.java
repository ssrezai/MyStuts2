package customer.business.logic;

import customer.CRUD.CustomerCRUD;
import customer.business.exception.ExistenceEmailException;
import customer.business.model.Customer;

import java.util.List;

/**
 *
 * Created by DOTIN SCHOOL 3 on 3/14/2015.
 */
public class CustomerLogic {
    public static boolean checkAge(Customer customer) {
        return customer.getAge() >= 18;
    }

    public static boolean checkEmailFormat(String email) {
        String pattern = "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$";
        return email.matches(pattern);

    }

    public static boolean checkEmailExistence(Customer customer) throws ExistenceEmailException {
        boolean valid = true;
        String email = customer.getEmail();
        List emailList = CustomerCRUD.getCustomerEmail(customer);
        if (emailList.size() > 1) {
            throw new ExistenceEmailException("");
        } else if (emailList.size() == 1) {
            valid = false;

        } else if (emailList.size() == 0) {
            valid = true;
        }
        return valid;
    }

}
