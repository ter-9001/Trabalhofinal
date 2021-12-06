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
public class FuncionarioControl {
    
    
     public boolean Cadastrar( String nome, String CPF, int telefone ,String CEP, String Rua, int numero, String ponto_de_referencia )
    {
       return true; 
    }

    public Object getMinhaLista() {
         
        
        String [] [] obj = {{"0","Funcionário1", "1234"}, {"1","Funcionário2", "4534"}};

       
         return obj;

    }

    public void apagar(String dado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean Editar(String nome, int parseInt, int parseInt0, String Rua, int parseInt1, int parseInt2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String[][] getMinhaMatrizTexto() {

        String [] [] obj = {{"0","Funcionário1", "1234"}, {"1","Funcionário2", "4534"}};

       
         return obj;

    }
    
    
    
    
}
