package br.ifsp.dw2.tasks.repository.helper.task;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.ifsp.dw2.tasks.model.Task;
import br.ifsp.dw2.tasks.repository.filter.TaskFilter;

public class TasksImpl implements TasksQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Task> filter(TaskFilter filter) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Task.class);

		if (filter != null) {
			
			if (!StringUtils.isEmpty(filter.getName())) {
				criteria.add(Restrictions.ilike("name", filter.getName(), MatchMode.ANYWHERE));
			}

			if (filter.getDate() != null) {
				criteria.add(Restrictions.eq("date", filter.getDate()));
			}

		}
		
		return criteria.list();
	}

}
