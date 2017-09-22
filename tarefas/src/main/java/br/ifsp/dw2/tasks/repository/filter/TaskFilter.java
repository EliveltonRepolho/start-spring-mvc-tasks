package br.ifsp.dw2.tasks.repository.filter;

import java.time.LocalDate;

public class TaskFilter {

	private String name;
	private LocalDate date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
