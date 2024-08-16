package spring.project.Task_Manager.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import spring.project.Task_Manager.Model.Constants.PriorityLevel;
import spring.project.Task_Manager.Model.Constants.TaskStatus;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class TaskRequest {
    private String Title;
    private String Description;
    private String taskStatus;
    private String priorityLevel;
    private LocalDate dueDate;
    private int userId;
}
