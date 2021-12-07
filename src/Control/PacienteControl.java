package Control;

import Model.Paciente;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.Date;

public class PacienteControl {

    private final Paciente paciente;

    public PacienteControl() {
        this.paciente = new Paciente();
    }

    // int id, String nome , String telefone, String endereco, Date dataNascimento
   
    public boolean Cadastrar(String nome, String endereco, String telefone, String data) throws SQLException{

        int id = paciente.maiorID() + 1;

        Paciente objeto = new Paciente(id, nome, telefone, endereco, data);

        if (paciente.InsertPacienteBD(objeto)) {
            return true;
        } else {
            return false;
        }

    }
  
   
    
    public boolean Editar (String nome, String endereco,int id, String telefone, String dataNascimento) {

        Paciente objeto = new Paciente(id, nome, telefone, endereco, dataNascimento);

        if (paciente.UpdatePacienteBD(id,objeto)) {
            return true;
        } else {
            return false;
        }

    }
    
    
    
    public boolean Apagar(int id) {

        if (paciente.DeletePacienteBD(id)) {
            return true;
        } else {
            return false;
        }

    }
    
    public Paciente LoadPaciente(int id) {
        
        return paciente.carregaPaciente(id);
    }
    
    public ArrayList getMinhaLista(){
        return paciente.getMinhaLista();
    }
    
    
    
    @SuppressWarnings("unchecked")
    
    public String[][] getMinhaMatrizTexto(){
        
        ArrayList<Paciente> minhalista = paciente.getMinhaLista();
        int tamanho = minhalista.size();
        
        String MatrizAlunos[][] = new String[tamanho][5];
        for (int i = 0; i < tamanho; i++) {
            MatrizAlunos[i][0] = minhalista.get(i).getId() + "";
            MatrizAlunos[i][1] = minhalista.get(i).getNome();
            MatrizAlunos[i][2] = minhalista.get(i).getTelefone()+ "";
            MatrizAlunos[i][3] = minhalista.get(i).getEndereco();
            MatrizAlunos[i][4] = minhalista.get(i).getDataNascimento()+ "";
        }        
        
        return MatrizAlunos;
        
        
    }
    
    
}
