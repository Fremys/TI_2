package model;

import org.json.JSONObject;

public class Aluno implements JsonFormatter{
	private int date;
	private String procuraEstudante; 
	private String key_words;
	private String estudante_cpf;
	private int vaga_id;
	private String vaga_empregador_id;
	
	public Aluno() {
		this.date = -1;
		this.procuraEstudante = "";
		this.key_words = "";
		this.estudante_cpf = "";
		this.vaga_id = -1;
		this.vaga_empregador_id = "";
	}
	
	public Aluno(int date, String procuraEstudante, String key_words, String estudante_cpf, int vaga_id, String vaga_empregador_id) {
		this.date = date;
		this.procuraEstudante = procuraEstudante;
		this.key_words = key_words;
		this.estudante_cpf = estudante_cpf;
		this.vaga_id = vaga_id;
		this.vaga_empregador_id = vaga_empregador_id;
	}

	
	
	public int getDate() {
		return date;
	}

	public vodate setDate(int date) {
		this.date = date;
	}

	public String getProcuraEstudante() {
		return procuraEstudante;
	}

	public void setProcuraEstudante(String procuraEstudante) {
		this.procuraEstudante = procuraEstudante;
	}

	public String getKey_words() {
		return key_words;
	}

	public void setKey_words(String key_words) {
		this.key_words = key_words;
	}

	public String getEstudante_cpf() {
		return estudante_cpf;
	}

	public void setEstudante_cpf(String estudante_cpf) {
		this.estudante_cpf = estudante_cpf;
	}


	public int getVaga_id() {
		return vaga_id;
	}

	public void setVaga_id(int vaga_id) {
		this.vaga_id = vaga_id;
	}

	public String getVaga_empregador_id() {
		return vaga_empregador_id;
	}

	public void setvaga_empregador_id(String vaga_empregador_id) {
		this.vaga_empregador_id = vaga_empregador_id;
	}
	

	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("date", this.getDate());
		obj.put("procuraEstudante", this.getNome());
		obj.put("key_words", this.getCpf());
		obj.put("estudante_cpf", this.getSenha());
		obj.put("vaga_id", this.getIs_monitor());
		obj.put("vaga_empregador_id", this.getCurso());
		return obj;
	}
	
}

