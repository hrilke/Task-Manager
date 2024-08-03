package spring.project.Task_Manager.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.project.Task_Manager.Model.Constants.PriorityLevel;
import spring.project.Task_Manager.Model.Constants.TaskStatus;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task extends BaseClass{
    private String Title;
    private String Description;
    private TaskStatus taskStatus;
    private PriorityLevel priorityLevel;
    private Instant dueDate;
    private UUID userId;
}
