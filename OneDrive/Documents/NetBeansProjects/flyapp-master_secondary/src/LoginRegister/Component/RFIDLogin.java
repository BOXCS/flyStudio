package LoginRegister.Component;

import Dashboard.Admin.DashboardAdmin;
import LoginRegister.Model.ModelUser;
import LoginRegister.Service.ServiceLogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RFIDLogin extends javax.swing.JDialog {

    private ServiceLogin serviceLogin;
    private ModelUser user;

    public RFIDLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        serviceLogin = new ServiceLogin();
        user = new ModelUser();
        setLocationRelativeTo(null);
        scan.setVisible(false);

        // Automatically focus on the scan text field when the dialog opens
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {
                scan.requestFocusInWindow();
            }
        });

        // Add key listener to the scan text field
        scan.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String rfid = scan.getText().trim();
                if (rfid.length() >= 10 && rfid.length() <= 12) {
                    try {
                        if (serviceLogin.isValidRFID(rfid)) {
                            // Dispose all frames
                            disposeAllFrames();

                            // Open DashboardAdmin
                            DashboardAdmin dashboard = new DashboardAdmin(user);
                            dashboard.setVisible(true);
                            dispose(); // Dispose the dialog
                        } else {
                            JOptionPane.showMessageDialog(RFIDLogin.this, "Invalid RFID", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(RFIDLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    scan.setText(""); // Clear the text field after processing
                }
            }
        });
    }

    private void disposeAllFrames() {
        for (Frame frame : Frame.getFrames()) {
            frame.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        instructionLabel = new javax.swing.JLabel();
        scan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(3, 0, 45));

        iconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginRegister/icon/scan.png"))); // NOI18N
        iconLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        instructionLabel.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        instructionLabel.setForeground(new java.awt.Color(255, 255, 255));
        instructionLabel.setText("Scan Your RFID Here");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(instructionLabel)
                .addGap(206, 206, 206))
            .addComponent(iconLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(scan, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(iconLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(instructionLabel)
                .addGap(40, 40, 40)
                .addComponent(scan, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel instructionLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField scan;
    // End of variables declaration//GEN-END:variables
}
