package spring.project.Task_Manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.project.Task_Manager.Model.Task;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
