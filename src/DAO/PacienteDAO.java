package DAO;
import Model.Paciente;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PacienteDAO {

    public static ArrayList<Paciente> MinhaLista = new ArrayList<Paciente>();
    
    public PacienteDAO() {
    }
    
    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM paciente;");
            res.next();
            if(res.getInt("id") >= 0)
                maiorID = res.getInt("id");
            else
                maiorID = 0;
            
            stmt.close();

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

          }
        catch (ClassNotFoundException e) {  
                    System.out.println("O driver nao foi encontrado. " + e.toString() );
                    return null;

        }
           catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    
    
    }
    
      
    public ArrayList getMinhaLista() {
        
        MinhaLista.clear(); 

        try {
                
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM paciente");
            while (res.next()) {

                String endereco = res.getString("endereco");
                
                Date dataNascimento = res.getDate("data_nascimento");
                int id = res.getInt("id");
                String nome = res.getString("nome");
                int telefone = res.getInt("telefone");
                
                
                Paciente objeto = new Paciente (id, nome,telefone, endereco, dataNascimento);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }
    
   
    public boolean InsertPacienteBD(Paciente objeto) {
        String sql = "INSERT INTO paciente (id,nome,endereco, telefone, data_nascimento) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getEndereco());
            stmt.setInt(4, objeto.getTelefone());
            
            //objeto.getDataNascimento()
            java.sql.Date sqlStartDate = new java.sql.Date(   objeto.getDataNascimento().getTime()); 
            
            stmt.setDate(5, sqlStartDate  ); 

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    
    
      public boolean DeletePacienteBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM paciente WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }
    
    
        
       public boolean UpdatePacienteBD(Paciente objeto) {

        String sql = "UPDATE paciente set id = ? ,nome = ? ,endereco =?, telefone = ?  ,data_nascimento = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone()+"");
            stmt.setString(4, objeto.getEndereco());
            
            stmt.setDate(5, (java.sql.Date) objeto.getDataNascimento()); 

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }      

      public Paciente carregaPaciente(int id) {
        
        Paciente objeto = new Paciente();
        objeto.setId(id);
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * id FROM paciente WHERE id = " + id);
            res.next();

            objeto.setId(res.getInt("id"));
            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getInt("telefone"));
            objeto.setEndereco(res.getString("endereco"));
           
            objeto.setDataNascimento(res.getDate("data_nascimento"));
            

            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }
}
