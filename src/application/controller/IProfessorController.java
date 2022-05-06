package application.controller;

import java.sql.SQLException;

import application.model.Professor;

public interface IProfessorController {

	public void inserirProfessor(Professor p) throws ClassNotFoundException, SQLException;
	public void atualizarProfessor(Professor p) throws ClassNotFoundException, SQLException;
	public void excluirProfessor(Professor p) throws ClassNotFoundException, SQLException;
	public void buscarProfessor(Professor p) throws ClassNotFoundException, SQLException;
	public void buscarProfessores() throws ClassNotFoundException, SQLException;
	
}
