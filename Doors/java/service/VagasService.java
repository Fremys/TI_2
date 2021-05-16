package services;

import model.*;
import dao.*;
import app.*;

import org.json.JSONArray;

import spark.Request;
import spark.Response;

public class VagasService {

	private DAOVagas conexao;
	
	public VagasService() {
		// TODO Auto-generated constructor stub
		conexao = new DAOVagas();
	}
	
	public Object getAllVagasLogs() {
		StringBuffer returnValue = new StringBuffer("[");
		conexao.conectar();
		if(conexao.getAll() != null) {
			Vagas[]a = conexao.getAll();
			for (int i = 0; i < a.length; i++) {
				if(i != a.length-1)
					returnValue.append(a[i].toJson()+",");
				else
					returnValue.append(a[i].toJson());
			}
		}
		returnValue.append("]");
		conexao.close();
		return returnValue.toString();
	}

	public boolean add(Vagas vag) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO Vagas (id, aluno_id, monitoria_id) "
					       + "VALUES ("+vag.getId()+", "+vag.getAluno_id()+", "+vag.getMonitoria_id()+");");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	

}