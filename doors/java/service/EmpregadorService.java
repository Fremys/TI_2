package services;

import model.*;
import dao.*;
import app.*;

import org.json.JSONArray;

import spark.Request;
import spark.Response;

public class EmpregadorService {

    private DAOAEmpregador conexao;
    
    public EmpregadorService() {
        // TODO Auto-generated constructor stub
        conexao = new DAOAEmpregador();
    }
    
    public Object getAllEmpregadorLogs() {
        StringBuffer returnValue = new StringBuffer("[");
        conexao.conectar();
        if(conexao.getAll() != null) {
            Empregador[]a = conexao.getAll();
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

}