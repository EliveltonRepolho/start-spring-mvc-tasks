package br.ifsp.dw2.tasks.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.ifsp.dw2.tasks.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.ifsp.dw2.tasks.thymeleaf.processor.MessageElementTagProcessor;

public class TasksDialect extends AbstractProcessorDialect {

	public TasksDialect() {
		super("Tarefas IFSP", "tasks", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		return processadores;
	}

}
