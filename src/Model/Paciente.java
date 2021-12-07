package Model;

import java.sql.SQLException;
import java.util.Date;
import java.util.*;
import DAO.PacienteDAO;

public class Paciente extends Pessoa {

    private String endereco;
    private String rua;
    private String dataNascimento;
    private final PacienteDAO dao;

    public Paciente() {
        this.dao = new PacienteDAO();
    }

    public Paciente(String endereco,  String dataNascimento) {
        
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.dao = new PacienteDAO();
    
    }

    public Paciente(int id, String nome , String telefone, String endereco, String dataNascimento) {
        super(id, nome, telefone);
        this.endereco = endereco;
        this.rua = rua;
        this.dataNascimento = dataNascimento;
        this.dao = new PacienteDAO();
    }

    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }



    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String toString() {

        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Telefone: " + this.getTelefone()
                + "\n Endereco: " + this.getEndereco()
                + "\n DataNascimento: " + this.getDataNascimento()
                + "\n -----------";
    }
    

    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }

    public boolean InsertPacienteBD(Paciente objeto) {
        dao.InsertPacienteBD(objeto);
        return true;
    }

    public boolean DeletePacienteBD(int id) {
        dao.DeletePacienteBD(id);
        return true;
    }

    public boolean UpdatePacienteBD(int id, Paciente objeto) {
        dao.UpdatePacienteBD(objeto);
        return true;
    }

    public Paciente carregaPaciente(int id) {
        dao.carregaPaciente(id);
        return null;
    }

    public int maiorID() throws SQLException {
        return dao.maiorID();
    }

}
