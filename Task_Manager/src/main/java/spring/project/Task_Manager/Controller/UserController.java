package spring.project.Task_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.project.Task_Manager.Model.User;
import spring.project.Task_Manager.Service.UserService;

import java.util.Collections;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity signUp(@RequestParam String username, String password){
        User user = userService.createUser(username,password);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@ RequestParam String username, String password) {
        String token = userService.loginUser(loginDTO);
        return ResponseEntity.ok(Collections.singletonMap("token",token));
    }


}
