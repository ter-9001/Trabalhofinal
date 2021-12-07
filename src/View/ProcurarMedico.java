/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.MedicoControl;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class ProcurarMedico extends javax.swing.JFrame {

    /**
     * Creates new form ProcurarMedico
     */
    
    private MedicoControl controlador;
    
    
    public ProcurarMedico() {
        initComponents();
        this.controlador = new MedicoControl();
        CarregarDados();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        CRM = new javax.swing.JComboBox<>();
        nome = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Procurar = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Procurar Médico");

        CRM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione" }));
        CRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CRMActionPerformed(evt);
            }
        });

        nome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione" }));
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        jLabel1.setText("Digite o CRM");

        jLabel2.setText("Digite o nome");

        jLabel4.setText("ou");

        Procurar.setText("Procurar");
        Procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CRM, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(Procurar)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(Procurar)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void CarregarDados()
    {
        String linhasMatriz[][] = controlador.getMinhaMatrizTexto();
        for (int i = 0; i < linhasMatriz.length; i++) {
            
            CRM.addItem(linhasMatriz [i] [2]);
            nome.addItem(linhasMatriz [i] [1]);
        
        }
    }
    
    
    
    private void CRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CRMActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void ProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcurarActionPerformed

        
        if(CRM.getSelectedItem().toString() != "selecione" && nome.getSelectedItem().toString() != "selecione")
        {
            JOptionPane.showMessageDialog(null, "Selecione CRM ou Nome \n (Não é possível chamar os dois)");
            return;
        }
        
        
        if(CRM.getSelectedItem().toString() == "selecione" && nome.getSelectedItem().toString() == "selecione")
        {
            JOptionPane.showMessageDialog(null, "Selecione CRM ou Nome");
            return;
        }
        
        if(CRM.getSelectedItem().toString() != "selecione")
        {
             String linhasMatriz[][] = controlador.getMinhaMatrizTexto();
            for (int i = 0; i < linhasMatriz.length; i++) {
            
                if(linhasMatriz [i] [2] == CRM.getSelectedItem().toString())
                {
                    Listar listar = new Listar("Médico", linhasMatriz [i] );
                    listar.setVisible(true);
                }
            
            }
            
        
          return;
        }
        
        
        
        if(nome.getSelectedItem().toString() != "selecione")
        {
            String linhasMatriz[][] = controlador.getMinhaMatrizTexto();
            for (int i = 0; i < linhasMatriz.length; i++) {
            
                
                if(linhasMatriz [i] [1] == nome.getSelectedItem().toString())
                {
                    Listar listar = new Listar("Médico", linhasMatriz [i] );
                    listar.setVisible(true);
        
                }
            
            
            }
        
        
           return;
        }
        
        
        
        
        
    }//GEN-LAST:event_ProcurarActionPerformed

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
            java.util.logging.Logger.getLogger(ProcurarMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProcurarMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProcurarMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProcurarMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcurarMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CRM;
    private javax.swing.JButton Procurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> nome;
    // End of variables declaration//GEN-END:variables
}
