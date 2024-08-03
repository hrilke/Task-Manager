package spring.project.Task_Manager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;
import spring.project.Task_Manager.Repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
}
