package spring.project.Task_Manager.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import spring.project.Task_Manager.Model.Constants.PriorityLevel;
import spring.project.Task_Manager.Model.Constants.TaskStatus;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class TaskResponse {
    private UUID id;
    private String Title;
    private String Description;
    private TaskStatus taskStatus;
    private PriorityLevel priorityLevel;
    private Instant dueDate;
    private UUID userId;
    private Instant createdAt;
    private Instant updatedAt;
}
