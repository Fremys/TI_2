package dao;
import java.sql.*;

import model.*;

public class DAOAEmpregador{
	private Connection conexao;
	
	public DAOAEmpregador() {
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

	
	public Empregador[] getAll(){
		Empregador[] empregador = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM empregador;");		
	         if(rs.next()){
	             rs.last();
	             empregador = new Empregador[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	            	 empregador[i] = new Empregador(rs.getInt("id"), rs.getString("cnpj"), rs.getString("cpf"), rs.getString("senha"), 
	                		                  rs.getString("nome"), rs.getString("email"), rs.getString("descricao"), rs.getString("site"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return empregador;
	}
}