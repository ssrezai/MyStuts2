package customer.business.logic;

import customer.business.model.Customer;

/**
 * Created by DOTIN SCHOOL 3 on 3/14/2015.
 */
public class CustomerLogic {
    public static boolean checkAge(Customer customer) {
        if (customer.getAge() < 18) {
            return false;
        } else
            return true;
    }
//    public static boolean checkEmailFormat(String email)
//    {
//        boolean result = true;
//        try {
//            InternetAddress emailAddr = new InternetAddress(email);
//            emailAddr.validate();
//        } catch (AddressException ex) {
//            result = false;
//        }
//        return result;
//    }

}
