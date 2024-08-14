package spring.project.Task_Manager.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInRequest {
    private String email;
    private String password;
}
