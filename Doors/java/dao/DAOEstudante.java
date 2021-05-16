package dao;
import java.sql.*;

import model.*;

public class DAOEstudante{
	private Connection conexao;
	
	public DAOEstudante() {
		conexao = null;
	}
	
	public boolean conectar() {
		boolean status = false;

		try {
			Class.forName(CredenciaisDB.driverName);
			conexao = DriverManager.getConnection(CredenciaisDB.url, CredenciaisDB.username, CredenciaisDB.password);
			status = (conexao == null);
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}

	public boolean add(Estudante estud) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO estudante (cpf, usuario, senha, prenome, sobrenome, email, periodo, curso, telefone, endereco, linkedin, idiomas, skills, foto) "
					       + "VALUES ("estud.getCpf()+", "estud.getUsuario()+", "estud.getSenha()+", "estud.String getPrenome()+", "estud.getSobrenome()+", "
                                       estud.String getEmail()+", "estud.getPeriodo()+", "estud.getCurso()+", "estud.getTelefone()+", "estud.getEndereco()+", "
                                       estud.getLinkedin()+", "estud.getIdiomas()+", "estud.getSkills()+", "estud.getFoto()+");");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Estudante[] get(String cpf) {
		Estudante[] estudante = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM estudante WHERE cpf = "+cpf+";"); // filtrar por cpf de estudante
	         if(rs.next()){
	             rs.last();
	             estudante = new Estudante[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                estudante[i] = new Estudante(rs.getString("cpf"), rs.getString("usuario"), rs.getString("senha"), 
                    rs.getString("prenome"), rs.getString("sobrenome"), rs.getString("email"), rs.getInt("periodo"),
                    rs.getString("curso"), rs.getInt("telefone"), rs.getString("endereco"), rs.getString("linkedin"),
                    rs.getString("idiomas"), rs.getString("skills"), rs.getInt("foto"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return estudante;
	}

    public boolean delete(String cpf) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM estudante WHERE cpf = " + cpf+";");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean update(Estudante estud) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE estudante SET usuario = '" + estud.getUsuario() + "', prenome = '"  
				       + estud.String getPrenome() + "', sobrenome = '" + estud.getSobrenome()
				       + "', email = '" + estud.String getEmail() + "', periodo = '" + estud.getPeriodo() 
                       + "', curso = '" + estud.getCurso() + "', telefone = '" + estud.getTelefone() 
                       + "', endereco = '" + estud.getEndereco() + "', linkedin = '" + estud.getLinkedin() 
                       + "', idiomas = '" + estud.getIdiomas() + "', skills = '" + estud.getSkills()  + "', foto = '" + estud.getFoto() + "'" 
					   + " WHERE cpf = " + estud.getCpf();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

}