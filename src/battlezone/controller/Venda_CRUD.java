package battlezone.controller;

import battlezone.model.venda_model;
import battlezone.view.FrmCaixa;
import battlezone.view.FrmVendas;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aline Buchino
 */
public class Venda_CRUD {
    
    static Conexao cc = new Conexao();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    
    public static String LISTAR = "SELECT * FROM venda ORDER BY data_ven"; 
    public static String REGISTRAR = "INSERT INTO venda(numero_ven, total_ven, data_ven) " 
        + "VALUES(?,?,?)";
    
    public static String ELIMINAR = "DELETE FROM venda WHERE numero_ven = ?";
    public static String ELIMINAR_TUDO = "DELETE FROM venda";
    
     // REGISTRO DE VENDAS
    
    public static int registrarVenda (venda_model uc){ // objetos da classe usuário_model (nome, sexo, etc)
        int rsu = 0; // variável para guardar o resultado da consulta
        String sql = REGISTRAR; // String para receber toda a consulta sql REGISTRAR
        try{ // verificar se irá passar da forma correta os dados
            
            ps = (PreparedStatement) cn.prepareStatement(sql); // começa a conexão e faz as inserções no banco preparando os parametros para serem inseridos
            ps.setString(1, uc.getPrimaryKey());
            ps.setString(2, uc.getTotal()); 
            ps.setString(3, uc.getData());

            rsu = ps.executeUpdate(); // para atualizar as informações no BD
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Venda já registrada","Cadastro de Vendas",0);
        }
        System.out.println(sql);
        return rsu;
    }
    
    // ELIMINAR VENDA
    
    public static int eliminarVenda(String id){
        int rsu = 0; // variável para guardar o resultado da consulta
        String sql = ELIMINAR; // String para receber toda a consulta sql ELIMINAR
        try{
            ps = (PreparedStatement) cn.prepareStatement(sql); // começa a conexão e faz as inserções no banco preparando os parametros para serem inseridos
            ps.setString(1, id); // pega o ID do usuário
            rsu = ps.executeUpdate(); // para atualizar as informações no BD
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Exclusão",0);
    }
        System.out.println(sql);
        return rsu;
    }
    
    // ELIMINAR TODOS
    
    public static int eliminarTodos(){
        int rsu = 0; // variável para guardar o resultado da consulta
        String sql = ELIMINAR_TUDO; // String para receber toda a consulta sql ELIMINAR_TUDO
        try{
            ps = (PreparedStatement) cn.prepareStatement(sql); // começa a conexão 
            rsu = ps.executeUpdate(); // para atualizar as informações no BD
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Exclusão de todos os Produtos",0);
    }
        System.out.println(sql);
        return rsu;
    }
    
    //LISTAGEM DE VENDAS
    
    public static void listarVenda(String busca){ 
        DefaultTableModel modelo = (DefaultTableModel) FrmVendas.tabela.getModel(); // iniciar um objeto do tipo modelo da tabela
        
        while (modelo.getRowCount() > 0){ // se o modelo que foi associado tem mais de uma linha
            modelo.removeRow(0); // remove pois pode vim com alguma informação pré definida dentro da linha e eu quero apenas informações que forem associadas ao BD
        }
        String sql = ""; // se não tiver busca nenhuma irá listar todos os dados
        if (busca.equals("")){ 
            sql = LISTAR;
        }else{
            sql = "SELECT * FROM venda WHERE (numero_ven like'" + busca + "%' or data_ven='" + busca + "')" // o like é para relevar strings com letras maiusculas ou minusculas
                    + " ORDER BY data_ven";
        } 
        String dado[] = new String [3];
        try{ // verificar se irá passar da forma correta os dados
            Statement st = (Statement) cn.createStatement(); // executa uma consulta ao banco de dados
            ResultSet rs = (ResultSet) st.executeQuery(sql); // guarda o resultado executa a consulta
            while (rs.next()){ // next permite que o ponteiro seja direcionado para a próxima linha 
                dado[0] = rs.getString("numero_ven"); // pegue o resultado da consulta o código e associe ao primeiro campo da tabela
                dado[1] = rs.getString("total_ven");
                dado[2] = rs.getString("data_ven");
                modelo.addRow(dado); // adicione os dados a tabela
            }  
        } catch(SQLException e){
            
        }
    }
    // GERAR ID
    
    public static void numeros(){
        int j;
        String c = "";
        String SQL = "SELECT MAX(numero_ven) FROM venda";
    
        try{
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(SQL);
            while (rs.next()){
                c = rs.getString(1);
            }
            
            if (c == null){
                FrmCaixa.numeroVenda.setText("00000001");
            } else{
                j = Integer.parseInt(c);
                GerarNumero gen = new GerarNumero();
                gen.gerar(j);
                FrmCaixa.numeroVenda.setText(gen.serie());
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Vendas",0);
        } 
    }
}
