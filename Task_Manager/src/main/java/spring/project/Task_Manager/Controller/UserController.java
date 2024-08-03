package spring.project.Task_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.project.Task_Manager.Service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/signup")
    public ResponseEntity<?> signUp(String userName, String password){
        return null;
    }

    @PostMapping("user/login")
    public ResponseEntity<?> logIn(String userName, String password) {
        return null;
    }


}
