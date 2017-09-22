package br.ifsp.dw2.tasks.repository;

import java.util.Optional;

import br.ifsp.dw2.tasks.model.Task;
import br.ifsp.dw2.tasks.repository.helper.task.TasksQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tasks extends JpaRepository<Task, Long>, TasksQueries {

	Optional<Task> findByNameIgnoreCase(String name);
	
}
