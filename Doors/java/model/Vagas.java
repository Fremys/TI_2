package model;

import org.json.JSONObject;

public class Vagas implements JsonFormatter{

    private int id;
    private int empregador_id;
    private String titulo;
    private String descricao;
    private String beneficios;
    private String requisitos;
    private String imagem;
    private double salario;
    private String categorias;

    public vagas()
    {
        id = -1;
        empregador_id = -1;
        titulo = null;
        descricao = null;
        beneficios = null;
        requisitos = null;
        imagem = null;
        salario = 0.0;
        categorias = null;
    }

    public vagas(int id, int empregador_id, String titulo, String descricao, String beneficios, String requisitos, String imagem, double salario, String categorias)
    {
        this.id = id;
        this.empregador_id = empregador_id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.beneficios = beneficios;
        this.requsiitos = requisitos;
        this.imagem = imagem;
        this.salario = salario;
        this.categorias = categorias;
    }
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getEmpregadorId()
    {
        return empregador_id;
    }

    public void setEmpregadorId(String empregador_id)
    {
        this.empregador_id = empregador_id;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void postTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void postDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getBenefiicos()
    {
        return beneficios;
    }

    public void postBenefiicos(String requsiitos)
    {
        this.beneficios = beneficios;
    }

    public String getRequisitos()
    {
        return requisitos;
    }

    public void postRequisitos(String requsiitos)
    {
        this.requisitos = requisitos;
    }

    public String getImagem()
    {
        return imagem;
    }

    public void postImagem(String imagem)
    {
        this.imagem = imagem;
    }

    public double getSalario()
    {
        return salario;
    }
    
    public void postSalario(double salario)
    {
        this.salario = salario;
    }

    public String getCategorias()
    {
        return categorias;
    }

    public void postCategorias(String categorias)
    {
        this.categorias = categorias;
    }

    /**
	 * Converte um estudante para formato JSON
	 */

	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.getId());
		obj.put("empregador_id", this.getEmpregadorId());
		obj.put("titulo", this.getTitulo());
        obj.put("descricao", this.getDescricao());
        obj.put("beneficios", this.getBeneficios());
        obj.put("requisitos", this.getRequisitos());
        obj.put("imagem", this.getImagem());
        obj.put("salario", this.getSalario());
        obj.put("categorias", this.getCategorias());
		return obj;
	}


}
