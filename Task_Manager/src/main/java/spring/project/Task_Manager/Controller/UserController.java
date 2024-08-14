package spring.project.Task_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.project.Task_Manager.DTO.AuthResponse;
import spring.project.Task_Manager.DTO.LogInRequest;
import spring.project.Task_Manager.DTO.SignUpRequest;
import spring.project.Task_Manager.Exception.EmailAlreadyRegisteredException;
import spring.project.Task_Manager.Model.User;
import spring.project.Task_Manager.Service.UserService;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest) throws EmailAlreadyRegisteredException {
        userService.createUser(signUpRequest);
        return ResponseEntity.ok("You have been Successfully Registered, Login to Use the Application");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> logIn(@ RequestBody LogInRequest logInRequest) {
        return ResponseEntity.ok(userService.loginUser(logInRequest));
    }


}
