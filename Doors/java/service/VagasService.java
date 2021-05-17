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

	public Object publicarVagas(Request request, Response response) {
		conexao.conectar();


		int id = -1;
    	int empregador_id = -1;
    	String titulo = request.queryParams("titleForm");
    	String descricao = request.queryParams("descForm");
    	String beneficios = request.queryParams("benForm");
    	String requisitos = request.queryParams("requisForm");
    	String imagem = request.queryParams("imgForm"); //cuidado pode dar erro/ precisamso do link
    	double salario = Integer.parseInt(request.queryParams("salForm"));
    	String categorias = request.queryParams("filtro");

		Vagas[]vs = conexao.getAll();
		if (vs != null) 
			for(int i = 0; i < vs.length; i++) 
				if(id < vs[i].getId()) 
					id = vs[i].getId();
							
		id++;

		if (vs != null) 
			for(int i = 0; i < vs.length; i++) 
				if(empregador_id < vs[i].getId()) 
					empregador_id = vs[i].getId();
							
		empregador_id++;
	
		Vagas vagaCriada = new Vagas(id, empregador_id, titulo, descricao, beneficios, requisitos, imagem, salario, categoria);

		boolean resp = conexao.add(vagaCriada);
		conexao.close();
		if(resp == true)
			return "200";
		else
			return "Error";
	}

	public Object getAllVagas() {
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

	public Object getAllVagasEmpregador(Request request) {
		StringBuffer returnValue = new StringBuffer("[");
		conexao.conectar();
		if(conexao.() != null) {

			int id = Integer.parseInt(request.requestParams(":id_empregador"));;
			Vagas[]a = conexao.getAllVagasEmpregador(id);
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

	public Object getVagas(Request request) {
		StringBuffer returnValue = new StringBuffer("[");
		conexao.conectar();
		if(conexao.() != null) {

			int id = Integer.parseInt(request.requestParams(":id"));;
			Vagas[]a = conexao.getVagas(id);
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

	public Object deletarVagas(Request request) {
		conexao.conectar();
		int id = Integer.parseInt(request.requstParams(":id"));
		boolean resp = conexao.delete(id);
		conexao.close();
		if(resp == true)
			return "200";
		else
			return "Error";
	}

	 public Object updateVagas(Request request, Response response) {
		//conexoes
		conexao.conectar();
		//tirei uma linha que talez seja inutil mas pode dar erro

		int id = -1;
    	int empregador_id = -1;
    	String titulo = request.queryParams("titleForm");
    	String descricao = request.queryParams("descForm");
    	String beneficios = request.queryParams("benForm");
    	String requisitos = request.queryParams("requisForm");
    	String imagem = request.queryParams("imgForm"); //cuidado pode dar erro/ precisamso do link
    	double salario = Integer.parseInt(request.queryParams("salForm"));
    	String categorias = request.queryParams("filtro");
        
        Vagas vagasNovo = conexao.getVagas(id);
		if(estud != null) {
			Vagas vagasNovo = new Vagas((id, empregador_id, titulo, descricao, beneficios, requisitos, imagem, salario, categoria));
		}
		
        boolean resp = conexao.update(vagasNovo);
		conexao.close();
		if(resp == true)
			return "200";
		else
			return "Error";
    }

}