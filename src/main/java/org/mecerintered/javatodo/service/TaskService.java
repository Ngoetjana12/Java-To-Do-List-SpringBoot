package org.mecerintered.javatodo.service;

import org.mecerintered.javatodo.entity.Task;
import org.mecerintered.javatodo.enums.TaskStatus;
import org.mecerintered.javatodo.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {

        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no task with an ID: "+ id));
    }

    public List<Task> getPendingTasks() {

        return taskRepository.findByStatus(TaskStatus.PENDING);
    }

    public Task completeTask(Long id) {

        Task task = taskRepository.getTaskById(id);

        task.setStatus(TaskStatus.COMPLETED);

        return taskRepository.save(task);
    }

    public List<Task> getOverdueTasks() {

        return taskRepository.findByStatusAndDueDateBefore(TaskStatus.PENDING, LocalDateTime.now());

    }

    public void deleteTask(Long id) {

        Task task = taskRepository.getTaskById(id);
        taskRepository.delete(task);

        System.out.println("Task Deleted");
    }
}
