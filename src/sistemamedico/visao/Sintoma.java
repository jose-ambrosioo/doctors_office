/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamedico.visao;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import sistemamedico.dao.PerguntaDAO;
import sistemamedico.dao.RespostaDAO;
import sistemamedico.modelo.Pergunta;

/**
 *
 * @author Nano
 */
public class Sintoma extends javax.swing.JFrame {

    /**
     * Creates new form Doenca
     */
    public Sintoma() {
        super("SisMedi - Sintoma");
        this.setContentPane(new JLabel(new ImageIcon(getClass().getResource("/imagens2/1.jpg"))));
        initComponents();
        setLocationRelativeTo(null); // Abre a janela no centro da tela
        setResizable(false); // Desactivando a opção de redimensionar
        setVisible(true); // Define a visibilidade da janela
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Desactivar o fecho ao clicar em x
        URL caminhoImagem = this.getClass().getClassLoader().getResource("imagens/estetoscopio.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);
        
        carregarSintomas();
    }
    
    private void carregarSintomas()
    {
        listaSintomas.setModel(getSintomas());
    }
    
    private ListModel<String> getSintomas()
    {
        DefaultListModel<String> sintomas = new DefaultListModel<>();
        
        for (Pergunta p : PerguntaDAO.getPerguntas())
            sintomas.addElement(p.getValor());
        
        return sintomas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEncerrar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtSintoma = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaSintomas = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEncerrar1.setBackground(new java.awt.Color(17, 113, 108));
        btnEncerrar1.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnEncerrar1.setText("Voltar");
        btnEncerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrar1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel2.setText("Novo Sintoma");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/estetoscopio.png"))); // NOI18N

        txtSintoma.setBackground(new java.awt.Color(17, 113, 108));
        txtSintoma.setForeground(new java.awt.Color(255, 255, 255));

        btnSalvar.setBackground(new java.awt.Color(17, 113, 108));
        btnSalvar.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        listaSintomas.setBackground(new java.awt.Color(17, 113, 108));
        listaSintomas.setForeground(new java.awt.Color(255, 255, 255));
        listaSintomas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaSintomas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel14))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEncerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSintoma)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtSintoma, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEncerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nomeSintoma = txtSintoma.getText().trim().toLowerCase().replace(" ", "_");

        Boolean existe = false;
        for(Pergunta pergunta : PerguntaDAO.getPerguntas())
        {
            if(pergunta.getValor().equalsIgnoreCase(nomeSintoma))
            existe = true;
        }

        if(existe)
        JOptionPane.showMessageDialog( null, "O sintoma "+nomeSintoma+" já existe na base de conhecimento ");
        else
        {
            RespostaDAO.inserirNovoSintoma(nomeSintoma);
            carregarSintomas();
            JOptionPane.showMessageDialog( null, "Salvo com sucesso");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEncerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrar1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Cadastro().setVisible(true);
    }//GEN-LAST:event_btnEncerrar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Sintoma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sintoma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sintoma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sintoma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sintoma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncerrar1;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaSintomas;
    private javax.swing.JTextField txtSintoma;
    // End of variables declaration//GEN-END:variables
}
