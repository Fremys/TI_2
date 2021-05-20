package app;
import static spark.Spark.*;

import services.*;

/*
 * 
INSERT INTO aluno (nome, cpf, senha, is_monitor, curso, id) VALUES ('Rodrigo', '11111111111', '123', 1, 'Ci�ncia da Computa��o', 1);
INSERT INTO aluno (nome, cpf, senha, is_monitor, curso, id) VALUES ('Marcus', '22222222222', '123', 1, 'Ci�ncia da Computa��o', 2);
INSERT INTO aluno (nome, cpf, senha, is_monitor, curso, id) VALUES ('Matheus', '33333333333', '123', 1, 'Ci�ncia da Computa��o', 3);
INSERT INTO aluno (nome, cpf, senha, is_monitor, curso, id) VALUES ('Camilla', '44444444444', '123', 0, 'Ci�ncia da Computa��o', 4);
INSERT INTO aluno (nome, cpf, senha, is_monitor, curso, id) VALUES ('Diogo', '55555555555', '123', 0, 'Ci�ncia da Computa��o', 5);


*/

public class Main {
	
	private final static EmpregadorService epService = new EmpregadorService();
	private final static EstudanteService esService = new EstudanteService();
	private final static FiltrosService ftService = new FiltrosService();
	private final static ProcuraService prService = new ProcuraService();
    private final static VadasService vgService = new VadasService();
	
	public static void main(String[]args) {
		//CONFIGS INICIAIS DE REQUISI��ES E PORTAS
		
		port(getHerokuAssignedPort());
		
		
		/*after((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, DELETE");
            response.header("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        });*/
		options("/*",	(request, response) -> {

		            String accessControlRequestHeaders = request
		                    .headers("Access-Control-Request-Headers");
		            if (accessControlRequestHeaders != null) {
		                response.header("Access-Control-Allow-Headers",
		                        accessControlRequestHeaders);
		            }

		            String accessControlRequestMethod = request
		                    .headers("Access-Control-Request-Method");
		            if (accessControlRequestMethod != null) {
		                response.header("Access-Control-Allow-Methods",
		                        accessControlRequestMethod);
		            }

		            return "OK";
		});

		before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//CONEXOES DE EMPREGADOR
		
		post("/empregador/add", (request,response) ->  epService.publicarEmpregador(request,response));
		
		get("/empregador/getAll", (request, response) -> {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			return epService.getAllEmpregador();
		});

        get("/empregador/:id", (request, response) -> {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			return epService.getEmpregador(request,response);
		});
		
        get("/empregador/update/:id", (request, response) -> epService.updateEmpregador(request, response));

		delete("/empregador/delete", (request, response) -> epService.deletarEmpregador(request));//fun�ao para o monitor deletar o empregador
		
		//FIM DE CONEXOES DO EMPREGADOR
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// CONEXOES DO ESTUDANTE
			
		post("/estudante/add", (request,response) ->  esService.publicarEstudante(request,response));

        get("/estudante/cpf", (request, response) -> {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			return esService.getEstudante(request, response);
		});
		
        get("/estudante/update/cpf", (request, response) -> esService.updateEstudante(request, response));

		delete("/estudante/delete", (request, response) -> esService.deletarEstudante(request));//fun�ao para o monitor deletar o estudante
		
        //FIM CONEXOES DO ESTUDANTE
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//CONEXOES DAS VAGAS

        post("/vaga/add", (request,response) ->  vgService.publicarVagas(request,response));
		
		get("/vaga/getAll/:id_empregador", (request, response) -> {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			return vgService.getAllVagasEmpregador(request,response);
		});
		
		get("/vaga/getAll", (request, response) -> {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			return vgService.getAllVagas(request,response);
		});

        get("/vaga/:id", (request, response) -> {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			return vgService.getVagas(request,response);
		});
		
        get("/vaga/update/:id", (request, response) -> vgService.updateVagas(request, response));

		delete("/vaga/delete", (request, response) -> vgService.deletarVagas(request));//fun�ao para o monitor deletar a vaga
		
		//FIM CONEXOES DAS VAGAS
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//CONEXOES FILTROS
		
		post("/filtros/add", (request,response) ->  ftService.addFiltros(request,response));
		
		//FIM FILTROS

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//CONEXOES PROCURA
		
		post("/procura/add", (request,response) ->  prService.addProcura(request,response));
		
		//FIM PROCURA
	}
	
	static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 6543; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
