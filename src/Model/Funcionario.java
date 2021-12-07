/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
import java.util.*;
import DAO.FuncionarioDAO;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class Funcionario extends Pessoa{
   
   private String cpf;
   private String cep;
   private String rua;
   private String numero; 
   private String ponto_de_referencia;
   private FuncionarioDAO dao;
   
     
    public Funcionario(int id, String nome, String telefone, String cpf, String cep, String  rua, String numero, String ponto_de_referencia){
     super(id, nome, telefone);
        this.cpf = cpf;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.ponto_de_referencia = ponto_de_referencia;
        dao = new FuncionarioDAO();
    }

    public Funcionario() {
         dao = new FuncionarioDAO();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    } 
        public String getRua() {
        return rua;
    } 
        public void setRua(String rua) {
        this.rua = rua;
    } 
    public String getnumero() { 
        return numero;
    } 
 public void setNumero(String numero) { 
        this.numero = numero;
 }  
public String getPonto_de_referencia() { 
        return ponto_de_referencia;
    } 
 public void setPonto_de_referencia(String ponto_de_referencia) { 
        this.ponto_de_referencia = ponto_de_referencia;
 }
 
 
 
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }

    public boolean InsertFuncionarioBD(Funcionario objeto) {
        dao.InsertfuncionarioBD(objeto);
        return true;
    }

    public boolean DeleteFuncionarioBD(int id) {
        dao.DeletefuncionarioBD(id);
        return true;
    }

    public boolean UpdateFuncionarioBD(int id, Funcionario objeto) {
        dao.UpdatefuncionarioBD(objeto);
        return true;
    }

    public Funcionario carregaFuncionario(int id) {
        dao.carregaFuncionario(id);
        return null;
    }

    public int maiorID() throws SQLException {
        return dao.maiorID();
    }
 
 
 
}