package Admin.ViewOrder.component;

import Admin.ViewOrder.Service.ServiceViewOrder;
import raven.alerts.MessageAlerts;

public class cancelled_note extends javax.swing.JDialog {

    private String transactionNumber;
    private ServiceViewOrder serviceViewOrder;

    public cancelled_note(java.awt.Frame parent, boolean modal, String transactionNumber) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.transactionNumber = transactionNumber; // Mengatur nomor transaksi
        serviceViewOrder = new ServiceViewOrder();
        loadCancellationDetails(); // Memuat detail pembatalan dengan nomor transaksi yang diberikan
    }

    private void loadCancellationDetails() {
        // Memuat detail pembatalan menggunakan ServiceViewOrder
        String reason = serviceViewOrder.loadCancellationReason(transactionNumber);
        String footageLink = serviceViewOrder.loadCancellationFootageLink(transactionNumber);
        String information = serviceViewOrder.loadCancellationInformation(transactionNumber);
        String designer = serviceViewOrder.loadCancellationDesigner(transactionNumber);
        String userEmail = serviceViewOrder.loadCancellationUserEmail(transactionNumber);

        // Setel komponen GUI dengan detail yang dimuat
        areaReason.setText(reason);
        EditorFootage.setText(footageLink);
        areaInfo.setText(information);
        lbDesigner.setText(designer);
        lbEmail.setText(userEmail);
        lbTransactionNumber.setText(transactionNumber);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textAreaScroll1 = new swing.textarea.TextAreaScroll();
        areaInfo = new swing.textarea.TextArea();
        jLabel3 = new javax.swing.JLabel();
        lbTransactionNumber = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EditorFootage = new javax.swing.JEditorPane();
        jLabel5 = new javax.swing.JLabel();
        textAreaScroll2 = new swing.textarea.TextAreaScroll();
        areaReason = new swing.textarea.TextArea();
        lbDesigner = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        cmdDeny = new swing.Button();
        cmdAcc = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(3, 0, 45));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cancellation Detail");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reason :");

        textAreaScroll1.setLabelText("information");

        areaInfo.setColumns(20);
        areaInfo.setRows(5);
        textAreaScroll1.setViewportView(areaInfo);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Footage :");

        lbTransactionNumber.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbTransactionNumber.setForeground(new java.awt.Color(255, 255, 255));
        lbTransactionNumber.setText("TRS");

        jScrollPane1.setViewportView(EditorFootage);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Information :");

        textAreaScroll2.setLabelText("Reason");

        areaReason.setColumns(20);
        areaReason.setRows(5);
        textAreaScroll2.setViewportView(areaReason);

        lbDesigner.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbDesigner.setForeground(new java.awt.Color(255, 255, 255));
        lbDesigner.setText("designer");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Designer :");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email reporter :");

        lbEmail.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(255, 255, 255));
        lbEmail.setText("email");

        cmdDeny.setBackground(new java.awt.Color(215, 131, 131));
        cmdDeny.setForeground(new java.awt.Color(255, 255, 255));
        cmdDeny.setText("Deny Cancel Report");
        cmdDeny.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmdDeny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDenyActionPerformed(evt);
            }
        });

        cmdAcc.setBackground(new java.awt.Color(132, 132, 215));
        cmdAcc.setForeground(new java.awt.Color(255, 255, 255));
        cmdAcc.setText("Accept Cancel Report");
        cmdAcc.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmdAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textAreaScroll2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)
                                .addGap(14, 14, 14)
                                .addComponent(lbTransactionNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEmail)
                            .addComponent(lbDesigner))
                        .addGap(107, 107, 107)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(cmdDeny, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(cmdAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lbTransactionNumber)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lbDesigner)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textAreaScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdDeny, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void cmdDenyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDenyActionPerformed
        boolean success = serviceViewOrder.updateReport(transactionNumber, "Denied Report");
        
        if (success) {
            MessageAlerts.getInstance().showMessage("Success", "Report Denied", MessageAlerts.MessageType.SUCCESS);
        } else {
            MessageAlerts.getInstance().showMessage("Failed", "Report Failed", MessageAlerts.MessageType.ERROR);
        }
    }//GEN-LAST:event_cmdDenyActionPerformed

    private void cmdAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAccActionPerformed
        boolean success = serviceViewOrder.updateReport(transactionNumber, "Accepted Report");
        
        if (success) {
            MessageAlerts.getInstance().showMessage("Success", "Report Accepted", MessageAlerts.MessageType.SUCCESS);
        } else {
            MessageAlerts.getInstance().showMessage("Failed", "Report Failed", MessageAlerts.MessageType.ERROR);
        }
    }//GEN-LAST:event_cmdAccActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane EditorFootage;
    private swing.textarea.TextArea areaInfo;
    private swing.textarea.TextArea areaReason;
    private swing.Button cmdAcc;
    private swing.Button cmdDeny;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDesigner;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbTransactionNumber;
    private swing.textarea.TextAreaScroll textAreaScroll1;
    private swing.textarea.TextAreaScroll textAreaScroll2;
    // End of variables declaration//GEN-END:variables
}
