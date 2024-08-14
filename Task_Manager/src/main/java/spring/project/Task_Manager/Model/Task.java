package spring.project.Task_Manager.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.project.Task_Manager.DTO.TaskResponse;
import spring.project.Task_Manager.Model.Constants.PriorityLevel;
import spring.project.Task_Manager.Model.Constants.TaskStatus;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseClass{
    private String title;
    private String description;
    private TaskStatus taskStatus;
    private PriorityLevel priorityLevel;
    private Instant dueDate;
    private UUID userId;

    public static TaskResponse toTaskResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setTaskStatus(task.getTaskStatus());
        taskResponse.setDueDate(task.getDueDate());
        taskResponse.setUserId(task.getUserId());
        taskResponse.setPriorityLevel(task.getPriorityLevel());
        taskResponse.setId(task.getId());
        taskResponse.setCreatedAt(task.getCreatedAt());
        taskResponse.setUpdatedAt(task.getUpdatedAt());
        return taskResponse;
    }
}
