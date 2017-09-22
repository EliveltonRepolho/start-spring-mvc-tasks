package br.ifsp.dw2.tasks.service;

import java.util.List;
import java.util.Optional;

import br.ifsp.dw2.tasks.model.Task;
import br.ifsp.dw2.tasks.repository.Tasks;
import br.ifsp.dw2.tasks.repository.filter.TaskFilter;
import br.ifsp.dw2.tasks.service.exception.CRUDException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

	@Autowired
	private Tasks tasks;
	
	@Transactional
	public Task save(Task task) {
		Optional<Task> op = tasks.findByNameIgnoreCase(task.getName());
		if (op.isPresent()) {
			throw new CRUDException("Tarefa com este nome já cadastrado");
		}
		
		return tasks.saveAndFlush(task);
	}

	public List<Task> filter(TaskFilter filter){
		return tasks.filter(filter);
	}

	public Task find(Long id) {
		return tasks.findOne(id);
	}
}
