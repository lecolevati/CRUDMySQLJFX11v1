CREATE DATABASE dbvideojavafx;

USE dbvideojavafx;

CREATE TABLE professor (
  codigo 		int 			NOT NULL,
  nome 			varchar(100) 	NOT NULL,
  titulacao 	varchar(50) 	NOT NULL,
  PRIMARY KEY (codigo)
);

CREATE TABLE disciplina (
  codigo 			int 			NOT NULL,
  nome 				varchar(100) 	NOT NULL,
  codigoDisciplina 	int 			NOT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (codigoDisciplina) REFERENCES professor(codigo)
);