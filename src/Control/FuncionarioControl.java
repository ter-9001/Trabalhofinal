package Control;

import Model.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioControl {
    
    private final Funcionario control;
    
    public FuncionarioControl() {
        
        this.control = new Funcionario();
              
    }
    
    public boolean Cadastrar (String nome, String telefone , String cep, String cpf, String rua, String numero, String ponto_de_referencia) throws SQLException {

                    int id = control.maiorID() + 1;

                    Funcionario objeto = new Funcionario (id, nome, telefone, cpf, cep , rua, numero, ponto_de_referencia);

                    if (control.InsertFuncionarioBD(objeto)){
                          return true;
                    }else{
                          return false;
                    }
    }


    public boolean Editar(int id, String nome, String telefone , String cep, String cpf, String rua, String numero, String ponto_de_referencia) {
       
        Funcionario objeto = new Funcionario (id, nome, telefone, cpf, cep , rua, numero, ponto_de_referencia);
        
        if(control.UpdateFuncionarioBD(id, objeto)){
            return true;
        }else{
        return false;
        
        }
}

    public boolean Apagar(int id){
        if(control.DeleteFuncionarioBD(id)){
            return true;
        }else{
            return false;
}
}
    public ArrayList getMinhaLista() {
        return control.getMinhaLista() ;
}

    public Funcionario LoadFuncionario(int id) {
        // procurar o aluno com este id e retornar um objeto com TODOS OS DADOS.
        return control.carregaFuncionario(id);
    }

    
    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {
        
        ArrayList <Funcionario> minhalista = control.getMinhaLista();
        int tamanho = minhalista.size();
        
        //id, nome, telefone, cpf, cep , rua, numero, ponto_de_referencia
        
        String MatrizFuncionarios[][] = new String[tamanho][8];
        for (int i = 0; i < tamanho; i++) {
            MatrizFuncionarios[i][0] = minhalista.get(i).getId() + "";
            MatrizFuncionarios[i][1] = minhalista.get(i).getNome();
            MatrizFuncionarios[i][2] = minhalista.get(i).getTelefone();
            MatrizFuncionarios[i][3] = minhalista.get(i).getCpf();
            MatrizFuncionarios[i][4] = minhalista.get(i).getCep();
            MatrizFuncionarios[i][5] = minhalista.get(i).getRua();
            MatrizFuncionarios[i][6] = minhalista.get(i).getnumero();
            MatrizFuncionarios[i][7] = minhalista.get(i).getPonto_de_referencia();
            
            
        }        
        
        return MatrizFuncionarios;  
        
    }


}