package services;

import model.*;
import dao.*;
import app.*;

import org.json.JSONArray;

import spark.Request;
import spark.Response;

public class EstudanteService {

	private DAOEstudante conexao;
	
	public EstudanteService() {
		// TODO Auto-generated constructor stub
		conexao = new DAOEstudante();
	}
	
	public Object publicarEstudante(Request request, Response response) {
		conexao.conectar();

        String cpf = request.queryParams("cpf");
        String usuario = request.queryParams("usuario");
        String senha = request.queryParams("senha");
        String prenome = request.queryParams("prenome");
        String sobrenome = request.queryParams("sobrenome");
        String email = request.queryParams("email");
        int periodo = Integer.parseInt(request.queryParams("periodo"));
        String curso = request.queryParams("curso");
        int telefone = Integer.parseInt(request.queryParams("telefone"));
        String endereco = request.queryParams("endereco");
        String linkedin = request.queryParams("linkedin");
        String idiomas = request.queryParams("idiomas");
        String skills = request.queryParams("skills");
        int foto = Integer.parseInt(request.queryParams("foto"));
		
		Estudante estudanteCriado = new Estudante(cpf, usuario, senha, prenome, sobrenome, email, periodo, curso, telefone, endereco, linkedin, idiomas, skills, foto);
		
		boolean resp = conexao.add(estudanteCriado);
		conexao.close();
		if(resp == true)
			return "200";
		else
			return "Error";
	}

    public Object getEstudante(Request request, Response response) {
        DAOEstudante conexaoEstudante = new DAOEstudante();
		StringBuffer returnValue = new StringBuffer("[");
		//conexoes
		conexao.conectar();
		conexaoEstudante.conectar();
		String cpf = request.queryParams("cpf");
		
		Estudante estud = conexao.get(cpf);
		if(estud != null) {
			returnValue.append(estud.toJson());
		}
		returnValue.append("]");
		conexao.close();
		return returnValue.toString();
    }
    
    public Object updateEstudante(Request request, Response response) {
		//conexoes
		conexao.conectar();
        conexaoEstudante.conectar();

		String cpf = request.queryParams("cpf");
        String usuario = request.queryParams("usuario");
        String senha = request.queryParams("senha");
        String prenome = request.queryParams("prenome");
        String sobrenome = request.queryParams("sobrenome");
        String email = request.queryParams("email");
        int periodo = Integer.parseInt(request.queryParams("periodo"));
        String curso = request.queryParams("curso");
        int telefone = Integer.parseInt(request.queryParams("telefone"));
        String endereco = request.queryParams("endereco");
        String linkedin = request.queryParams("linkedin");
        String idiomas = request.queryParams("idiomas");
        String skills = request.queryParams("skills");
        int foto = Integer.parseInt(request.queryParams("foto"));
        
        Estudante estud = conexao.get(cpf);
		if(estud != null) {
			Estudante estudanteNovo = new Estudante(cpf, usuario, senha, prenome, sobrenome, email, periodo, curso, telefone, endereco, linkedin, idiomas, skills, foto);
		}
		
        boolean resp = conexao.update(estudanteNovo);
		conexao.close();
		if(resp == true)
			return "200";
		else
			return "Error";
    }

	public Object deletarEstudante(Request request) {
		conexao.conectar();
		String cpf = request.queryParams("cpf");
		boolean resp = conexao.delete(cpf);
		conexao.close();
		if(resp == true)
			return "200";
		else
			return "Error";
	}

}
