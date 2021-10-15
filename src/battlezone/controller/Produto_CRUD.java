package battlezone.controller;


import battlezone.model.Produtos_model;
import battlezone.view.FrmListaProd;
import static battlezone.view.FrmListaProd.tipo;
import battlezone.view.FrmProdutos;
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
public class Produto_CRUD {
    
    static Conexao cc = new Conexao();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    
    public static String LISTAR = "SELECT * FROM produto ORDER BY codigo_pro"; 
    public static String REGISTRAR = "INSERT INTO produto(codigo_pro, tipo_pro, nome_pro, valor_pro)" 
        + "VALUES(?,?,?,?)";
    
    public static String ATUALIZAR = "UPDATE produto SET "
            + "tipo_pro=?, "
            + "nome_pro=?, "
            + "valor_pro=? WHERE codigo_pro=?";
    public static String ELIMINAR = "DELETE FROM produto WHERE codigo_pro = ?";
    public static String ELIMINAR_TUDO = "DELETE FROM produto";
    
    //LISTAGEM DE PRODUTOS
    
    public static void listarProduto(String busca){ 
        DefaultTableModel modelo = (DefaultTableModel) FrmProdutos.tabela.getModel(); // iniciar um objeto do tipo modelo da tabela
        
        while (modelo.getRowCount() > 0){ // se o modelo que foi associado tem mais de uma linha
            modelo.removeRow(0); // remove pois pode vim com alguma informação pré definida dentro da linha e eu quero apenas informações que forem associadas ao BD
        }
        String sql = ""; // se não tiver busca nenhuma irá listar todos os dados
        if (busca.equals("")){ 
            sql = LISTAR;
        }else{
            sql = "SELECT * FROM produto WHERE (codigo_pro like'" + busca + "%' or nome_pro like'" + busca + "%')" // o like é para relevar strings com letras maiusculas ou minusculas
                    + "order by nome_pro";
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
    
      // REGISTRO DE PRODUTOS
    
    public static int registrarProduto (Produtos_model uc){ // objetos da classe usuário_model (nome, sexo, etc)
        int rsu = 0; // variável para guardar o resultado da consulta
        String sql = REGISTRAR; // String para receber toda a consulta sql REGISTRAR
        try{ // verificar se irá passar da forma correta os dados
            
            ps = (PreparedStatement) cn.prepareStatement(sql); // começa a conexão e faz as inserções no banco preparando os parametros para serem inseridos
            ps.setString(1, uc.getPrimaryKey());
            ps.setString(2, uc.getTipo()); 
            ps.setString(3, uc.getNome());
            ps.setString(4, uc.getValor());

            rsu = ps.executeUpdate(); // para atualizar as informações no BD
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Produto já registrado","Cadastro de Usuários",0);
        }
        System.out.println(sql);
        return rsu;
    }
    
    // GERAR ID DE FORMA DINÂMICA
    
    public static void gerarId(){
        
        int j;
        String c = "";
        String SQL = "SELECT MAX(codigo_pro) FROM produto";
    
        try{
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(SQL);
            while (rs.next()){
                c = rs.getString(1);
            }
            
            if (c == null){
                FrmProdutos.codigo.setText("PRO0001");
            } else{
                char r1 = c.charAt(3);
                char r2 = c.charAt(4);
                char r3 = c.charAt(5);
                char r4 = c.charAt(6);
                String r = "";
                r = "" + r1 + r2 + r3 + r4;
                j = Integer.parseInt(r);
                GerarCodigos gen = new GerarCodigos();
                gen.gerar(j);
                FrmProdutos.codigo.setText("PRO" + gen.serie());
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro de Produtos",0);
        } 
    
    
    // ATUALIZAR PRODUTO
    
    }
    public static int atualizarProduto (Produtos_model uc){ // objetos da classe usuário_model (nome, sexo, etc)
        int rsu = 0; // variável para guardar o resultado da consulta
        String sql = ATUALIZAR; // String para receber toda a consulta sql REGISTRAR
        try{ // verificar se irá passar da forma correta os dados 
            ps = (PreparedStatement) cn.prepareStatement(sql); // começa a conexão e faz as inserções no banco preparando os parametros para serem inseridos   
            ps.setString(1, uc.getTipo()); 
            ps.setString(2, uc.getNome());
            ps.setString(3, uc.getValor());
            ps.setString(4, uc.getPrimaryKey());
            rsu = ps.executeUpdate(); // para atualizar as informações no BD
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Atualização de Produtos",0);
      }
        System.out.println(sql);
        return rsu;
    }
    
    // EXCLUIR PRODUTO
    
    public static int eliminarProduto(String id){
        int rsu = 0; // variável para guardar o resultado da consulta
        String sql = ELIMINAR; // String para receber toda a consulta sql ELIMINAR
        try{
            ps = (PreparedStatement) cn.prepareStatement(sql); // começa a conexão e faz as inserções no banco preparando os parametros para serem inseridos
            ps.setString(1, id); // pega o ID do usuário
            rsu = ps.executeUpdate(); // para atualizar as informações no BD
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Exclusão de Produtos",0);
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
     public static void listarCat(String busca){ 
        DefaultTableModel modelo = (DefaultTableModel) FrmListaProd.tabela.getModel(); // iniciar um objeto do tipo modelo da tabela
        
        while (modelo.getRowCount() > 0){ // se o modelo que foi associado tem mais de uma linha
            modelo.removeRow(0); // remove pois pode vim com alguma informação pré definida dentro da linha e eu quero apenas informações que forem associadas ao BD
        }
        String sql = ""; // se não tiver busca nenhuma irá listar todos os dados
        if (tipo.getSelectedItem().equals("TIPO DE PRODUTO")){     
            sql = LISTAR;
        }else{
            sql = "SELECT * FROM produto WHERE(codigo_pro like'" + busca + "%' or nome_pro like'" + busca + "%')" // o like é para relevar strings com letras maiusculas ou minusculas
                    + "or tipo_pro='" + busca + "order by nome_pro";
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
}
