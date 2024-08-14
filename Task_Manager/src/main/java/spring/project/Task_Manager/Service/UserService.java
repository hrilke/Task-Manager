package spring.project.Task_Manager.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.project.Task_Manager.DTO.AuthResponse;
import spring.project.Task_Manager.DTO.LogInRequest;
import spring.project.Task_Manager.DTO.SignUpRequest;
import spring.project.Task_Manager.Exception.EmailAlreadyRegisteredException;
import spring.project.Task_Manager.Model.Constants.Role;
import spring.project.Task_Manager.Model.User;
import spring.project.Task_Manager.Repository.UserRepository;

import java.awt.desktop.AboutHandler;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public void createUser(SignUpRequest signUpRequest) throws EmailAlreadyRegisteredException{
        Optional<User> userOpt = userRepository.findByEmail(signUpRequest.getEmail());
        if (!userOpt.isEmpty()) {
            throw new EmailAlreadyRegisteredException("This Email is already Registered, Try LogIn");
        }
        User newUser = new User();
            newUser.setEmail(signUpRequest.getEmail());
            newUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            newUser.setRole(Role.USER);
        userRepository.save(newUser);
    }
    public AuthResponse loginUser(LogInRequest logInRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        logInRequest.getEmail(),
                        logInRequest.getPassword()
                )
        );
        User user = userRepository.findByEmail(logInRequest.getEmail()).orElseThrow();
        String token = jwtService.generateToken(user);
        AuthResponse authResponse = new AuthResponse(token);
        return authResponse;
    }
}
