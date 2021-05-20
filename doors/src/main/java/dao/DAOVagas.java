package dao;
import java.sql.*;

import model.*;

public class DAOVagas{
	private Connection conexao;
	
	public DAOVagas() {
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

	
	public Vagas[] getAll(){
		Vagas[] vagas = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM vaga;");		
	         if(rs.next()){
	             rs.last();
	             vagas = new Vagas[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	            	 vagas[i] = new Vagas(rs.getInt("id"), rs.getInt("id_empregador"), rs.getString("titulo"), rs.getString("categoria"), rs.getInt("periodo"), 
	                		                  rs.getString("requisitos"), rs.getString("descricao"), rs.getInt("salario"), rs.getString("beneficios"), rs.getInt("imagem")); //Imagem como?????
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return vagas;
	}

		public boolean add(Vagas vag) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Vagas (id, empregador_id, titulo, descricao, beneficios, requisitos, imagem, salario, categoria) "
					       +"VALUES ("+vag.getId()+ "," +vag.getEmpregadorId()+ "," +vag.getTitulo()+ "," +vag.getDescricao()+ "," +vag.getBeneficios()+ "," +vag.getRequisitos()+ "," +vag.getImagem()+ "," +vag.getSalario()+ "," +vag.getCategorias() + ");");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	public Vagas[] getAllVagasEmpregador(int empregador_id) {
		Vagas[] vagas = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM vagas WHERE empregador_id = "+empregador_id+";"); // talvez filtrar por id de aluno
	         if(rs.next()){
	             rs.last();
	             vagas = new Vagas[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                vagas[i] = new Vagas(rs.getInt("id"), rs.getInt("empregador_id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("beneficios"), rs.getString("requisitos"), rs.getString("imagem"), rs.getInt("salario"), rs.getString("categoria"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return vagas;
	}

	public Vagas[] getVagas(int id) {
		Vagas[] vagas = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM vagas WHERE id = "+id+";"); // talvez filtrar por id de aluno
	         if(rs.next()){
	             rs.last();
	             vagas = new Vagas[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                vagas[i] = new Vagas(rs.getInt("id"), rs.getInt("empregador_id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("beneficios"), rs.getString("requisitos"), rs.getString("imagem"), rs.getInt("salario"), rs.getString("categoria"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return vagas;
	}

	public boolean update(Vagas vag) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE vaga SET
			id = '" +vag.getId()+ "', 
			empregador_id '" +vag.getEmpregadorId()+ "', 
			titulo = '"+vag.getTitulo()+ "', 
			descricao = '" +vag.getDescricao()+ "', 
			beneficios = '"+vag.getBeneficios()+ "', 
			requisitos = '" +vag.getRequisitos()+ "', 
			imagem = '" +vag.getImagem()+ "', 
			salario = '" +vag.getSalario()+ "', 
			categorias '" +vag.getCategorias() ", 
			WHERE cpf = " + estud.getCpf();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM vagas WHERE id = "+id+";");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}