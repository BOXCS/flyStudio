package Admin.AddDesigner.Main;

import Admin.AddDesigner.Service.ModelDesignerLogin;
import LoginRegister.Component.PanelLoading;
import LoginRegister.Service.ServiceLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import raven.alerts.MessageAlerts;

public class AddDesignerMain extends javax.swing.JPanel {

    public ModelDesignerLogin getDesigner() {
        return designerLogin;
    }

    private ModelDesignerLogin designerLogin;
    private ServiceLogin service;
    private PanelLoading loading;

    public AddDesignerMain() {
        initComponents();
        service = new ServiceLogin();
        loading = new PanelLoading();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel1 = new Dashboard.Swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPass = new swing.MyPasswordField();
        txtUsername = new swing.MyTextField();
        jLabel4 = new javax.swing.JLabel();
        txtInsta = new swing.MyTextField();
        jLabel5 = new javax.swing.JLabel();
        cbContent = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        btnCreate = new swing.Button();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new swing.MyTextField();

        roundPanel1.setBackground(new java.awt.Color(0, 0, 0, 50));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Input Designer Details");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Instagram");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Type of Content");

        cbContent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Video Editing", "Design Graphic", "3D Modelling" }));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Status");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Available");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Unavailable");

        btnCreate.setBackground(new java.awt.Color(132, 132, 215));
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create");
        btnCreate.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(47, 47, 47)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInsta, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                                        .addGap(92, 92, 92)
                                        .addComponent(jLabel6)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(188, 188, 188))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(cbContent, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addGap(4, 4, 4)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtInsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbContent, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // Ambil input dari komponen
        String userName = txtUsername.getText().trim();
        String email = txtEmail.getText().trim();
        String password = String.valueOf(txtPass.getPassword());
        String instagram = txtInsta.getText().trim();
        String typeContent = cbContent.getSelectedItem().toString();
        String status = jRadioButton1.isSelected() ? "Available" : "Unavailable";

        // Validasi input
        if (!validateInputs(userName, email, password, instagram, typeContent)) {
            return; // Jika validasi gagal, hentikan eksekusi lebih lanjut
        }

        designerLogin = new ModelDesignerLogin(0, userName, email, password, instagram, typeContent, status);

        try {
            // Periksa duplikasi username sebelum mencoba menyisipkan
            if (service.checkDuplicateDesigner(userName)) {
                // Tampilkan pesan kesalahan untuk duplikasi username
                MessageAlerts.getInstance().showMessage("Error", "Username already exists", MessageAlerts.MessageType.ERROR);
            } else {
                // Coba menyisipkan desainer ke dalam database
                service.insertDesigner(designerLogin);

                // Tampilkan pesan sukses
                MessageAlerts.getInstance().showMessage("Success", "Designer added successfully", MessageAlerts.MessageType.SUCCESS);

                // Opsi untuk mereset form atau melakukan tindakan lain setelah sukses
                resetForm();
            }
        } catch (SQLException e) {
            // Tangkap pengecualian SQL
            JOptionPane.showMessageDialog(this, "Failed to add designer to the database.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Log pengecualian untuk keperluan debugging
        } catch (Exception e) {
            // Tangkap pengecualian umum untuk kesalahan lainnya
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Log pengecualian untuk keperluan debugging
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private boolean validateInputs(String userName, String email, String password, String instagram, String typeContent) {
        if (userName.isEmpty()) {
            MessageAlerts.getInstance().showMessage("Input Error", "Username is required.", MessageAlerts.MessageType.ERROR);
            return false;
        }
        if (email.isEmpty()) {
            MessageAlerts.getInstance().showMessage("Input Error", "Email is required.", MessageAlerts.MessageType.ERROR);
            return false;
        }
        if (password.isEmpty()) {
            MessageAlerts.getInstance().showMessage("Input Error", "Password is required.", MessageAlerts.MessageType.ERROR);
            return false;
        }
        if (typeContent.isEmpty() || typeContent.equals("Select Content Type")) {
            MessageAlerts.getInstance().showMessage("Input Error", "Content type is required.", MessageAlerts.MessageType.ERROR);
            return false;
        }
        return true;
    }

    private void resetForm() {
        txtUsername.setText("");
        txtEmail.setText("");
        txtPass.setText("");
        txtInsta.setText("");
        cbContent.setSelectedIndex(0);
        jRadioButton1.setSelected(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnCreate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbContent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private Dashboard.Swing.RoundPanel roundPanel1;
    private swing.MyTextField txtEmail;
    private swing.MyTextField txtInsta;
    private swing.MyPasswordField txtPass;
    private swing.MyTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
