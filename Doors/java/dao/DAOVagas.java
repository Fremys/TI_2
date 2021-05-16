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
}