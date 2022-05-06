package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Professor;

public class ProfessorDao implements IProfessorDao {

	private Connection c;
	
	public ProfessorDao() throws ClassNotFoundException, SQLException {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	@Override
	public void insereProfessor(Professor p) throws SQLException {
		String sql = "INSERT INTO professor VALUES (?,?,?)";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getCodigo());
		ps.setString(2, p.getNome());
		ps.setString(3, p.getTitulacao());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizaProfessor(Professor p) throws SQLException {
		String sql = "UPDATE professor SET nome = ?, titulacao = ? WHERE codigo = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getTitulacao());
		ps.setInt(3, p.getCodigo());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiProfessor(Professor p) throws SQLException {		
		String sql = "DELETE FROM professor WHERE codigo = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getCodigo());
		
		ps.execute();
		ps.close();		
	}

	@Override
	public Professor buscaProfessor(Professor p) throws SQLException {
		String sql = "SELECT codigo, nome, titulacao FROM professor WHERE codigo = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getCodigo());
		
		int cont = 0;
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			p.setNome(rs.getString("nome"));
			p.setTitulacao(rs.getString("titulacao"));
			cont++;
		}
		
		if (cont == 0) {
			p = new Professor();
		}
		
		rs.close();
		ps.close();
		return p;
	}

	@Override
	public List<Professor> buscaProfessores() throws SQLException {
		String sql = "SELECT codigo, nome, titulacao FROM professor";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Professor> listaProfessores = new ArrayList<Professor>();
		
		while (rs.next()) {
			Professor p = new Professor();
			p.setCodigo(rs.getInt("codigo"));
			p.setNome(rs.getString("nome"));
			p.setTitulacao(rs.getString("titulacao"));
			
			listaProfessores.add(p);
		}
		
		rs.close();
		ps.close();
		
		return listaProfessores;

	}
	
}