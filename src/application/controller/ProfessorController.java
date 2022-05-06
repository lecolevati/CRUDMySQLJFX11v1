package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Professor;
import application.persistence.ProfessorDao;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProfessorController implements IProfessorController {
	
	private TextField tfCodigoProfessor;
	private TextField tfNomeProfessor;
	private TextField tfTitulacaoProfessor;
	private TextArea taListaProfessores;

	public ProfessorController(TextField tfCodigoProfessor, TextField tfNomeProfessor, TextField tfTitulacaoProfessor,
			TextArea taListaProfessores) {
		this.tfCodigoProfessor = tfCodigoProfessor;
		this.tfNomeProfessor = tfNomeProfessor;
		this.tfTitulacaoProfessor = tfTitulacaoProfessor;
		this.taListaProfessores = taListaProfessores;
	}

	@Override
	public void inserirProfessor(Professor p) throws ClassNotFoundException, SQLException {
		ProfessorDao pDao = new ProfessorDao();
		pDao.insereProfessor(p);
		limpaCamposProfessor();
		buscarProfessores();
	}

	@Override
	public void atualizarProfessor(Professor p) throws ClassNotFoundException, SQLException {
		ProfessorDao pDao = new ProfessorDao();
		pDao.atualizaProfessor(p);
		limpaCamposProfessor();
		buscarProfessores();
	}

	@Override
	public void excluirProfessor(Professor p) throws ClassNotFoundException, SQLException {
		ProfessorDao pDao = new ProfessorDao();
		pDao.excluiProfessor(p);
		limpaCamposProfessor();
		buscarProfessores();
	}

	@Override
	public void buscarProfessor(Professor p) throws ClassNotFoundException, SQLException {
		limpaCamposProfessor();

		ProfessorDao pDao = new ProfessorDao();
		p = pDao.buscaProfessor(p);

		tfCodigoProfessor.setText(String.valueOf(p.getCodigo()));
		tfNomeProfessor.setText(p.getNome());
		tfTitulacaoProfessor.setText(p.getTitulacao());
	
	}

	@Override
	public void buscarProfessores() throws ClassNotFoundException, SQLException {
		limpaCamposProfessor();
		taListaProfessores.setText("");
		
		ProfessorDao pDao = new ProfessorDao();
		List<Professor> listaProfessores = pDao.buscaProfessores();
		
		StringBuffer buffer = new StringBuffer("Código\t\t\t\tNome\t\t\t\tTitulação\n");
		for (Professor p : listaProfessores) {
			buffer.append(p.getCodigo()+"\t\t\t\t\t"+p.getNome()+"\t\t\t\t"+p.getTitulacao()+"\n");
		}
		
		taListaProfessores.setText(buffer.toString());
		
	}
	
	private void limpaCamposProfessor() {
		tfCodigoProfessor.setText("");
		tfNomeProfessor.setText("");
		tfTitulacaoProfessor.setText("");
	}

}
