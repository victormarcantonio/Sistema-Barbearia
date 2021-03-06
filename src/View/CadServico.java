/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AgendaController;
import Controller.ServicoController;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import util.ConectaBanco;

/**
 *
 * @author tiago
 */
public class CadServico extends javax.swing.JFrame {

    private final ServicoController controller;

    /**
     * Creates new form Agenda
     */
    public CadServico() {
        initComponents();
        controller = new ServicoController(this);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelId1 = new javax.swing.JLabel();
        TextValor = new javax.swing.JTextField();
        TextServico = new javax.swing.JTextField();
        LabelAgenda = new javax.swing.JLabel();
        LabelId = new javax.swing.JLabel();
        ButtonAgendar = new javax.swing.JButton();
        LabelAgendaPainelFundo = new javax.swing.JLabel();
        LabelAgendaFundo = new javax.swing.JLabel();
        TextValor1 = new javax.swing.JTextField();
        TextServico1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelId1.setForeground(new java.awt.Color(255, 255, 255));
        LabelId1.setText("Valor");
        getContentPane().add(LabelId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        TextValor.setToolTipText("");
        TextValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextValorActionPerformed(evt);
            }
        });
        getContentPane().add(TextValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 280, 40));

        TextServico.setToolTipText("");
        TextServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextServicoActionPerformed(evt);
            }
        });
        getContentPane().add(TextServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 280, 40));

        LabelAgenda.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        LabelAgenda.setForeground(new java.awt.Color(255, 255, 255));
        LabelAgenda.setText("Cadastro Serviço");
        getContentPane().add(LabelAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 310, 60));

        LabelId.setForeground(new java.awt.Color(255, 255, 255));
        LabelId.setText("Serviço");
        getContentPane().add(LabelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        ButtonAgendar.setBackground(new java.awt.Color(60, 233, 106));
        ButtonAgendar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        ButtonAgendar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAgendar.setText("Cadastrar");
        ButtonAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAgendarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 160, 30));

        LabelAgendaPainelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/Agenda-PainelFundo.png"))); // NOI18N
        getContentPane().add(LabelAgendaPainelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-670, 10, 1420, 1000));

        LabelAgendaFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/AgendaFundo.png"))); // NOI18N
        getContentPane().add(LabelAgendaFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 1420, 1000));

        TextValor1.setText("0");
        TextValor1.setToolTipText("");
        TextValor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextValor1ActionPerformed(evt);
            }
        });
        getContentPane().add(TextValor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 280, 40));

        TextServico1.setToolTipText("");
        TextServico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextServico1ActionPerformed(evt);
            }
        });
        getContentPane().add(TextServico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 280, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAgendarActionPerformed
       
      controller.salvaServico();
        
    }//GEN-LAST:event_ButtonAgendarActionPerformed

    private void TextValor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextValor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextValor1ActionPerformed

    private void TextServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextServicoActionPerformed

    private void TextServico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextServico1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextServico1ActionPerformed

    private void TextValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextValorActionPerformed

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
            java.util.logging.Logger.getLogger(CadServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAgendar;
    private javax.swing.JLabel LabelAgenda;
    private javax.swing.JLabel LabelAgendaFundo;
    private javax.swing.JLabel LabelAgendaPainelFundo;
    private javax.swing.JLabel LabelId;
    private javax.swing.JLabel LabelId1;
    private javax.swing.JTextField TextServico;
    private javax.swing.JTextField TextServico1;
    private javax.swing.JTextField TextValor;
    private javax.swing.JTextField TextValor1;
    // End of variables declaration//GEN-END:variables

    public JTextField getTextServico() {
        return TextServico;
    }

    public void setTextServico(JTextField TextServico) {
        this.TextServico = TextServico;
    }

    public JTextField getTextValor() {
        return TextValor;
    }

    public void setTextValor(JTextField TextValor) {
        this.TextValor = TextValor;
    }


   

   

   
    
    
    
}
