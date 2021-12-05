/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.FuncionarioControl;
import Control.MedicoControl;
import Control.PacienteControl;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author Gabriel
 */
public class Listar extends javax.swing.JFrame {

    /**
     * Creates new form Listar
     */
    
    private String tipo;
    private String[]  dados; 
    private MedicoControl controladorMedico; 
    private PacienteControl controladorPaciente; 
    private FuncionarioControl controladorFuncionario; 
    
    public Listar()
    {
        
    }

    
    public Listar(String tipo, String dados [])
    {
        initComponents();
        this.tipo = tipo;
        this.dados = dados;
        carregarLista();
        controladorMedico = new MedicoControl();
        controladorPaciente = new PacienteControl();
        controladorFuncionario = new FuncionarioControl();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        Apagar = new javax.swing.JButton();
        editar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabela.setShowGrid(true);
        jScrollPane1.setViewportView(Tabela);

        Apagar.setText("Apagar");
        Apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagarActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editar)
                .addGap(209, 209, 209)
                .addComponent(Apagar)
                .addGap(264, 264, 264))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Apagar)
                    .addComponent(editar))
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed


        // Nome,CRM, Telefone, Especialidade, Periodo de Atendimento

        
        
            try
            {
                            if(this.tipo == "Médico")
                            {
                            String nome = "";
                            String CRM = "";
                            String Telefone = "";
                            String Especialidade = "";
                            String PeriododeAtendimento = "";


                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 1).toString().length() < 2) {
                                            throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
                                    } else {
                                        nome = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 1).toString();
                                    }
                                    
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 2).toString().length() < 2) {
                                            throw new Mensagens("CRM deve conter ao menos 2 caracteres.");
                                    } else {
                                        CRM = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 2).toString();
                                    }
                                    
                                    
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 3).toString().length() < 2) {
                                            throw new Mensagens("Telefone deve conter ao menos 6 caracteres.");
                                    } else {
                                        Telefone = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 3).toString();
                                    }
                            
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 4).toString().length() < 2) {
                                            throw new Mensagens("Especialidade deve conter ao menos 2 caracteres.");
                                    } else {
                                       Especialidade = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 4).toString();
                                    }
                                    
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 5).toString() != "Manhã" && 
                                            this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 5).toString() != "Tarde") {
                                            throw new Mensagens("Período de Atendimento deve ser Manhã ou Tarde");
                                    } else {
                                       PeriododeAtendimento = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 5).toString();
                                    }
                                    
                            
                            
                                    if(this.controladorMedico.Editar(Integer.parseInt(this.dados[0]), nome, Integer.parseInt(CRM), Especialidade, Integer.parseInt(Telefone) ,PeriododeAtendimento)) {

                                         JOptionPane.showMessageDialog(rootPane, "Medico Alterado com Sucesso!");

                                    }   



                        }
                
                      this.controladorMedico.getMinhaLista().toString();
            } catch (Mensagens erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            } catch (NumberFormatException erro2) {
                JOptionPane.showMessageDialog(null, "Informe um n�mero.");
            } finally {
                carregarLista();
            }  
            
       //Nome, endereço, telefone, data de nascimento
            
                    try
                    {
                            if(this.tipo == "Paciente")
                            {
                            String nome = "";
                            String endereço= "";
                            String Telefone = "";
                            String datadeNascimento = "";
                            

                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 1).toString().length() < 2) {
                                            throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
                                    } else {
                                        nome = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 1).toString();
                                    }
                                    
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 2).toString().length() < 2) {
                                            throw new Mensagens("Endereço deve conter ao menos 2 caracteres.");
                                    } else {
                                        endereço = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 2).toString();
                                    }
                                    
                                    
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 3).toString().length() < 2) {
                                            throw new Mensagens("Telefone deve conter ao menos 6 caracteres.");
                                    } else {
                                        Telefone = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 3).toString();
                                    }
                            
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 4).toString().length() != 8) {
                                            throw new Mensagens("Data de Nascimento deve conter 8 caracteres.");
                                    } else {
                                       datadeNascimento = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 4).toString();
                                    }
                                    
                                    
                            
                            
                                    if(this.controladorPaciente.Editar(nome, endereço, Integer.parseInt(Telefone), Integer.parseInt(datadeNascimento) )) {

                                         JOptionPane.showMessageDialog(rootPane, "Paciente Alterado com Sucesso!");

                                    }   



                        }

                                    this.controladorPaciente.getMinhaLista().toString();
                          } catch (Mensagens erro) {
                              JOptionPane.showMessageDialog(null, erro.getMessage());
                          } catch (NumberFormatException erro2) {
                              JOptionPane.showMessageDialog(null, "Informe um número.");
                          } finally {
                              carregarLista();
                          }


                  //Nome, CPF, telefone, Rua, Numero, Cep
         
                    
                  try
                    {
                            if(this.tipo == "Funcionário")
                            {
                            String nome = "";
                            String CPF= "";
                            String Telefone = "";
                            String Rua = "";
                            String Numero = "";
                            String CEP = "";
                            

                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 1).toString().length() < 2) {
                                            throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
                                    } else {
                                        nome = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 1).toString();
                                    }
                                    
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 2).toString().length() < 2) {
                                            throw new Mensagens("CPF deve conter ao menos 2 caracteres.");
                                    } else {
                                        CPF = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 2).toString();
                                    }
                                    
                                    
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 3).toString().length() < 2) {
                                            throw new Mensagens("Telefone deve conter ao menos 6 caracteres.");
                                    } else {
                                        Telefone = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 3).toString();
                                    }
                            
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 4).toString().length() < 2) {
                                            throw new Mensagens("Rua deve conter ao menos 2 caracteres.");
                                    } else {
                                       Rua = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 4).toString();
                                    }
                                    
                                    
                                    
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 5).toString().length() < 2) {
                                            throw new Mensagens("Número deve conter ao menos 2 caracteres.");
                                    } else {
                                       Numero = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 5).toString();
                                    }
                                    
                                    
                                    
                                    if (this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 6).toString().length() < 2) {
                                            throw new Mensagens("CEP deve conter ao menos 2 caracteres.");
                                    } else {
                                       CEP = this.Tabela.getValueAt(this.Tabela.getSelectedRow(), 6).toString();
                                    }
                                    
                                    
                                    //Nome, CPF, telefone, Rua, Numero, Cep
                            
                                    if(this.controladorFuncionario.Editar(nome, Integer.parseInt(CPF), Integer.parseInt(Telefone), Rua, Integer.parseInt(Numero), 
                                            Integer.parseInt(CEP))) {

                                         JOptionPane.showMessageDialog(rootPane, "Funcionário Alterado com Sucesso!");

                                    }   



                        }

                                    this.controladorFuncionario.getMinhaLista().toString();
                          } catch (Mensagens erro) {
                              JOptionPane.showMessageDialog(null, erro.getMessage());
                          } catch (NumberFormatException erro2) {
                              JOptionPane.showMessageDialog(null, "Informe um número.");
                          } finally {
                              carregarLista();
                        }
                    
                    
                    
                    

    }//GEN-LAST:event_editarActionPerformed

    private void ApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApagarActionPerformed



        if(tipo == "Médico")
        {
            this.controladorMedico.apagar(dados[0]);
        }

       
        if(tipo == "Paciente")
        {
            this.controladorPaciente.apagar(dados[0]);
        } 
        
        
        if(tipo == "Funcionário")
        {
            this.controladorFuncionario.apagar(dados[0]);
        }





    }//GEN-LAST:event_ApagarActionPerformed

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
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Apagar;
    private javax.swing.JTable Tabela;
    private javax.swing.JButton editar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
    private void carregarLista() {
        

        DefaultTableModel modelo = (DefaultTableModel) this.Tabela.getModel();
        modelo.setNumRows(0);
        
    // Nome,CRM, Telefone, Especialidade, Periodo de Atendimento

       if(this.tipo == "Médico")
       {
           modelo.setColumnCount(5);
           
           this.Tabela.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Nome");
           this.Tabela.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("CRM");
           this.Tabela.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Especialidade");
           this.Tabela.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Telefone");
           this.Tabela.getTableHeader().getColumnModel().getColumn(4).setHeaderValue("Período de Atendimento");
       }
       
       //Nome, endereço, telefone, data de nascimento
       
       if(this.tipo == "Paciente")
       {
           modelo.setColumnCount(4);
       
           this.Tabela.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Nome");
           this.Tabela.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Endereço");
           this.Tabela.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Telefone");
           this.Tabela.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Data de Nascimento");
           
       }
       
       
       
       //Nome, CPF, telefone, Rua, Numero, Cep
       
       if(this.tipo == "Funcionário")
       {
           modelo.setColumnCount(6);
       
           this.Tabela.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Nome");
           this.Tabela.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("CPF");
           this.Tabela.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Telefone");
           this.Tabela.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Rua");
           this.Tabela.getTableHeader().getColumnModel().getColumn(4).setHeaderValue("Número");
           this.Tabela.getTableHeader().getColumnModel().getColumn(5).setHeaderValue("CEP");
       }
       
       
       String [] dados2 = new String [dados.length -1];
       
       
        for (int i = 1; i < dados.length; i++) {
                
            dados2[i-1] = dados[i];
        }

        
                
         modelo.addRow(dados2);
         
      
       
       
       
    }
}
