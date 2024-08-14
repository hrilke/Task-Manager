package spring.project.Task_Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.project.Task_Manager.Repository.UserRepository;

@SpringBootApplication
public class V1Application {

	public static void main(String[] args) {

		SpringApplication.run(V1Application.class, args);
	}




}
