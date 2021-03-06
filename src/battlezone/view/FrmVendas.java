/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlezone.view;

import battlezone.controller.Venda_CRUD;
import static battlezone.view.FrmCaixa.tabela;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aline Buchino
 */
public class FrmVendas extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmVendas
     */
    public FrmVendas() {
        initComponents();
        setFrameIcon(new ImageIcon(this.getClass().getResource("/imagens/principal/LogoSemBorda.png")));
        
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Irá listar a tabela assim que iniciar a janela 
        limparCampos();
    }
    
    void limparCampos(){
        if(tabela.getSelectedRow() > -1){ // irá receber as informações da tabela e limpará os campos abaixo
           tabela.removeRowSelectionInterval(tabela.getSelectedRow(), tabela.getSelectedRow());
        }
       // data.setDate(null);
        buscar.setText("");
        Venda_CRUD.listarVenda("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        excluir = new javax.swing.JButton();
        limparCAMPOS = new javax.swing.JButton();
        buscar = new app.bolivia.swing.JCTextField();
        jLabelBuscar = new javax.swing.JLabel();
        buscar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        data = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tabelaProdutos = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setClosable(true);
        setTitle("LISTA DE VENDAS");
        setPreferredSize(new java.awt.Dimension(900, 500));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        excluir.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagar1.png"))); // NOI18N
        excluir.setBorder(null);
        excluir.setContentAreaFilled(false);
        excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluir.setLabel("EXCLUIR");
        excluir.setPreferredSize(new java.awt.Dimension(73, 95));
        excluir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagar.png"))); // NOI18N
        excluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        jPanel3.add(excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        limparCAMPOS.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        limparCAMPOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/limpar1.png"))); // NOI18N
        limparCAMPOS.setText("LIMPAR CAMPOS");
        limparCAMPOS.setBorder(null);
        limparCAMPOS.setContentAreaFilled(false);
        limparCAMPOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limparCAMPOS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        limparCAMPOS.setPreferredSize(new java.awt.Dimension(73, 95));
        limparCAMPOS.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/limpar.png"))); // NOI18N
        limparCAMPOS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        limparCAMPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCAMPOSActionPerformed(evt);
            }
        });
        jPanel3.add(limparCAMPOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 94, -1));

        buscar.setBackground(new java.awt.Color(15, 164, 57));
        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        buscar.setOpaque(false);
        buscar.setPhColor(new java.awt.Color(255, 255, 255));
        buscar.setPlaceholder("NÚMERO VENDA / DATA");
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });
        jPanel3.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 180, 30));

        jLabelBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/buscarL.png"))); // NOI18N
        jPanel3.add(jLabelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        buscar1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/buscaF2.png"))); // NOI18N
        buscar1.setText("BUSCAR");
        buscar1.setBorder(null);
        buscar1.setContentAreaFilled(false);
        buscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscar1.setPreferredSize(new java.awt.Dimension(73, 95));
        buscar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/buscaF1.png"))); // NOI18N
        buscar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar1ActionPerformed(evt);
            }
        });
        jPanel3.add(buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 62, 74));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("DATA");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 199, 34));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/vendasHoje.jpeg"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(140, 42));
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/vendasH1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 130, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 440));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TABELA DE VENDAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 440));

        tabela.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N° VENDA ", "TOTAL", "DATA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.setViewportView(tabela);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabelaProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabelaProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 490, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        Venda_CRUD.listarVenda(buscar.getText());  
    }//GEN-LAST:event_buscarKeyReleased

    private void limparCAMPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCAMPOSActionPerformed
        limparCampos();
    }//GEN-LAST:event_limparCAMPOSActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
       if(tabela.getRowCount()>0){ // faz a verificação para ver SE EXISTE algum registro na tabela usuário
            if(tabela.getSelectedRowCount()>0){ // se tiver algum registro que esteja SELECIONADO
                if(JOptionPane.showConfirmDialog(this, "Deseja excluir esta venda?", "Venda", JOptionPane.YES_NO_OPTION,0, 
                     new ImageIcon (getClass().getResource("/imagens/principal/info.png"))) == JOptionPane.YES_OPTION) {
                    
                        int linha = tabela.getSelectedRow(); // captura a linha seleciona
                        String id = tabela.getValueAt(linha, 0).toString(); // extrai o id do campo selecionado e o 0 corresponde a primeira coluna
                        int elimina = Venda_CRUD.eliminarVenda(id); // verifica as opções dentro da classe CRUD para saber se obteve resultado ou não e executa a função eliminarVenda
                        if(elimina !=0){ // se sim é porque excluiu
                            limparCampos();
                            JOptionPane.showMessageDialog(this, "Venda excluida", "Venda", 0,
                            new ImageIcon (getClass().getResource("/imagens/principal/info.png")));
                        }
                }
            }else{
               JOptionPane.showMessageDialog(this, "Selecione um registro", "Venda", 0,
               new ImageIcon (getClass().getResource("/imagens/principal/info.png"))); 
            }   
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar1ActionPerformed
        if(data.getDate() == null){
            Venda_CRUD.listarVenda("");
        }else{

            String formato = data.getDateFormatString(); // irá receber o formato da data
            Date date = data.getDate(); // captura a data que foi passada
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // irá estruturar de acordo com o formato
            Venda_CRUD.listarVenda(String.valueOf(sdf.format(date))); // irá passar a data no formato que ele pegou
        }
    }//GEN-LAST:event_buscar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date sistemaData = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecH = formato.format(sistemaData);
        Venda_CRUD.listarVenda(fecH);
        data.setDate(null);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscar;
    private javax.swing.JButton buscar1;
    private com.toedter.calendar.JDateChooser data;
    private javax.swing.JButton excluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton limparCAMPOS;
    public static javax.swing.JTable tabela;
    private javax.swing.JScrollPane tabelaProdutos;
    // End of variables declaration//GEN-END:variables
}
