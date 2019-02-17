/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.telas;

import br.ba.beans.Cliente;
import br.ba.beans.Divida;
import br.ba.dao.ClienteDAO;
import br.ba.dao.DividaDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author mathe
 */
public class TelaDivida extends javax.swing.JFrame {

    

    /**
     * Creates new form TelaDivida
     */
    public TelaDivida() {
        initComponents();
         Divida d = new Divida();
        DefaultTableModel modelo = (DefaultTableModel) tableDivida.getModel();
        tableDivida.setRowSorter(new TableRowSorter(modelo));
        preencherJComboBox();
    }
     public void readTable() { 
        DefaultTableModel modelo = (DefaultTableModel) tableDivida.getModel();
        modelo.setNumRows(0);
        DividaDAO ddao = new DividaDAO();
        
        ddao.read().forEach((Divida d) -> {
            modelo.addRow(new Object[]{
                d.getCodigo(),
                d.getCredor(),
                d.getDevedor(),
                d.getValorDivida(),
                d.getDataAtualizacao(),
                d.isPago()
            });
        });
     }
      public void readJTableDividasNaoPagas() {
        
        DefaultTableModel modelo = (DefaultTableModel) tableDivida.getModel();
        modelo.setNumRows(0);
        DividaDAO ddao = new DividaDAO();

        for (Divida d : ddao.readDividasNaoPagas()) {
            modelo.addRow(new Object[]{
                d.getCodigo(),
                d.getCredor(),
                d.getDevedor(),
                d.getValorDivida(),
                d.getDataAtualizacao(),
                d.isPago()
            });
        }
    }
    
    public void preencherJComboBox(){
	ClienteDAO cdao = new ClienteDAO();
	for (Cliente cliente : cdao.read()){
		cmbCredor.addItem(cliente);
		cmbDevedor.addItem(cliente);
	}
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        Sair = new javax.swing.JButton();
        txtDivValor = new javax.swing.JTextField();
        txtDivData = new javax.swing.JTextField();
        cmbCredor = new javax.swing.JComboBox<>();
        cmbDevedor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDivida = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Credor:*");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("*Campos obrigatórios");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Devedor:*");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Valor:*");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Data*");

        btnAdicionar.setText("Incluir");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        cmbCredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCredorActionPerformed(evt);
            }
        });

        tableDivida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Credor", "Devedor", "Valor", "Data"
            }
        ));
        tableDivida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDividaMouseClicked(evt);
            }
        });
        tableDivida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableDividaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableDivida);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Listar dívidas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Exibir dívidas em aberto");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCredor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDevedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Sair))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(55, 55, 55))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDivValor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDivData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionar)
                                .addGap(88, 88, 88)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(54, 54, 54)))))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbDevedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDivValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDivData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sair)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
          try {
           
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date invoiceDate = formatDate.parse(txtDivData.getText());
            java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
            
            Divida d = new Divida();
            DividaDAO dao = new DividaDAO();
            d.setCodigo(d.getCodigo());
            d.setCredor((Cliente) cmbCredor.getSelectedItem());
            d.setDevedor((Cliente) cmbDevedor.getSelectedItem());
            d.setValorDivida(Double.parseDouble(txtDivValor.getText()));
            d.setDataAtualizacao(sqlDate);
            d.setPago(false);
            dao.create(d);
            
          
         //   txtIdDiv.setText("");
            txtDivValor.setText("");
            txtDivData.setText("");
            
                    
            readTable();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Verifique se o formato da data está correto.", "ERRO AO ADICIONAR", ERROR);
        }
        
                              
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void cmbCredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCredorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCredorActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        readTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tableDividaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableDividaKeyReleased
        if (tableDivida.getSelectedRow() != -1) { 
            cmbCredor.setSelectedItem(tableDivida.getValueAt(tableDivida.getSelectedRow(), 1).toString());
            cmbDevedor.setSelectedItem(tableDivida.getValueAt(tableDivida.getSelectedRow(), 2).toString());
            txtDivData.setText(tableDivida.getValueAt(tableDivida.getSelectedRow(), 4).toString());
            txtDivValor.setText(tableDivida.getValueAt(tableDivida.getSelectedRow(), 3).toString());
            
        }
    }//GEN-LAST:event_tableDividaKeyReleased

    private void tableDividaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDividaMouseClicked
          if (tableDivida.getSelectedRow() != -1) { 
            cmbCredor.setSelectedItem(tableDivida.getValueAt(tableDivida.getSelectedRow(), 1).toString());
            cmbDevedor.setSelectedItem(tableDivida.getValueAt(tableDivida.getSelectedRow(), 2).toString());
            txtDivData.setText(tableDivida.getValueAt(tableDivida.getSelectedRow(), 4).toString());
            txtDivValor.setText(tableDivida.getValueAt(tableDivida.getSelectedRow(), 3).toString());
            
        }
        
        
    }//GEN-LAST:event_tableDividaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          try {
            // TODO add your handling code here:
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date invoiceDate = formatDate.parse(txtDivData.getText());
            java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
            
            if (tableDivida.getSelectedRow() != -1 ) {
                
                Divida d = new Divida();
                DividaDAO dao = new DividaDAO();
                d.setCodigo((int) tableDivida.getValueAt(tableDivida.getSelectedRow(), 0));
                d.setCredor((Cliente) cmbCredor.getSelectedItem());
                d.setDevedor((Cliente) cmbDevedor.getSelectedItem());
                d.setValorDivida(Integer.parseInt(txtDivValor.getText()));
                d.setDataAtualizacao(sqlDate);
                
                dao.update(d);
                
                //txtIdDiv.setText("");
                txtDivValor.setText("");
                txtDivData.setText("");
                
                readTable();
                
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data Inválida");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if (tableDivida.getSelectedRow() != -1) {
        Divida d = new Divida();
        DividaDAO dao = new DividaDAO();
        d.setCodigo((int) tableDivida.getValueAt(tableDivida.getSelectedRow(), 0));
        
        dao.delete(d);
        
       // txtIdDiv.setText("");
        txtDivValor.setText("");
        txtDivData.setText("");
        
        readTable();
        
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDivida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDivida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDivida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDivida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDivida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sair;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JComboBox<Object> cmbCredor;
    private javax.swing.JComboBox<Object> cmbDevedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDivida;
    private javax.swing.JTextField txtDivData;
    private javax.swing.JTextField txtDivValor;
    // End of variables declaration//GEN-END:variables
}

