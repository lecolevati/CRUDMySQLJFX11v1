package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Disciplina;

public interface IDisciplinaDao {

	public void inserirDisciplina(Disciplina d) throws SQLException;
	public void atualizarDisciplina(Disciplina d) throws SQLException;
	public void excluirDisciplina(Disciplina d) throws SQLException;
	public Disciplina buscarDisciplina(Disciplina d) throws SQLException;
	public List<Disciplina> buscarDisciplinas() throws SQLException;
	
}
