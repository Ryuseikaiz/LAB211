package common;

import Model.DataModel;

public class Algorithm {

    Validation validation = new Validation();
    DataModel model=new DataModel();
    
    public void checkPhoneNumber() {
        System.out.print("Phone number: ");
        String phoneNumber = validation.checkInputPhone();
        model.setPhoneNumber(phoneNumber);
    }

    public void checkEmail() {
        System.out.print("Email: ");
        String email = validation.checkInputEmail();
        model.setEmail(email);
    }

    public void checkDate() {
        System.out.print("Date: ");
        String date = validation.checkInputDate();
        model.setDate(date);
    }
}
