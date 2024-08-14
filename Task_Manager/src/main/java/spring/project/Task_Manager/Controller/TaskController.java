package spring.project.Task_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.project.Task_Manager.DTO.TaskRequest;
import spring.project.Task_Manager.DTO.TaskResponse;
import spring.project.Task_Manager.Exception.NoTaskExistsException;
import spring.project.Task_Manager.Model.Constants.PriorityLevel;
import spring.project.Task_Manager.Model.Constants.TaskStatus;
import spring.project.Task_Manager.Service.TaskService;
import java.time.Instant;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest){
        return ResponseEntity.ok(taskService.createTask(taskRequest));
    }
    @GetMapping("/allTasks")
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @GetMapping("/read/{title}")
    public ResponseEntity<TaskResponse> getTaskByTitle(@PathVariable String title) throws NoTaskExistsException {
        return ResponseEntity.ok(taskService.getTaskByTitle(title));
    }
    @GetMapping("/read/{description}")
    public ResponseEntity<TaskResponse> getTaskByDescription(@PathVariable String description) throws NoTaskExistsException {
        return ResponseEntity.ok(taskService.getTaskByDescription(description));
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<TaskResponse> updateTask(@PathVariable UUID taskId, @RequestBody TaskRequest taskRequest) throws NoTaskExistsException{
        return ResponseEntity.ok(taskService.updateTask(taskId, taskRequest));
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Boolean> deleteTask(@PathVariable UUID taskId) throws NoTaskExistsException{
        return ResponseEntity.ok(taskService.deleteTask(taskId));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TaskResponse>> filterTasks(
            @RequestParam(required = false) TaskStatus status,
            @RequestParam(required = false)PriorityLevel level,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Instant dueDate){

        return ResponseEntity.ok(taskService.filterTask(status,level,dueDate));
    }

}
