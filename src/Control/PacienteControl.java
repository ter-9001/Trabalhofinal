package Control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class PacienteControl {
    
     public boolean Cadastrar( String nome, String Endereço,  int Telefone, int data_de_nascimentos )
    {
       return true; 
    }

    public String [] [] getMinhaLista() {

        String [] [] obj = {{"0","Paciente1", "5678"}, {"1","Paciente2", "4534"}};

       
         return obj;
    }

    public void apagar(String dado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean Editar(String nome, String endereço, int parseInt, int parseInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String[][] getMinhaMatrizTexto() {
       
        String [] [] obj = {{"0","Paciente1", "5678"}, {"1","Paciente2", "4534"}};

       
         return obj;
    }
    
    
    
}
