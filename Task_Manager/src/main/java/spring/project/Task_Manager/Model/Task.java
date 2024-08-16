package spring.project.Task_Manager.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.project.Task_Manager.DTO.TaskResponse;
import spring.project.Task_Manager.Model.Constants.PriorityLevel;
import spring.project.Task_Manager.Model.Constants.TaskStatus;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseClass{
    @Column(nullable = false)
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus taskStatus;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PriorityLevel priorityLevel;
    @Column(nullable = false)
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public static TaskResponse toTaskResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setTaskStatus(task.getTaskStatus());
        taskResponse.setDueDate(task.getDueDate());
        taskResponse.setUserId(task.getUser().getId());
        taskResponse.setPriorityLevel(task.getPriorityLevel());
        taskResponse.setId(task.getId());
        taskResponse.setCreatedAt(task.getCreatedAt());
        taskResponse.setUpdatedAt(task.getUpdatedAt());
        return taskResponse;
    }
}
