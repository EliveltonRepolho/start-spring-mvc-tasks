package br.ifsp.dw2.tasks.repository.helper.task;

import java.util.List;

import br.ifsp.dw2.tasks.repository.filter.TaskFilter;
import org.springframework.data.domain.Pageable;

import br.ifsp.dw2.tasks.model.Task;

public interface TasksQueries {
	List<Task> filter(TaskFilter filter);
}
