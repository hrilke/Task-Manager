package spring.project.Task_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import spring.project.Task_Manager.Service.TaskService;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

}
