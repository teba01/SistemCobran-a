/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.telas;

import br.ba.beans.Pagamento;
import br.ba.dao.PagamentoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author mathe
 */
public class TelaFaturamento extends javax.swing.JFrame {

    /**
     * Creates new form TelaFaturamento
     */
    public TelaFaturamento() {
        initComponents();
          DefaultTableModel modelo = (DefaultTableModel) tableFaturamento.getModel();
        tableFaturamento.setRowSorter(new TableRowSorter(modelo));
        readTable();
    }

    public void readTable() { 
        DefaultTableModel modelo = (DefaultTableModel) tableFaturamento.getModel();
        modelo.setNumRows(0);
        PagamentoDAO pdao = new PagamentoDAO();
        
        for (Pagamento p : pdao.read()) {
            modelo.addRow(new Object[]{
             
                p.getDivida(),
                p.getDataPagamento(),
                p.getValorPago(),
            });
        }
    }
       public void readTableConsulta(Date data_inicio, Date data_final) {
        
        DefaultTableModel modelo = (DefaultTableModel) tableFaturamento.getModel();
        modelo.setNumRows(0);
        PagamentoDAO pdao = new PagamentoDAO();

        for (Pagamento p : pdao.readForData(data_inicio, data_final)) {
            modelo.addRow(new Object[]{
                p.getDivida(),
                p.getDataPagamento(),
                p.getValorPago(),
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableFaturamento = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPesq = new javax.swing.JButton();
        txtFatDataDe = new javax.swing.JTextField();
        txtFatDataAte = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFaturamento1 = new javax.swing.JTable();

        tableFaturamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Divida", "Data do Pagamento", "Valor Pago"
            }
        ));
        jScrollPane1.setViewportView(tableFaturamento);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Período:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("De ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Até");

        btnPesq.setText("Pesquisar");
        btnPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqActionPerformed(evt);
            }
        });

        tableFaturamento1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Divida", "Data do Pagamento", "Valor Pago"
            }
        ));
        jScrollPane2.setViewportView(tableFaturamento1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFatDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFatDataAte)
                .addGap(18, 18, 18)
                .addComponent(btnPesq)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(btnPesq)
                    .addComponent(txtFatDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFatDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqActionPerformed
      try {
            // TODO add your handling code here:
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date invoiceDate = formatDate.parse(txtFatDataDe.getText());
            java.sql.Date sqlDate = new java.sql.Date(invoiceDate.getTime());
            
            SimpleDateFormat formatDate2 = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date invoiceDate2 = formatDate2.parse(txtFatDataAte.getText());
            java.sql.Date sqlDate2 = new java.sql.Date(invoiceDate2.getTime());
            
            Pagamento p = new Pagamento();
            PagamentoDAO pdao = new PagamentoDAO();
                      
            
            pdao.readForData(sqlDate, sqlDate2);
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(TelaFaturamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesqActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFaturamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFaturamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFaturamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFaturamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFaturamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesq;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableFaturamento;
    private javax.swing.JTable tableFaturamento1;
    private javax.swing.JTextField txtFatDataAte;
    private javax.swing.JTextField txtFatDataDe;
    // End of variables declaration//GEN-END:variables
}
