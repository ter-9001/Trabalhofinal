
package DAO;

import Model.Medico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class MedicoDAO {
    
    public static ArrayList<Medico>MinhaLista = new ArrayList<Medico>();
   
    
     public MedicoDAO() {
    }
    
     public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement state = this.getConexao().createStatement();
            
            ResultSet set = state.executeQuery("SELECT MAX(id) id FROM medico");
            
            set.next();
            
            maiorID = set.getInt("id");

            state.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }
    
 public Connection getConexao() {

        Connection connection = null;  

        try {

            
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

           
            String server = "localhost"; 
            String database = "trabalho_final";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "";

            connection = DriverManager.getConnection(url, user, password);

           
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: N�O CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  
            System.out.println("O driver nao foi encontrado. " + e.getMessage() );
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
 }
 
 public ArrayList getMinhaLista(){
     MinhaLista.clear();
     
     try{
         System.out.println("Indo\n");
          Statement state = this.getConexao().createStatement();
            ResultSet set = state.executeQuery("SELECT * FROM medico");
            while (set.next()) {

                int id = set.getInt("Id");
                String nome = set.getString ("nome");
                String telefone = set.getString("telefone");
                String crm = set.getString ("crm");
                String especialidade = set.getString ("especialidade");
                String periodoDeAtendimento = set.getString ("periodo_de_atendimento");
                
                Medico objeto = new Medico ( crm,especialidade,periodoDeAtendimento, id, nome,telefone);
                MinhaLista.add(objeto);
                
         System.out.println("Adcionado\n");
                }
            
            state.close();
     }   catch (SQLException ex){
                    
                    } return MinhaLista;
 }
 
    public boolean InsertMedicoBD(Medico objeto) {
        String sql = "INSERT INTO medico(Id,nome,telefone,crm,especialidade,periodo_de_atendimento) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement state = this.getConexao().prepareStatement(sql);
            state.setInt(1, objeto.getId());
            state.setString(2, objeto.getNome());
            state.setString(3, objeto.getTelefone());
            state.setString(4, objeto.getCrm());
            state.setString(5, objeto.getEspecialidade());
            state.setString(6, objeto.getPeriodoDeAtendimento());

           state.execute();
            state.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
        public boolean DeleteMedicoBD(int id) {
        try {
            Statement set = this.getConexao().createStatement();
            set.executeUpdate("DELETE FROM medico WHERE id = " + id);
            set.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    
        }
        
        public boolean UpdateMedicoBD(Medico objeto) {

        String sql = "UPDATE medico set id = ? ,nome = ? ,telefone = ? ,crm = ?,especialidade = ?, periodoDeAtendimento = ?, WHERE id = ?";

        try {
            PreparedStatement state = this.getConexao().prepareStatement(sql);

            state.setInt(1, objeto.getId());
            state.setString(2, objeto.getNome());
            state.setString(3, objeto.getTelefone());
            state.setString(4, objeto.getCrm());
            state.setString(5, objeto.getEspecialidade());
            state.setString(6, objeto.getPeriodoDeAtendimento());

            state.execute();
            state.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

        }
        
          public Medico carregaMedico (int id) {
        
        Medico objeto = new Medico();
        objeto.setId(id);
        
        try {
            Statement state = this.getConexao().createStatement();
            ResultSet set = state.executeQuery("SELECT * id FROM medico WHERE id = " + id);
            set.next();

            objeto.setNome(set.getString("nome"));
            objeto.setTelefone(set.getString("telefone"));
            objeto.setCrm(set.getString("crm"));
            objeto.setEspecialidade(set.getString("especialidade"));
            objeto.setPeriodoDeAtendimento(set.getString("periodo De Atendimento"));

            state.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }
}
        
        
        
        
        
        
        






 
    

