package Dashboard.Admin.AddMessage.Component.Designer;

import Dashboard.Admin.AddMessage.Model.ModelMessage;
import Dashboard.Admin.AddMessage.Model.ModelName;
import Dashboard.Admin.AddMessage.Service.ServiceMessage;
import LoginRegister.Model.ModelUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import raven.alerts.MessageAlerts;

public class MessageFill extends javax.swing.JFrame {

    public MessageFill() {
        initComponents();

        try {
            // Tambahkan item "All" sebagai item pertama dan default
            cbDesigner.addItem("All");

            List<ModelName> designers = new ServiceMessage().loadDesigner();
            for (ModelName designer : designers) {
                cbDesigner.addItem(designer.getUserName());
            }
            cbDesigner.setSelectedItem("All"); // Set item default sebagai "All"
        } catch (SQLException ex) {
            // Handle exception
            ex.printStackTrace();
        }
        // Di dalam ActionListener untuk tombol "SEND"
        cmdSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedDesigner = (String) cbDesigner.getSelectedItem();
                    ServiceMessage serviceMessage = new ServiceMessage();
                    boolean success = false;

                    if (selectedDesigner.equals("All")) {
                        // Jika "All" dipilih, kirim pesan ke semua desainer
                        List<ModelName> allDesigners = serviceMessage.getAllDesignersWithId();
                        for (ModelName designer : allDesigners) {
                            insertMessageForDesigner(designer.getId());
                        }
                        success = true;
                    } else {
                        // Jika dipilih desainer tertentu, cari receiverID berdasarkan username desainer
                        int receiverID = serviceMessage.getDesignerIDByUsername(selectedDesigner);
                        if (receiverID > 0) {
                            insertMessageForDesigner(receiverID);
                            success = true;
                        } else {
                            MessageAlerts.getInstance().showMessage("Error", "Designer not found", MessageAlerts.MessageType.ERROR);
                        }
                    }

                    if (success) {
                        MessageAlerts.getInstance().showMessage("Success", "Message sent", MessageAlerts.MessageType.SUCCESS);
                    }

                } catch (SQLException ex) {
                    // Handle exception
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to send message due to a database error.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void insertMessageForDesigner(int receiverID) throws SQLException {
                // Buat objek ModelMessage untuk disimpan ke database
                ModelMessage message = new ModelMessage();
                message.setReceiverID(receiverID);
                message.setTitle(txtTitle.getText());
                message.setDescription(txtContent.getText());
                message.setSentAt(new Date(System.currentTimeMillis())); // Tanggal saat ini
                message.setDeleteAt(new Date(jDateChooser1.getDate().getTime())); // Tanggal dari jDateChooser1
                if (rdImportant.isSelected()) {
                    message.setMessageStatus("Important");
                } else if (rdMedium.isSelected()) {
                    message.setMessageStatus("Medium");
                } else if (jRadioButton3.isSelected()) {
                    message.setMessageStatus("Low");
                }

                // Simpan pesan ke database menggunakan insertMessage
                new ServiceMessage().insertMessage(message);
            }
        });

        // Menambahkan MouseListener pada frame
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Memeriksa apakah klik dilakukan di luar frame
                if (e.getX() > getWidth() || e.getY() > getHeight() || e.getX() < 0 || e.getY() < 0) {
                    dispose(); // Menutup frame jika klik dilakukan di luar frame
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel1 = new Dashboard.Swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTitle = new Dashboard.Swing.TextField();
        txtContent = new Dashboard.Swing.TextField();
        cbDesigner = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        rdImportant = new javax.swing.JRadioButton();
        rdMedium = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        cmdSend = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.POPUP);

        roundPanel1.setBackground(new java.awt.Color(3, 0, 45));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Message");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Title");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Content");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Designer");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Delete date");

        buttonGroup1.add(rdImportant);
        rdImportant.setForeground(new java.awt.Color(255, 255, 255));
        rdImportant.setText("Important");

        buttonGroup1.add(rdMedium);
        rdMedium.setForeground(new java.awt.Color(255, 255, 255));
        rdMedium.setText("Medium");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Low");

        cmdSend.setBackground(new java.awt.Color(132, 132, 215));
        cmdSend.setForeground(new java.awt.Color(255, 255, 255));
        cmdSend.setText("SEND");
        cmdSend.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(rdImportant)
                        .addGap(35, 35, 35)
                        .addComponent(rdMedium)
                        .addGap(40, 40, 40)
                        .addComponent(jRadioButton3))
                    .addComponent(jLabel7)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContent, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(cbDesigner, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdSend, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdImportant)
                    .addComponent(rdMedium)
                    .addComponent(jRadioButton3))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbDesigner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(cmdSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MessageFill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessageFill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessageFill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessageFill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessageFill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbDesigner;
    private swing.Button cmdSend;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton rdImportant;
    private javax.swing.JRadioButton rdMedium;
    private Dashboard.Swing.RoundPanel roundPanel1;
    private Dashboard.Swing.TextField txtContent;
    private Dashboard.Swing.TextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
