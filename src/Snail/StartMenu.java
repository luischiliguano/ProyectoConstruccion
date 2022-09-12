/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Snail;

import Conection.PlayerConection;
import Login.JFScoresTable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartMenu extends javax.swing.JFrame {

    private SnailGame snailGame;

    boolean mode;
    PlayerConection player = new PlayerConection();

    public StartMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void startGame() {
        new SnailGame().start();
    }

    public void exitGame() {
        System.exit(0);
        //checkFacade = new CheckFacade();
    }

    public void cambiarCurrentActive() {
        try {
            String nick = player.ObtenerNickCurrentActive(1);
            player.ModificarCurrentActive0(nick);
        } catch (SQLException ex) {
            Logger.getLogger(StartMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void viewScores() throws SQLException {
        new JFScoresTable().setVisible(true);
        this.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desk = new javax.swing.JPanel();
        start1Player = new javax.swing.JButton();
        Return = new javax.swing.JButton();
        jBScores = new javax.swing.JButton();
        jBExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Start Menu");
        setUndecorated(true);

        Desk.setBackground(java.awt.Color.black);

        start1Player.setFont(new java.awt.Font("KenVector Future Thin", 0, 18)); // NOI18N
        start1Player.setText("START GAME");
        start1Player.setBorder(null);
        start1Player.setBorderPainted(false);
        start1Player.setFocusPainted(false);
        start1Player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start1PlayerActionPerformed(evt);
            }
        });

        Return.setFont(new java.awt.Font("KenVector Future Thin", 0, 18)); // NOI18N
        Return.setText("RETURN");
        Return.setBorder(null);
        Return.setBorderPainted(false);
        Return.setFocusPainted(false);
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });

        jBScores.setFont(new java.awt.Font("KenVector Future Thin", 0, 18)); // NOI18N
        jBScores.setText("SCORES");
        jBScores.setBorder(null);
        jBScores.setBorderPainted(false);
        jBScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBScoresActionPerformed(evt);
            }
        });

        jBExit.setFont(new java.awt.Font("KenVector Future Thin", 1, 12)); // NOI18N
        jBExit.setForeground(new java.awt.Color(255, 51, 51));
        jBExit.setText("X");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeskLayout = new javax.swing.GroupLayout(Desk);
        Desk.setLayout(DeskLayout);
        DeskLayout.setHorizontalGroup(
            DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeskLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeskLayout.createSequentialGroup()
                        .addComponent(jBExit)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeskLayout.createSequentialGroup()
                        .addGroup(DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBScores, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(start1Player, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(152, 152, 152))))
        );
        DeskLayout.setVerticalGroup(
            DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeskLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBExit)
                .addGap(85, 85, 85)
                .addComponent(start1Player, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jBScores, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(Return, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void start1PlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start1PlayerActionPerformed
        // TODO add your handling code here:
        //mode = true;
        startGame();
        this.setVisible(false);
    }//GEN-LAST:event_start1PlayerActionPerformed

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        // TODO add your handling code here:
        exitGame();

    }//GEN-LAST:event_ReturnActionPerformed

    private void jBScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBScoresActionPerformed

        try {
            viewScores();
        } catch (SQLException ex) {
            Logger.getLogger(StartMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBScoresActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        cambiarCurrentActive();
        System.exit(0);

    }//GEN-LAST:event_jBExitActionPerformed

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
            java.util.logging.Logger.getLogger(StartMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Desk;
    private javax.swing.JButton Return;
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBScores;
    private javax.swing.JButton start1Player;
    // End of variables declaration//GEN-END:variables
}
