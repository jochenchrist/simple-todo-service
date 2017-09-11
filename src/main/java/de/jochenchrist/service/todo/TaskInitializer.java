package de.jochenchrist.service.todo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskInitializer {

    public TaskInitializer(TaskRepository repository) {
        if(repository.count() != 0) {
            return;
        }

        Task task = new Task();
        task.setName("Unit Tests");
        task.setDescription("Write Unit Tests");
        task.setDueDate(new Date());
        repository.save(task);
    }
}
