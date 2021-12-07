
package Model;


import DAO.MedicoDAO;
import java.sql.SQLException;
import java.util.*;

public class Medico extends Pessoa{
    
    private String crm;
    private String especialidade;
    private String periodoDeAtendimento;
    private final MedicoDAO dao;

    public Medico() {
        this.dao = new MedicoDAO();
    }

    public Medico(String crm, String especialidade, String periodoDeAtendimento) {
        this.crm = crm;
        this.especialidade = especialidade;
        this.periodoDeAtendimento = periodoDeAtendimento;
        this.dao = new MedicoDAO();
    }

    public Medico(String crm, String especialidade, String periodoDeAtendimento, int id, String nome, String telefone) {
        super(id, nome, telefone);
        this.crm = crm;
        this.especialidade = especialidade;
        this.periodoDeAtendimento = periodoDeAtendimento;
        this.dao = new MedicoDAO();
    }

   

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getPeriodoDeAtendimento() {
        return periodoDeAtendimento;
    }

    public void setPeriodoDeAtendimento(String tperiodoDeAtendimento) {
        this.periodoDeAtendimento = periodoDeAtendimento;
    }
    
    public ArrayList getMinhaLista() {
    return dao.getMinhaLista();
}

   public boolean InsertMedicoBD(Medico objeto){
       dao.InsertMedicoBD(objeto);
        return true;
   }
   
   public boolean DeleteMedicoBD(int id) {
//       int indice = this.procuraIndice(id);
       dao.DeleteMedicoBD(id);
        return true;
   }
   
   public boolean UpdateMedicoBD( Medico objeto) {
//       int indice = this.procuraIndice(id);
       dao.UpdateMedicoBD(objeto);
       return true;
   }
   
   public Medico CarregueMedico(int id){
       dao.carregaMedico(id);
       return null;
   }
   
//   private int procuraIndice(int id) {
//       int indice = -1;
//for (int i = 0; i < MedicoDAO.MinhaLista.size(); i++) {
//if (MedicoDAO.MinhaLista.get(i).getId() == id) {
//indice = i;
//}
//}
//       return indice;
//   }
   public int maiorID() throws SQLException {
   return dao.maiorID();
   }

    @Override
    public String toString() {
        return "\n Id: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n CRM: " + this.getCrm()
                + "\n Especialidade: " + this.getEspecialidade()
                + "\n Periodo De Atendimento: " + this.getPeriodoDeAtendimento()
                + "\n --------------" ;
    }
    
    }
   
   
   
    
    
   
