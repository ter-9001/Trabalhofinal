/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Gabriel
 */
public class MedicoControl {
    
    
    public boolean Cadastrar( String nome, String CRM, String Especialidade,  int Telefone, String perido_de_atendimento )
    {
       return true; 
    }

    public String [] [] getMinhaLista() {
        
        String [][] dado = { {"0", "Gabriel", "098901" ,"Nerologia"}, { "1" , "Maria", "0891234" ,"Cardiologia"} };
        return dado;
        
    }

    public String [] [] getMinhaMatrizTexto() {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Template.
      }

    public boolean Editar(int id, String nome, int CRM, String Especialidade, int telefone ,String periodo_de_atendimento) {

        


     return true;
    }

    public void apagar(String dado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
