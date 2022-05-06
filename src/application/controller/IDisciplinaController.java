package application.controller;

import java.sql.SQLException;

import application.model.Disciplina;

public interface IDisciplinaController {

	public void inserirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
	public void atualizarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
	public void excluirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
	public void buscarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
	public void buscarDisciplinas() throws ClassNotFoundException, SQLException;
	
}
