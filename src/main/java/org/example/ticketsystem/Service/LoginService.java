package org.example.ticketsystem.Service;

import org.example.ticketsystem.Entity.Login;
import org.example.ticketsystem.Repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Login login(String email, String password) {
        Login loginUser = new Login();

        if (loginRepository.existsByEmail(email)) {
            //right email

            if (loginRepository.existsByPassword(password)) {
                //logged in

            } else {
                //password is wrong

            }
        } else {
            //email does not exist
        }

        return loginRepository.save(loginUser);
    }

    public Login RegisterService(String email, String password) {

        Login newUser = new Login();
        if (loginRepository.existsByEmail(email)) {
            //this email is already existing
        }
        else {
            newUser.setEmail(email);
            newUser.setPassword(password);
        }

        return loginRepository.save(newUser);
        //Succsesfully created

    }
}
