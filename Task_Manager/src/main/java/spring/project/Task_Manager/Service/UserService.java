package spring.project.Task_Manager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.project.Task_Manager.Model.User;
import spring.project.Task_Manager.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }
    public String loginUser(LoginDTO loginDTO) {

    }
}
