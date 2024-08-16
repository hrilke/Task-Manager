package spring.project.Task_Manager.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.project.Task_Manager.Model.Constants.PriorityLevel;
import spring.project.Task_Manager.Model.Constants.TaskStatus;
import spring.project.Task_Manager.Model.Task;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByTitle(String title);
    Task findByDescription(String description);
    Optional<Task> findById(int id);
    List<Task> findByTaskStatusAndPriorityLevelAndDueDate(TaskStatus status, PriorityLevel level, Instant dueDate);

    List<Task> findByTaskStatusAndPriorityLevel(TaskStatus status, PriorityLevel level);

    List<Task> findByTaskStatusAndDueDate(TaskStatus status, Instant dueDate);

    List<Task> findByPriorityLevelAndDueDate(PriorityLevel level, Instant dueDate);

    List<Task> findByTaskStatus(TaskStatus status);

    List<Task> findByPriorityLevel(PriorityLevel level);

    List<Task> findByDueDate(Instant dueDate);
}
