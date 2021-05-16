package model;

import org.json.JSONObject;

public class Filtros implements JsonFormatter{
    private int procura_data;
    private String procura_estudante_cpf;
    private int procura_vaga_empregador;
    private int procura_vaga_id;
    private int periodo;
	private String categoria;
	
	public Filtros() {
		this.procura_data = 0;
        this.procura_estudante_cpf = "";
        this.procura_vaga_empregador = 0;
        this.procura_vaga_id = 0;
        this.periodo = 0;
        this.categoria = "";
	}
	
	public Filtros(int procura_data, String procura_estudante_cpf, int procura_vaga_empregador, int procura_vaga_id, int periodo, String categoria) {
		this.procura_data = procura_data;
        this.procura_estudante_cpf = procura_estudante_cpf;
        this.procura_vaga_empregador = procura_vaga_empregador;
        this.procura_vaga_id = procura_vaga_id;
        this.periodo = periodo;
        this.categoria = categoria;
	}

	
	
	public String get_procura_estudante_cpf() {
		return procura_estudante_cpf;
	}

	public void set_procura_estudante_cpf(String procura_estudante_cpf) {
		this.procura_estudante_cpf = procura_estudante_cpf;
	}

    public int get_procura_data() {
		return procura_data;
	}

	public void set_procura_data(int procura_data) {
		this.procura_data = procura_data;
	}

    public int get_procura_vaga_empregador() {
		return procura_vaga_empregador;
	}

	public void set_procura_vaga_empregador(int procura_vaga_empregador) {
		this.procura_vaga_empregador = procura_vaga_empregador;
	}

    public int get_procura_vaga_id() {
		return procura_vaga_id;
	}

	public void set_procura_vaga_id(int procura_vaga_id) {
		this.procura_vaga_id = procura_vaga_id;
	}

    public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

    public String getcategoria() {
		return categoria;
	}

	public void setcategoria(String categoria) {
		this.categoria = categoria;
	}

    
	/**
	 * Converte um filtro para formato JSON
	 */
	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("procura_estudante_cpf", this.get_procura_estudante_cpf());
        obj.put("procura_data", this.get_procura_data());
        obj.put("procura_vaga_empregador", this.get_procura_vaga_empregador());
        obj.put("procura_vaga_id", this.get_procura_vaga_id());
        obj.put("categoria", this.getcategoria());
        obj.put("periodo", this.getPeriodo());
		return obj;
	}
	
}