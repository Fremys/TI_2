package model;

import org.json.JSONObject;

public class Estudante implements JsonFormatter{
    private String cpf;
    private String usuario;
    private String senha;
	private String prenome;
    private String sobrenome;
    private String email;
    private int periodo;
    private String curso;
    private int telefone;
    private String endereco;
    private String linkedin;
    private String idiomas;
    private String skills;
    private int foto;
	
	public Estudante() {
		this.cpf = "";
        this.usuario = "";
        this.senha = "";
        this.prenome = "";
        this.sobrenome = "";
        this.email = "";
        this.periodo = 0;
        this.curso = "";
        this.telefone = 0;
        this.endereco = "";
        this.linkedin = "";
        this.idiomas = "";
        this.skills = "";
        this.foto = 0;
	}
	
	public Estudante(String cpf, String usuario, String senha, String prenome, String sobrenome, 
                    String email, int periodo, String curso, int telefone, String endereco,
                    String linkedin, String idiomas, String skills, int foto) {
		this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
        this.prenome = prenome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.periodo = periodo;
        this.curso = curso;
        this.telefone = telefone;
        this.endereco = endereco;
        this.linkedin = linkedin;
        this.idiomas = idiomas;
        this.skills = skills;
        this.foto = foto;
	}

	
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

    public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

    public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPrenome() {
		return prenome;
	}

	public void setPrenome(String prenome) {
		this.prenome = prenome;
	}

    public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

    public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

    public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

    public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}   

    public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}  

    public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}  

    public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}  

    public int getFoto() {
		return foto;
	}

	public void setFoto(int foto) {
		this.foto = foto;
	}

    
	/**
	 * Converte um estudante para formato JSON
	 */
	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("cpf", this.getCpf());
        obj.put("usuario", this.getUsuario());
        obj.put("senha", this.getSenha());
        obj.put("prenome", this.getPrenome());
        obj.put("sobrenome", this.getSobrenome());
        obj.put("email", this.getEmail());
        obj.put("periodo", this.getPeriodo());
        obj.put("curso", this.getCurso());
        obj.put("telefone", this.getTelefone());
        obj.put("endereco", this.getEndereco());
        obj.put("linkedin", this.getLinkedin());
        obj.put("idiomas", this.getIdiomas());
        obj.put("skills", this.getSkills());
        obj.put("foto", this.getFoto());
		return obj;
	}
	
}
