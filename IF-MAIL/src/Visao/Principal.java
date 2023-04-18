/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visao;

import Controle.ControleListEmails;
import Controle.ControleServidor;
import Modelo.Email;
import Modelo.Servidor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import java.lang.String;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Herbert
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    private Servidor servidor;
    public Principal() {
        configurarListaEmails();
        initComponents();
        this.setLocationRelativeTo(null); // Centraliza a tela
    }
    
    public Principal(Servidor servidor){
        this.servidor = servidor;
        initComponents();
        configurarListaEmails();
        this.setLocationRelativeTo(null); // Centraliza a tela
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEmailsRecebido = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        botaoEnviarEmail = new javax.swing.JMenu();
        botaoSair = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaEmailsRecebido.setModel(new ControleListEmails(this.configurarListaEmails()));
        listaEmailsRecebido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaEmailsRecebidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaEmailsRecebido);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Caixa de entrada");

        jMenu1.setText("Filtrar");

        jMenuItem1.setText("Por tamanho");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Destinatarios");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Ferramentas");

        jMenuItem4.setText("Buscar todos destinatarios");
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Enviados");
        jMenuBar1.add(jMenu2);

        botaoEnviarEmail.setText("Enviar Email");
        botaoEnviarEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoEnviarEmailMouseClicked(evt);
            }
        });
        jMenuBar1.add(botaoEnviarEmail);

        botaoSair.setText("Sair");
        botaoSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoSairMouseClicked(evt);
            }
        });
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(botaoSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSairMouseClicked
        // TODO add your handling code here:
        ControleServidor.deslogarConta(servidor);
        JFrame telaLogin = new Login(servidor);
        telaLogin.show();
        this.dispose();// fechar a janela atual
    }//GEN-LAST:event_botaoSairMouseClicked

    private void listaEmailsRecebidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaEmailsRecebidoMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "teste");
    }//GEN-LAST:event_listaEmailsRecebidoMouseClicked

    private void botaoEnviarEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEnviarEmailMouseClicked
        // TODO add your handling code here:
        JFrame telaEnviarEmail = new EnviarEmail(this.servidor);
        telaEnviarEmail.show();
        this.dispose();// fechar a janela atual
    }//GEN-LAST:event_botaoEnviarEmailMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                
            }
        });
    }
    
    private List<String> configurarListaEmails()
    {
        List<String> listaAssuntos = new ArrayList<>();
        //modificar para aparecer o assunto na tela, no caso descomentar a linha abaixo
        for(Email email: this.servidor.getContaLogada().getCaixaEntrada().getEmails())//
        {
            listaAssuntos.add(email.getAssunto());//email.getAssunto());
        }
        return listaAssuntos;
//        listaEmailsRecebido = new JList<>(listaAssuntos.toArray(new String[0]));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu botaoEnviarEmail;
    private javax.swing.JMenu botaoSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaEmailsRecebido;
    // End of variables declaration//GEN-END:variables
}
