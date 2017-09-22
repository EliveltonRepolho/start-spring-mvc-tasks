package br.ifsp.dw2.tasks.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tb_task")
public class Task implements Serializable{

	@Id
	@SequenceGenerator(name="tb_task_gen", sequenceName="tb_task_id_task_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="tb_task_gen")
	@Column(name = "id_task")
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	@Size(max = 70, message = "O tamanho do nome deve estar entre 1 e 70")
	private String name;

	@NotNull(message = "Data é obrigatória")
	private LocalDate date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
