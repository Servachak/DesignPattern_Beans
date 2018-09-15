package servachak.controller;

import com.servachak.model.Model;
import com.servachak.view.LoginFormEvent;
import com.servachak.view.LoginListener;
import com.servachak.view.View;

public class Controller implements LoginListener {

    public Controller(View view, Model model) {
    }

    @Override
    public void loginPerformed(LoginFormEvent event) {

        if (event.getPassword().equals(event.getConfirmPassword())){

            System.out.println("Login event received \nName :" +  event.getName().toUpperCase() +"\npassword: " + event.getPassword()+
                    "\nconfirm password :" + event.getConfirmPassword());
        }else {
            System.out.println("not equal passwords");
        }
    }
}
