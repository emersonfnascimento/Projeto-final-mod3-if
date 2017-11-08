//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD - 2017-2
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Emerson Freitas do Nascimento
//******************************************************
package projetofinalmodulo3;

/**
 *
 * @author Emerson
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexaoMySql {

    private static ConexaoMySql instance = null;
    private Connection connection = null;
    

    private ConexaoMySql() {
        try {
            
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            
            String serverName = "127.0.0.1";    
            
            //nesta linha estar� o nome do seu banco de dados. Olhe no workbench
            //o nome do banco. Caso voce tenha criado o modelo no workbench e n�o
            //tenha modificado o nome do banco, o nome padr�o � "mydb". 
            String dbName = "disciplinadb" ;        
            String url = "jdbc:mysql://" + 
                    serverName + "/" + 
                    dbName;
            
            //ajuste o username e password de acordo com o que voce utiliza para 
            //acessar o banco
            String username = "root";             
            String password = "";      
            
            connection = DriverManager.getConnection(url,
                    username, password);
              
            if (connection != null) {
                System.out.println("STATUS--->Conectado "
                        + "com sucesso!");
            } else {
                System.err.println("STATUS--->Não foi "
                        + "possivel realizar conexão");
            }
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException e) {  
            
            System.out.println("O driver expecificado"
                    + " nao foi encontrado.");
        } catch (SQLException e) {
            
            System.out.println("Nao foi possivel"
                    + " conectar ao Banco de Dados.");
            e.printStackTrace();
        }
        }

    public static ConexaoMySql getInstance() {
        if (instance == null) {
            instance = new ConexaoMySql();
        }
        return instance;
    }

    public java.sql.Connection getConnection() {
        return connection;
    }

    
}
