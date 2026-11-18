package org.mecerintered.javatodo.taskController;


import org.mecerintered.javatodo.entity.Task;
import org.mecerintered.javatodo.enums.TaskStatus;
import org.mecerintered.javatodo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){

        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){

        return taskService.getTaskById(id);
    }

    @GetMapping("/pending")
    public List<Task> getPendingTasks(){

        return taskService.getPendingTasks();
    }

    @PutMapping("/{id}/complete")
    public Task completeTask(@PathVariable Long id){

        return taskService.completeTask(id);
    }

    @GetMapping("/overdue")
    public List<Task> getOverdueTasks(){
        return taskService.getOverdueTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){

        taskService.deleteTask(id);
    }
}
