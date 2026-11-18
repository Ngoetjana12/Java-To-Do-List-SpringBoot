package org.mecerintered.javatodo.repo;

import org.mecerintered.javatodo.entity.Task;
import org.mecerintered.javatodo.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);
    List<Task> findByStatusAndDueDateBefore(TaskStatus status, LocalDateTime currentDateTime);
    Task getTaskById(Long id);
}
