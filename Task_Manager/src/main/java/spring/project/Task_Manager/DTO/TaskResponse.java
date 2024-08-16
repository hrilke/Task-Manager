package spring.project.Task_Manager.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import spring.project.Task_Manager.Model.Constants.PriorityLevel;
import spring.project.Task_Manager.Model.Constants.TaskStatus;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class TaskResponse {
    private int id;
    private String Title;
    private String Description;
    private TaskStatus taskStatus;
    private PriorityLevel priorityLevel;
    private LocalDate dueDate;
    private int userId;
    private Instant createdAt;
    private Instant updatedAt;
}
