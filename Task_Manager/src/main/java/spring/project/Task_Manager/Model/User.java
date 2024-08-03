package spring.project.Task_Manager.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseClass{
    private String userName;
    private String password;
}
