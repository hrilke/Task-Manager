package spring.project.Task_Manager.DTO;

import lombok.Getter;
import lombok.Setter;
import spring.project.Task_Manager.Model.Constants.PriorityLevel;
import spring.project.Task_Manager.Model.Constants.TaskStatus;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class TaskRequest {
    private String Title;
    private String Description;
    private TaskStatus taskStatus;
    private PriorityLevel priorityLevel;
    private Instant dueDate;
    private UUID userId;
}
