package spring.project.Task_Manager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.project.Task_Manager.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

}
