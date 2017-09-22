package br.ifsp.dw2.tasks.controller;

import javax.validation.Valid;

import br.ifsp.dw2.tasks.model.Task;
import br.ifsp.dw2.tasks.repository.filter.TaskFilter;
import br.ifsp.dw2.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@RequestMapping("/novo")
	public ModelAndView createView(Task task) {
		ModelAndView mv = new ModelAndView("tasks/CreateTask");
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView create(@Valid Task task, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return createView(task);
		}

		taskService.save(task);
		attributes.addFlashAttribute("mensagem", "Tarefa salva com sucesso!");
		return new ModelAndView("redirect:/tasks/novo");
	}
	
	@GetMapping
	public ModelAndView searchView(TaskFilter taskFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("tasks/SearchTask");
		mv.addObject("tasks", taskService.filter(taskFilter));
		return mv;
	}

	@GetMapping("/{task}")
	public ModelAndView editar(@PathVariable("task") Long id) {
		Task task = taskService.find(id);
		ModelAndView mv = createView(task);
		mv.addObject(task);
		return mv;
	}
	
}
