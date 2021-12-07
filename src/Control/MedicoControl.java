
package Control;

import Model.Medico;
import java.sql.SQLException;
import java.util.*;

public class MedicoControl {
    
    private final Medico control;
    
    public MedicoControl() {
        this.control = new Medico();
    }
    
     public boolean Cadastrar(String nome, String crm, String especialidade, String periodoDeAtendimento, String telefone) throws SQLException {
         
         int id = control.maiorID() + 1;
        
         
         Medico objeto = new Medico( crm, especialidade, periodoDeAtendimento, id, nome, telefone);
         
          if(control.InsertMedicoBD(objeto)){
            return true;
        }else{
            return false;
        }
     }
     
           public boolean Editar(String nome, String crm,int id, String especialidade, String periodoDeAtendimento, String telefone) {
               
        Medico objeto = new Medico(crm,especialidade, periodoDeAtendimento, id,nome,telefone);
        
        if(control.UpdateMedicoBD(objeto)){
            return true;
        }else{
            return false;
        }
     }
            public boolean Apagar(int id) {
        if(control.DeleteMedicoBD(id)){
            return true;
            }else{
            return false;
        }
    }
            
            public Medico CarregarMedico(int id){
                return control.CarregueMedico(id);
            }

  
    public ArrayList getMinhaLista() {
        return control.getMinhaLista();
    }
    
  
    @SuppressWarnings("Unchecked")
    public String[][] getMinhaMatrizTexto() {

        System.out.println("GetminhaMatriz\n");
        
        ArrayList<Medico> minhalista = control.getMinhaLista();
       
        int tamanho = minhalista.size();
        String Matriz[][] = new String[tamanho][6];

        for (int i = 0; i < tamanho; i++) {
           
            Matriz[i][0] = minhalista.get(i).getId() + "";
            Matriz[i][1] = minhalista.get(i).getNome();
            Matriz[i][2] = minhalista.get(i).getTelefone();
            Matriz[i][3] = minhalista.get(i).getCrm();
            Matriz[i][4] = minhalista.get(i).getEspecialidade();
            Matriz[i][5] = minhalista.get(i).getPeriodoDeAtendimento() ;
        }

        System.out.println("Fim GetminhaMatriz\n");
        
        return Matriz;
    }

    

}
    
    
    
    

