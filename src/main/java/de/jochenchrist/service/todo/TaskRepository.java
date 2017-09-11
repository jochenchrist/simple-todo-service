package de.jochenchrist.service.todo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@CrossOrigin
public interface TaskRepository extends PagingAndSortingRepository<Task, UUID> {
}
