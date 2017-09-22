CREATE TABLE tb_task (
  id_task bigserial,
  name VARCHAR(70) NOT NULL,
  date DATE,
  PRIMARY KEY (id_task)
);