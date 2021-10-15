package battlezone.controller;

import battlezone.model.Usuarios_model;
import battlezone.view.FrmUsuarios;
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
public class Usuarios_CRUD {
   
    static Conexao cc = new Conexao();
    static Connection cn = cc.conexao();
    static PreparedStatement ps;
    
    public static String LISTAR_US = "SELECT * FROM usuario ORDER BY nome_us"; 
    public static String REGISTRAR = "INSERT INTO usuario(codigo_us, nome_us, sexo_us, tipo_us, senha)" 
        + "VALUES(?,?,?,?,?)";
    
    public static String ATUALIZAR = "UPDATE usuario SET "
            + "nome_us=?, "
            + "sexo_us=?, "
            + "tipo_us=?, "
            + "senha=? WHERE codigo_us=?";
    public static String ELIMINAR = "DELETE FROM usuario WHERE codigo_us = ?";
    public static String ELIMINAR_TUDO = "DELETE FROM usuario";
    
    
    // LISTAGEM DE USUÁRIOS
    
    public static void ListarUsuarios(String busca){ 
        DefaultTableModel modelo = (DefaultTableModel) battlezone.view.FrmUsuarios.tabelaUsuarios.getModel(); // iniciar um objeto do tipo modelo da tabela
        
        while (modelo.getRowCount() > 0){ // se o modelo que foi associado tem mais de uma linha
            modelo.removeRow(0); // remove pois pode vim com alguma informação pré definida dentro da linha e eu quero apenas informações que forem associadas ao BD
        }
        String sql = ""; // se não tiver busca nenhuma irá listar todos os dados
        if (busca.equals("")){ 
            sql = LISTAR_US;
        }else{
            sql = "SELECT * FROM usuario WHERE (codigo_us like'" + busca + "%' or nome_us like'" + busca + "%')" // o like é para relevar strings com letras maiusculas ou minusculas
                    + "order by nome_us";
        } 
        String dado[] = new String [5];
        try{ // verificar se irá passar da forma correta os dados
            Statement st = (Statement) cn.createStatement(); // executa uma consulta ao banco de dados
            ResultSet rs = (ResultSet) st.executeQuery(sql); // guarda o resultado executa a consulta
            while (rs.next()){ // next permite que o ponteiro seja direcionado para a próxima linha 
                dado[0] = rs.getString("codigo_us"); // pegue o resultado da consulta o código e associe ao primeiro campo da tabela
                dado[1] = rs.getString("nome_us");
                dado[2] = rs.getString("sexo_us");
                dado[3] = rs.getString("tipo_us");
                dado[4] = rs.getString("senha");
                modelo.addRow(dado); // adicione os dados a tabela
            }  
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Listagem de Usuários",0);
      }  
    } 
    
      // REGISTRO DE USUÁRIOS
    
    public static int registrarUsuario (Usuarios_model uc){ // objetos da classe usuário_model (nome, sexo, etc)
        int rsu = 0; // variável para guardar o resultado da consulta
        String sql = REGISTRAR; // String para receber toda a consulta sql REGISTRAR
        try{ // verificar se irá passar da forma correta os dados
            
            ps = (PreparedStatement) cn.prepareStatement(sql); // começa a conexão e faz as inserções no banco preparando os parametros para serem inseridos
            ps.setString(1, uc.getPrimaryKey()); // adiciona no primeiro campo a chave primária
            ps.setString(2, uc.getNome());
            ps.setString(3, uc.getSexo());
            ps.setString(4, uc.getTipoUser());
            ps.setString(5, uc.getSenha());
            rsu = ps.executeUpdate(); // para atualizar as informações no BD
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Usuário já registrado","Cadastro de Usuários",0);  
        }
        System.out.println(sql);
        return rsu;
    }
    
    // GERAR ID DE FORMA DINÂMICA
    
    public static void gerarId(){
        
        int j;
        String c = "";
        String SQL = "SELECT MAX(codigo_us) FROM usuario";
    
        try{
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(SQL);
            while (rs.next()){
                c = rs.getString(1);
            }
            
            if (c == null){
                FrmUsuarios.codigo.setText("USU0001");
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
                FrmUsuarios.codigo.setText("USU" + gen.serie());
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro de Usuários",0);
        } 
    
    
    // ATUALIZAR USUÁRIO
    
    }
    public static int atualizarUsuario (Usuarios_model uc){ // objetos da classe usuário_model (nome, sexo, etc)
        int rsu = 0; // variável para guardar o resultado da consulta
        String sql = ATUALIZAR; // String para receber toda a consulta sql REGISTRAR
        try{ // verificar se irá passar da forma correta os dados 
            ps = (PreparedStatement) cn.prepareStatement(sql); // começa a conexão e faz as inserções no banco preparando os parametros para serem inseridos
            ps.setString(1, uc.getNome()); // adiciona no primeiro campo o nome
            ps.setString(2, uc.getSexo()); // adiciona no segundo campo o sexo..
            ps.setString(3, uc.getTipoUser());
            ps.setString(4, uc.getSenha());
            ps.setString(5, uc.getPrimaryKey()); 
            rsu = ps.executeUpdate(); // para atualizar as informações no BD
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Atualização de Usuários",0);
      }
        System.out.println(sql);
        return rsu;
    }
    
    // EXCLUIR USUÁRIO
    
    public static int eliminarUsuario(String id){
        int rsu = 0; // variável para guardar o resultado da consulta
        String sql = ELIMINAR; // String para receber toda a consulta sql ELIMINAR
        try{
            ps = (PreparedStatement) cn.prepareStatement(sql); // começa a conexão e faz as inserções no banco preparando os parametros para serem inseridos
            ps.setString(1, id); // pega o ID do usuário
            rsu = ps.executeUpdate(); // para atualizar as informações no BD
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Exclusão de Usuários",0);
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
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Exclusão de todos os Usuários",0);
    }
        System.out.println(sql);
        return rsu;
    }
}


