package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import application.model.Disciplina;
import application.model.Professor;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class PrincipalController {
	@FXML
	private TextField tfCodigoProfessor;
	@FXML
	private TextField tfNomeProfessor;
	@FXML
	private TextField tfTitulacaoProfessor;
	@FXML
	private Button btnBuscarProfessor;
	@FXML
	private Button btnInserirProfessor;
	@FXML
	private Button btnAtualizarProfessor;
	@FXML
	private Button btnExcluirProfessor;
	@FXML
	private Button btnListarProfessor;
	@FXML
	private TextArea taListaProfessores;
	@FXML
	private Button btnCopiaProfessor;
	@FXML
	private TextField tfCodigoDisciplina;
	@FXML
	private TextField tfNomeDisciplina;
	@FXML
	private TextField tfCodigoProfessorDisciplina;
	@FXML
	private Button btnBuscarDisciplina;
	@FXML
	private Button btnInserirDisciplina;
	@FXML
	private Button btnAtualizarDisciplina;
	@FXML
	private Button btnExcluirDisciplina;
	@FXML
	private Button btnListarDisciplina;
	@FXML
	private TextArea taListaDisciplinas;
	@FXML
	private Label lblNomeProfessor;

	@FXML
	public void acaoProfessor(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd);

		ProfessorController professorController = new ProfessorController(tfCodigoProfessor, tfNomeProfessor,
				tfTitulacaoProfessor, taListaProfessores);

		if ((cmd.contains("Inserir") || cmd.contains("Atualizar")) && (tfCodigoProfessor.getText().isEmpty()
				|| tfNomeProfessor.getText().isEmpty() || tfTitulacaoProfessor.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		} else {
			if ((cmd.contains("Excluir") || cmd.contains("Buscar") || cmd.contains("tfCodigoProfessor"))
					&& tfCodigoProfessor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o código", "ERRO", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					if (cmd.contains("Listar")) {
						professorController.buscarProfessores();
					} else {
						Professor p = new Professor();
						p.setCodigo(Integer.parseInt(tfCodigoProfessor.getText()));
						p.setNome(tfNomeProfessor.getText());
						p.setTitulacao(tfTitulacaoProfessor.getText());
						if (cmd.contains("Inserir")) {
							professorController.inserirProfessor(p);
						} else if (cmd.contains("Atualizar")) {
							professorController.atualizarProfessor(p);
						} else if (cmd.contains("Excluir")) {
							professorController.excluirProfessor(p);
						} else if (cmd.contains("Buscar") || cmd.contains("tfCodigoProfessor")) {
							professorController.buscarProfessor(p);
						}
					}
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}

	}

	@FXML
	public void copiaProfessor(ActionEvent event) {
		if (tfCodigoProfessor.getText().isEmpty() || tfNomeProfessor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		} else {
			tfCodigoProfessorDisciplina.setText(tfCodigoProfessor.getText());
			lblNomeProfessor.setText(tfNomeProfessor.getText());
		}
	}

	@FXML
	public void acaoDisciplina(ActionEvent event) {
		DisciplinaController disciplinaController = new DisciplinaController(tfCodigoDisciplina, tfNomeDisciplina,
				tfCodigoProfessorDisciplina, lblNomeProfessor, taListaDisciplinas);

		String cmd = event.getSource().toString();

		if ((cmd.contains("Inserir") || cmd.contains("Atualizar")) && (tfCodigoDisciplina.getText().isEmpty()
				|| tfNomeDisciplina.getText().isEmpty() || tfCodigoProfessorDisciplina.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		} else {
			if ((cmd.contains("Excluir") || cmd.contains("Buscar") || cmd.contains("tfCodigoProfessorDisciplina"))
					&& tfCodigoDisciplina.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o código", "ERRO", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					if (cmd.contains("Listar")) {
						disciplinaController.buscarDisciplinas();
					} else {
						Disciplina d = new Disciplina();
						d.setCodigo(Integer.parseInt(tfCodigoDisciplina.getText()));
						d.setNome(tfNomeDisciplina.getText());
						
						if (!tfCodigoProfessorDisciplina.getText().isEmpty()) {
							Professor p = new Professor();
							p.setCodigo(Integer.parseInt(tfCodigoProfessorDisciplina.getText()));
							d.setProfessor(p);
						} 
						
						if (cmd.contains("Inserir")) {
							disciplinaController.inserirDisciplina(d);
						} else if (cmd.contains("Atualizar")) {
							disciplinaController.atualizarDisciplina(d);
						} else if (cmd.contains("Excluir")) {
							disciplinaController.excluirDisciplina(d);
						} else if (cmd.contains("Buscar") || cmd.contains("tfCodigoDisciplina")) {
							disciplinaController.buscarDisciplina(d);
						}
					}
				} catch (SQLException | ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();					
				}
			}
		}
	}
}
