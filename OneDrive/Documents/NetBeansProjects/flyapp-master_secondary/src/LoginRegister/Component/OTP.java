package LoginRegister.Component;

import LoginRegister.Service.ServiceForgetPassword;
import LoginRegister.Service.ServiceOTP;
import java.awt.Window;
import javax.swing.JOptionPane;

public class OTP extends javax.swing.JDialog {

    private boolean otpVerified = false;
    private final ServiceForgetPassword serviceForgot = new ServiceForgetPassword();
    private final ServiceOTP serviceOtp = new ServiceOTP();
    private String email;

    public OTP(Window owner, boolean modal, String email) {
        super(owner, "OTP Verification", modal ? ModalityType.APPLICATION_MODAL : ModalityType.MODELESS);
        this.email = email;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        lbForgotPassword = new javax.swing.JLabel();
        lbForgotPassword1 = new javax.swing.JLabel();
        txtOTP = new swing.MyTextField();
        cmdSend = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(69, 67, 102));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginRegister/icon/Fly.png"))); // NOI18N

        lbForgotPassword.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbForgotPassword.setForeground(new java.awt.Color(204, 204, 204));
        lbForgotPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbForgotPassword.setText("OTP Sent");

        lbForgotPassword1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbForgotPassword1.setForeground(new java.awt.Color(204, 204, 204));
        lbForgotPassword1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbForgotPassword1.setText("Check your email");

        cmdSend.setBackground(new java.awt.Color(132, 132, 215));
        cmdSend.setForeground(new java.awt.Color(255, 255, 255));
        cmdSend.setText("Send");
        cmdSend.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                            .addComponent(lbForgotPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbForgotPassword1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(txtOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 93, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(cmdSend, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbForgotPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbForgotPassword1)
                .addGap(18, 18, 18)
                .addComponent(txtOTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(cmdSend, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSendActionPerformed
        String otp = txtOTP.getText().trim();
        if (serviceOtp.validateOTP(email, otp)) {
            otpVerified = true;
            JOptionPane.showMessageDialog(this, "OTP verified successfully.");
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid OTP or OTP expired.");
        }
    }//GEN-LAST:event_cmdSendActionPerformed

    public boolean isOtpVerified() {
        return otpVerified;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button cmdSend;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbForgotPassword;
    private javax.swing.JLabel lbForgotPassword1;
    private swing.MyTextField txtOTP;
    // End of variables declaration//GEN-END:variables
}
