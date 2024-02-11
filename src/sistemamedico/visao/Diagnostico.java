/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamedico.visao;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sistemamedico.dao.PerguntaDAO;
import sistemamedico.modelo.Constantes;
import sistemamedico.modelo.Facto;
import sistemamedico.modelo.Pergunta;

/**
 *
 * @author Nano
 */
public class Diagnostico extends javax.swing.JFrame {

    /**
     * Creates new form Diagnostico
     */

    private List<Pergunta> perguntas = PerguntaDAO.getPerguntas();
    private int numPerguntaFoco = 0;
    private boolean opcao;

    public Diagnostico() {
        super("SisMedi - Diagonóstico");
        this.setContentPane(new JLabel(new ImageIcon(getClass().getResource("/imagens2/1.jpg"))));
        initComponents();
        setLocationRelativeTo(null); // Abre a janela no centro da tela
        setResizable(false); // Desactivando a opção de redimensionar
        setVisible(true); // Define a visibilidade da janela
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Desactivar o fecho ao clicar em x
        URL caminhoImagem = this.getClass().getClassLoader().getResource("imagens/estetoscopio.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);
        
        apresentar();
        btnResultado.setVisible(false);
        Constantes.inicialiarListas();
        setOpcao(true);
        botoes(opcao);
    }

    private void apresentar() {
        if (perguntas != null) {
            if (numPerguntaFoco < perguntas.size()) {
                lblPergunta.setText(perguntas.get(numPerguntaFoco).getDescricaoPergunta());
                btnSim.setText(perguntas.get(numPerguntaFoco).getRespostas().getResposta1());
                btnTalvezSim.setText(perguntas.get(numPerguntaFoco).getRespostas().getResposta2());
                btnNaoSei.setText(perguntas.get(numPerguntaFoco).getRespostas().getResposta3());
                btnTalvezNao.setText(perguntas.get(numPerguntaFoco).getRespostas().getResposta4());
                btnNao.setText(perguntas.get(numPerguntaFoco).getRespostas().getResposta5());
            }
        }
    }
    
        private void botoes(boolean opcao)
    {
        lblPergunta.setVisible(opcao);
        btnSim.setVisible(opcao);
        btnTalvezSim.setVisible(opcao);
        btnNaoSei.setVisible(opcao);
        btnTalvezNao.setVisible(opcao);
        btnNao.setVisible(opcao);
    }

    private void setOpcao(boolean opcao)
    {
        this.opcao = opcao;
    }

    public void processarResposta(double CF)
    {
        Facto sintoma = new Facto();
        sintoma.setAtributo(perguntas.get(numPerguntaFoco).getAtributo());
        sintoma.setValor(perguntas.get(numPerguntaFoco).getValor());
        sintoma.setFacto_certeza((CF + "").trim());

        Constantes.setSintomas(sintoma);

        ++numPerguntaFoco;
        if (numPerguntaFoco >= perguntas.size())
        {
            btnResultado.setVisible(true);

            jLabel15.setVisible(false);
            lblPergunta.setVisible(false);
            btnSim.setVisible(false);
            btnTalvezSim.setVisible(false);
            btnNaoSei.setVisible(false);
            btnTalvezNao.setVisible(false);
            btnNao.setVisible(false);
        }
        else
        {
            apresentar();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnSim = new javax.swing.JButton();
        btnTalvezSim = new javax.swing.JButton();
        btnNaoSei = new javax.swing.JButton();
        btnTalvezNao = new javax.swing.JButton();
        btnNao = new javax.swing.JButton();
        btnResultado = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        lblPergunta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        jLabel2.setText("Sistema de Diagnóstico Médico");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/estetoscopio - Cópia.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens2/002.jpg"))); // NOI18N
        jLabel15.setText("te questão");

        btnSim.setBackground(new java.awt.Color(17, 113, 108));
        btnSim.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnSim.setForeground(new java.awt.Color(255, 255, 255));
        btnSim.setText("Sim");
        btnSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimActionPerformed(evt);
            }
        });

        btnTalvezSim.setBackground(new java.awt.Color(17, 113, 108));
        btnTalvezSim.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnTalvezSim.setForeground(new java.awt.Color(255, 255, 255));
        btnTalvezSim.setText("Talvez Sim");
        btnTalvezSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTalvezSimActionPerformed(evt);
            }
        });

        btnNaoSei.setBackground(new java.awt.Color(17, 113, 108));
        btnNaoSei.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnNaoSei.setForeground(new java.awt.Color(255, 255, 255));
        btnNaoSei.setText("Não Sei");
        btnNaoSei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoSeiActionPerformed(evt);
            }
        });

        btnTalvezNao.setBackground(new java.awt.Color(17, 113, 108));
        btnTalvezNao.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnTalvezNao.setForeground(new java.awt.Color(255, 255, 255));
        btnTalvezNao.setText("Talvez Não");
        btnTalvezNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTalvezNaoActionPerformed(evt);
            }
        });

        btnNao.setBackground(new java.awt.Color(17, 113, 108));
        btnNao.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnNao.setForeground(new java.awt.Color(255, 255, 255));
        btnNao.setText("Não");
        btnNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoActionPerformed(evt);
            }
        });

        btnResultado.setBackground(new java.awt.Color(17, 113, 108));
        btnResultado.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnResultado.setText("Resultado");
        btnResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultadoActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(17, 113, 108));
        jButton9.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButton9.setText("Voltar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        lblPergunta.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lblPergunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPergunta.setText("Pergunta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel14)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPergunta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTalvezNao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNaoSei, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTalvezSim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(lblPergunta)
                .addGap(18, 18, 18)
                .addComponent(btnSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTalvezSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNaoSei)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTalvezNao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNao)
                .addGap(16, 16, 16)
                .addComponent(btnResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimActionPerformed
        processarResposta(Constantes.SIM);
    }//GEN-LAST:event_btnSimActionPerformed

    private void btnTalvezSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTalvezSimActionPerformed
        processarResposta(Constantes.TALVEZ_SIM);
    }//GEN-LAST:event_btnTalvezSimActionPerformed

    private void btnNaoSeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoSeiActionPerformed
        processarResposta(Constantes.NAO_SEI);
    }//GEN-LAST:event_btnNaoSeiActionPerformed

    private void btnTalvezNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTalvezNaoActionPerformed
        // TODO add your handling code here:
        processarResposta(Constantes.TALVEZ_NAO);
    }//GEN-LAST:event_btnTalvezNaoActionPerformed

    private void btnNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoActionPerformed
        // TODO add your handling code here:
        processarResposta(Constantes.NAO);
    }//GEN-LAST:event_btnNaoActionPerformed

    private void btnResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultadoActionPerformed
        dispose();
        new Resultado();
    }//GEN-LAST:event_btnResultadoActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.YES_NO_OPTION == JOptionPane.showConfirmDialog(null, "Deseja voltar ao Menu?", "Voltar", JOptionPane.YES_NO_CANCEL_OPTION))
        {
            dispose();
            new Menu().setVisible(true);
        }    
    }//GEN-LAST:event_jButton9ActionPerformed



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
            java.util.logging.Logger.getLogger(Diagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Diagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Diagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Diagnostico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Diagnostico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNao;
    private javax.swing.JButton btnNaoSei;
    private javax.swing.JButton btnResultado;
    private javax.swing.JButton btnSim;
    private javax.swing.JButton btnTalvezNao;
    private javax.swing.JButton btnTalvezSim;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPergunta;
    // End of variables declaration//GEN-END:variables
}