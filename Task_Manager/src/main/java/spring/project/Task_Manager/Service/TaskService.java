package spring.project.Task_Manager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.project.Task_Manager.DTO.TaskRequest;
import spring.project.Task_Manager.DTO.TaskResponse;
import spring.project.Task_Manager.Exception.NoTaskExistsException;
import spring.project.Task_Manager.Model.Constants.PriorityLevel;
import spring.project.Task_Manager.Model.Constants.TaskStatus;
import spring.project.Task_Manager.Model.Task;
import spring.project.Task_Manager.Repository.TaskRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    public TaskResponse createTask(TaskRequest taskRequest) {
        Task newTask = new Task();
        newTask.setTitle(taskRequest.getTitle());
        newTask.setTaskStatus(taskRequest.getTaskStatus());
        newTask.setDescription(taskRequest.getDescription());
        newTask.setDueDate(taskRequest.getDueDate());
        newTask.setPriorityLevel(taskRequest.getPriorityLevel());
        newTask.setUserId(taskRequest.getUserId());
        taskRepository.save(newTask);
        return Task.toTaskResponse(newTask);
    }
    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponse> taskResponseList = new ArrayList<>();
        for (Task task : tasks) {
            taskResponseList.add(Task.toTaskResponse(task));
        }
        return taskResponseList;
    }

    public TaskResponse getTaskByDescription(String description) throws NoTaskExistsException{
        Task task = taskRepository.findByDescription(description);
        if (task == null) throw new NoTaskExistsException("No Task found by description: "+ description);
        return Task.toTaskResponse(task);
    }

    public TaskResponse getTaskByTitle(String title) throws NoTaskExistsException{
        Task task = taskRepository.findByTitle(title);
        if (task == null) throw new NoTaskExistsException("No Task found by title: "+ title);
        return Task.toTaskResponse(task);
    }

    public TaskResponse updateTask(UUID taskId, TaskRequest taskRequest) throws NoTaskExistsException{
        if (!taskRepository.existsById(taskId)) throw new NoTaskExistsException("No Task found by id: "+ taskId);
        Optional<Task> taskOpt = taskRepository.findById(taskId);
        Task existing = taskOpt.get();
        existing.setTaskStatus(taskRequest.getTaskStatus());
        existing.setTitle(taskRequest.getTitle());
        existing.setDescription(taskRequest.getDescription());
        existing.setDueDate(taskRequest.getDueDate());
        existing.setPriorityLevel(taskRequest.getPriorityLevel());
        existing.setUserId(taskRequest.getUserId());
        return Task.toTaskResponse(taskRepository.save(existing));
    }

    public Boolean deleteTask(UUID taskId) throws NoTaskExistsException{
        if (!taskRepository.existsById(taskId)) throw new NoTaskExistsException("No Task found by id: "+ taskId);
            taskRepository.deleteById(taskId);
        return true;
    }

    public List<TaskResponse> filterTask(TaskStatus status, PriorityLevel level, Instant dueDate) {
        List<TaskResponse> taskResponseList = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        if (status != null && level != null && dueDate != null) {
            tasks = taskRepository.findByTaskStatusAndPriorityLevelAndDueDate(status, level, dueDate);
        }
        else if (status != null && level != null) {
            tasks = taskRepository.findByTaskStatusAndPriorityLevel(status, level);
        } else if (status != null && dueDate != null) {
            tasks = taskRepository.findByTaskStatusAndDueDate(status, dueDate);
        } else if (level != null && dueDate != null) {
            tasks = taskRepository.findByPriorityLevelAndDueDate(level, dueDate);
        } else if (status != null) {
            tasks = taskRepository.findByTaskStatus(status);
        } else if (level != null) {
            tasks = taskRepository.findByPriorityLevel(level);
        } else if (dueDate != null) {
            tasks = taskRepository.findByDueDate(dueDate);
        } else {
            tasks = taskRepository.findAll();
        }
        for (Task task : tasks) {
             taskResponseList.add(Task.toTaskResponse(task));
        }
        return taskResponseList;
    }
}
