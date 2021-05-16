package model;

import org.json.JSONObject;

package model;

import org.json.JSONObject;

public class Empregador implements JsonFormatter{
	private int id;
	private String cnpj;
	private String cpf;
	private String senha;
	private String nome;
	private String email;
    private String descricao;
    private String site;
	
	public Empregador() {
		this.id = -1;
        this.cnpj = "";
		this.cpf = "";
		this.senha = "";
        this.nome = "";
        this.email = "";
		this.descricao = "";
        this.site = "";
	}
	
	public Empregador(int id, String cnpj, String cpf, String senha, String nome, String email, String descricao, String site{
        this.id = -1;
        this.cnpj = "";
		this.cpf = "";
		this.senha = "";
        this.nome = "";
        this.email = "";
		this.descricao = "";
        this.site = ""; 
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
////////////////////////////////////////
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
///////////////////////////////////////
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
//////////////////////////////////////////    
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
/////////////////////////////////////////
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
////////////////////////////////////////
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
////////////////////////////////////////	
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
///////////////////////////////////////
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    /**
	 * Converte um aluno para formato JSON
	 */
	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.getId());
		obj.put("cnpj", this.getCnpj());
		obj.put("cpf", this.getCpf());
		obj.put("senha", this.getSenha());
        obj.put("nome", this.getNome());
        obj.put("email", this.getEmail());
        obj.put("descricao", this.getDescricao());
		obj.put("site", this.getSite());

		return obj;
	}
	
}
