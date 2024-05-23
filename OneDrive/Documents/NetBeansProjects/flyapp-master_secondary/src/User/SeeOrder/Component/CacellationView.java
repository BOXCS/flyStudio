package User.SeeOrder.Component;

import User.SeeOrder.Service.ServiceMyOrder;
import raven.alerts.MessageAlerts;

public class CacellationView extends javax.swing.JDialog {

    private ServiceMyOrder serviceMyOrder;
    private String transactionNumber;

    public CacellationView(java.awt.Frame parent, boolean modal, String transactionNumber) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        serviceMyOrder = new ServiceMyOrder();
        this.transactionNumber = transactionNumber; // Set variabel ini dengan transactionNumber yang diterima
        loadReason(transactionNumber);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaReason = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cmdReport = new User.SeeOrder.Swing.Button();
        cmdClose = new User.SeeOrder.Swing.ButtonDash();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(3, 0, 45));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reason");

        areaReason.setColumns(20);
        areaReason.setForeground(new java.awt.Color(0, 0, 0));
        areaReason.setRows(5);
        jScrollPane1.setViewportView(areaReason);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cancellation View");

        cmdReport.setBackground(new java.awt.Color(215, 131, 131));
        cmdReport.setForeground(new java.awt.Color(255, 255, 255));
        cmdReport.setText("Report");
        cmdReport.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cmdReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdReportActionPerformed(evt);
            }
        });

        cmdClose.setForeground(new java.awt.Color(255, 255, 255));
        cmdClose.setText("X");
        cmdClose.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(cmdReport, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(cmdReport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdReportActionPerformed
        // Panggil metode untuk mengupdate status di database
        boolean success = serviceMyOrder.updateTransactionStatus(transactionNumber, "Reported Cancel");

        if (success) {
            MessageAlerts.getInstance().showMessage("Success", "Report Success", MessageAlerts.MessageType.SUCCESS);
        } else {
            MessageAlerts.getInstance().showMessage("Failed", "Report Failed", MessageAlerts.MessageType.ERROR);
        }

        this.dispose();
    }//GEN-LAST:event_cmdReportActionPerformed

    private void loadReason(String transactionNumber) {
        // Panggil metode loadReason dari ServiceMyOrder
        String reason = serviceMyOrder.loadReason(transactionNumber);

        // Tampilkan reason di areaReason
        areaReason.setText(reason);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaReason;
    private User.SeeOrder.Swing.ButtonDash cmdClose;
    private User.SeeOrder.Swing.Button cmdReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
