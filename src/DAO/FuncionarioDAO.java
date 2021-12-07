package DAO;


import Model.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class FuncionarioDAO {

    public static ArrayList<Funcionario> MinhaLista = new ArrayList<Funcionario>();


    public FuncionarioDAO() {
    }
    
    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM funcionario");
            res.next();
            maiorID = res.getInt("id");

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

            String server = "localhost"; //caminho do MySQL
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
 
    public ArrayList getMinhaLista() {
        
        MinhaLista.clear(); 

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM funcionario");
            while (res.next()) {

                String ponto_de_referencia = res.getString("ponto_de_referencia");
                String rua = res.getString("rua");
                String numero = res.getString("numero");
                String cpf = res.getString("cpf");
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String telefone = res.getString("telefone");
                String cep = res.getString("cep");
                
                Funcionario objeto = new Funcionario (id, nome, telefone, cpf, cep , rua, numero, ponto_de_referencia);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    public boolean InsertfuncionarioBD(Funcionario objeto) {
        String sql = "INSERT INTO funcionario (id,nome,telefone,numero,rua,cpf,ponto_de_referencia, cep) VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());
            stmt.setString(4, objeto.getnumero());
            stmt.setString(5, objeto.getRua());
            stmt.setString(6, objeto.getCpf());
            stmt.setString(7, objeto.getPonto_de_referencia());
            stmt.setString(8, objeto.getCep());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
      public boolean DeletefuncionarioBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM funcionario WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }
   
       public boolean UpdatefuncionarioBD(Funcionario objeto) {

        String sql = "UPDATE funcionario set id = ? ,nome = ? ,telefone = ? ,numero =? ,rua = ?,cpf = ?,ponto_de_referencia = ?, cep = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());
            stmt.setString(4, objeto.getnumero());
            stmt.setString(5, objeto.getRua());
            stmt.setString(6, objeto.getCpf());
            stmt.setString(7, objeto.getPonto_de_referencia()); 
            
            stmt.setString(8, objeto.getCep()); 
            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }      

      public Funcionario carregaFuncionario(int id) {
        
        Funcionario objeto = new Funcionario();
        objeto.setId(id);
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * id FROM funcionario WHERE id = " + id);
            res.next();

            objeto.setId(res.getInt("id"));
            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getString("telefone"));
            objeto.setNumero(res.getString("numero"));
            objeto.setRua(res.getString("rua"));
            objeto.setCpf(res.getString("cpf"));
            objeto.setPonto_de_referencia(res.getString("dataNascimento"));
            objeto.setCep(res.getString("cep"));
            

            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }
}
