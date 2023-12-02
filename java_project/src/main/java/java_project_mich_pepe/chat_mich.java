/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java_project_mich_pepe;

import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author michelle
 */
public class chat_mich extends javax.swing.JFrame {

    /**
     * Creates new form chat_mich
     */
    static ServerSocket serversocket;
    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;

    public chat_mich() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areamessage = new javax.swing.JScrollPane();
        area_message = new javax.swing.JTextArea();
        tf_ = new javax.swing.JTextField();
        send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(420, 420));

        area_message.setBackground(new java.awt.Color(204, 255, 204));
        area_message.setColumns(20);
        area_message.setRows(5);
        areamessage.setViewportView(area_message);

        tf_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ActionPerformed(evt);
            }
        });

        send.setBackground(new java.awt.Color(255, 255, 0));
        send.setText("send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        send.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sendKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_)
                        .addGap(18, 18, 18)
                        .addComponent(send)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(areamessage, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(areamessage, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:

        try {
            String newmessage = "";
            newmessage = tf_.getText().trim();
            out.writeUTF(newmessage);

            tf_.setText("");

        } catch (IOException e) {
            Logger.getLogger(chat_pepe.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_sendActionPerformed

    private void sendKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sendKeyPressed
        // TODO add your handling code here:

        send.addActionListener((ActionListener) this);
        if (evt.getSource() == send) {
            try {
                Socket cli = new Socket("192.168.0.8", 5555);
                DataOutputStream flujo = new DataOutputStream(cli.getOutputStream());
                flujo.writeUTF(tf_.getText());
                cli.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_sendKeyPressed

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
            java.util.logging.Logger.getLogger(chat_mich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_mich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_mich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_mich.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new chat_mich().setVisible(true);
        });
        
        String message = "";

        try {
            serversocket = new ServerSocket(5555);
            socket = serversocket.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while (!message.equals("exit")) {
                message = in.readUTF();
                area_message.setText(area_message.getText().trim() + "\n Cliente : " + message);
            }
        } catch (IOException e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea area_message;
    private static javax.swing.JScrollPane areamessage;
    private javax.swing.JButton send;
    private javax.swing.JTextField tf_;
    // End of variables declaration//GEN-END:variables
}
