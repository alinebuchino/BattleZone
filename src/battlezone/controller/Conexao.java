package battlezone.controller;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author Aline Buchino
 */
public class Conexao {
     
    Connection conect = null;
    
    public Connection conexao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/battlezone","root","");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao conectar" + e);
        }
        
        return conect;
        
    }
}
