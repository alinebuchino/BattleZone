package battlezone.controller;

import battlezone.view.FrmListaProd;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aline Buchino
 */
public class ListaProd_CRUD {
     static Conexao cc = new Conexao();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    
    public static String LISTAR = "SELECT * FROM produto ORDER BY codigo_pro"; 
    
    //LISTAGEM POR CATEGORIA
    
    public static void listarCat(String busca){ 
        DefaultTableModel modelo = (DefaultTableModel) FrmListaProd.tabela.getModel(); // iniciar um objeto do tipo modelo da tabela
        
        while (modelo.getRowCount() > 0){ // se o modelo que foi associado tem mais de uma linha
            modelo.removeRow(0); // remove pois pode vim com alguma informação pré definida dentro da linha e eu quero apenas informações que forem associadas ao BD
        }
        String sql = ""; // se não tiver busca nenhuma irá listar todos os dados
        if (busca.equals("TIPO DE PRODUTO")){ 
            sql = LISTAR;
        }else{
            sql = "SELECT * FROM produto WHERE (codigo_pro like'" + busca + "%' or nome_pro like'" + busca + "%')" // o like é para relevar strings com letras maiusculas ou minusculas
                    + "or tipo_pro='" + busca + "' order by nome_pro";
        } 
        String dado[] = new String [4];
        try{ // verificar se irá passar da forma correta os dados
            Statement st = (Statement) cn.createStatement(); // executa uma consulta ao banco de dados
            ResultSet rs = (ResultSet) st.executeQuery(sql); // guarda o resultado executa a consulta
            while (rs.next()){ // next permite que o ponteiro seja direcionado para a próxima linha 
                dado[0] = rs.getString("codigo_pro"); // pegue o resultado da consulta o código e associe ao primeiro campo da tabela
                dado[1] = rs.getString("tipo_pro");
                dado[2] = rs.getString("nome_pro");
                dado[3] = rs.getString("valor_pro");
                modelo.addRow(dado); // adicione os dados a tabela
            }  
        } catch(SQLException e){
            
      }  
    }
    
    // Verificar Valores passado na tabela de CAIXA
    
    public static boolean isNumber(String n){
        try{
            if (Integer.parseInt(n) > 0){
                return true;
            } else{
                return false;
            }
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
