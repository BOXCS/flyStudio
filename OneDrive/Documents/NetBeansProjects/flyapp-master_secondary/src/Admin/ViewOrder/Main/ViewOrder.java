/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Admin.ViewOrder.Main;

import Admin.ViewOrder.Service.ServiceViewOrder;
import Admin.ViewOrder.Swing.CellCancelled.CellCancelledRenderer;
import Admin.ViewOrder.Swing.CellCancelled.TableActionCancelledEvent;
import Admin.ViewOrder.Swing.CellCancelled.TableCancelledCellEditor;
import Admin.ViewOrder.Swing.CellLate.CellLateRenderer;
import Admin.ViewOrder.Swing.CellLate.TableActionLateEvent;
import Admin.ViewOrder.Swing.CellLate.TableLateCellEditor;
import Admin.ViewOrder.component.cancelled_note;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;

/**
 *
 * @author lenovo
 */
public class ViewOrder extends javax.swing.JPanel {

    private ServiceViewOrder serviceViewOrder;

    public ViewOrder() {
        initComponents();
        setOpaque(false);
        serviceViewOrder = new ServiceViewOrder();

        tableActive.addTableStyle(jScrollPane13);
        tableWaiting.addTableStyle(jScrollPane21);
        tablePending.addTableStyle(jScrollPane22);
        tableFinished.addTableStyle(jScrollPane23);
        tableCancelled.addTableStyle(jScrollPane24);
        tableLate.addTableStyle(jScrollPane25);

        ServiceViewOrder.fetchActiveOrders((DefaultTableModel) tableActive.getModel());
        ServiceViewOrder.fetchWaitingOrders((DefaultTableModel) tableWaiting.getModel());
        ServiceViewOrder.fetchPendingOrders((DefaultTableModel) tablePending.getModel());
        ServiceViewOrder.fetchFinishedOrders((DefaultTableModel) tableFinished.getModel());
        ServiceViewOrder.fetchCancelledOrders((DefaultTableModel) tableCancelled.getModel());
        ServiceViewOrder.fetchLateOrders((DefaultTableModel) tableLate.getModel());

        TableActionCancelledEvent eventC = new TableActionCancelledEvent() {
            @Override
            public void onNoteCancel(int row) {
                int selectedRow = tableCancelled.getSelectedRow();
                if (selectedRow != -1) {
                    Object transactionNumber = tableCancelled.getValueAt(selectedRow, 0);
                    // Panggil dialog cancelled_note dengan nomor transaksi
                    cancelled_note dialog = new cancelled_note((java.awt.Frame) SwingUtilities.getWindowAncestor(tableCancelled), true, transactionNumber.toString());
                    dialog.setVisible(true);
                }
            }
        };
        tableCancelled.getColumnModel().getColumn(8).setCellRenderer(new CellCancelledRenderer());
        tableCancelled.getColumnModel().getColumn(8).setCellEditor(new TableCancelledCellEditor(eventC));

        TableActionLateEvent eventL = new TableActionLateEvent() {
            @Override
            public void onApprove(int row) {
                int selectedRow = tableLate.getSelectedRow();
                if (selectedRow != -1) {
                    Object transactionNumber = tableLate.getValueAt(selectedRow, 0);
                    MessageAlerts.getInstance().showMessage("Confirmation", "Accept Request?", MessageAlerts.MessageType.DEFAULT, MessageAlerts.YES_NO_OPTION, new PopupCallbackAction() {
                        @Override
                        public void action(PopupController pc, int i) {
                            if (i == MessageAlerts.YES_OPTION) {
                                Object transactionNumber = tableLate.getValueAt(selectedRow, 0);
                                serviceViewOrder.updateTransactionStatusLate(transactionNumber.toString(), "Refund Accepted");
                            }
                        }

                    });
                }
            }
        };
        tableLate.getColumnModel().getColumn(8).setCellRenderer(new CellLateRenderer());
        tableLate.getColumnModel().getColumn(8).setCellEditor(new TableLateCellEditor(eventL));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new Dashboard.Swing.RoundPanel();
        materialTabbed1 = new Admin.Swing.MaterialTabbed();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableActive = new Dashboard.Swing.Table();
        jScrollPane10 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tableWaiting = new Dashboard.Swing.Table();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tablePending = new Dashboard.Swing.Table();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        tableFinished = new Dashboard.Swing.Table();
        jScrollPane17 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tableCancelled = new Dashboard.Swing.Table();
        jScrollPane19 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tableLate = new Dashboard.Swing.Table();

        setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        roundPanel2.setBackground(new java.awt.Color(0, 0, 0, 50));

        materialTabbed1.setForeground(new java.awt.Color(255, 255, 255));
        materialTabbed1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jScrollPane9.setBorder(null);

        jPanel9.setBackground(new java.awt.Color(0, 0, 0, 0));

        jScrollPane13.setBorder(null);

        tableActive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No Transaction", "Username", "Product", "Level", "Designer", "Due on", "Amount", "Status"
            }
        ));
        tableActive.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane13.setViewportView(tableActive);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        jScrollPane9.setViewportView(jPanel9);

        materialTabbed1.addTab("Active", jScrollPane9);

        jScrollPane10.setBorder(null);

        jPanel10.setBackground(new java.awt.Color(0, 0, 0, 0));

        jScrollPane21.setBorder(null);

        tableWaiting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No Transaction", "Username", "Product", "Level", "Designer", "Due on", "Amount", "Status"
            }
        ));
        tableWaiting.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane21.setViewportView(tableWaiting);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        jScrollPane10.setViewportView(jPanel10);

        materialTabbed1.addTab("Waiting", jScrollPane10);

        jScrollPane11.setBorder(null);

        jPanel11.setBackground(new java.awt.Color(0, 0, 0, 0));

        jScrollPane22.setBorder(null);

        tablePending.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No Transaction", "Username", "Product", "Level", "Designer", "Due on", "Amount", "Status"
            }
        ));
        tablePending.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane22.setViewportView(tablePending);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        jScrollPane11.setViewportView(jPanel11);

        materialTabbed1.addTab("Pending", jScrollPane11);

        jScrollPane12.setBorder(null);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0, 0));

        jScrollPane23.setBorder(null);

        tableFinished.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No Transaction", "Username", "Product", "Level", "Designer", "Due on", "Amount", "Status"
            }
        ));
        tableFinished.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane23.setViewportView(tableFinished);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        jScrollPane12.setViewportView(jPanel12);

        materialTabbed1.addTab("Finished", jScrollPane12);

        jScrollPane17.setBorder(null);

        jPanel13.setBackground(new java.awt.Color(0, 0, 0, 0));

        jScrollPane24.setBorder(null);

        tableCancelled.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No Transaction", "Username", "Product", "Level", "Designer", "Due on", "Amount", "Status", "Action"
            }
        ));
        tableCancelled.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane24.setViewportView(tableCancelled);
        if (tableCancelled.getColumnModel().getColumnCount() > 0) {
            tableCancelled.getColumnModel().getColumn(8).setHeaderValue("Action");
        }

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        jScrollPane17.setViewportView(jPanel13);

        materialTabbed1.addTab("Cancelled", jScrollPane17);

        jScrollPane19.setBorder(null);

        jPanel14.setBackground(new java.awt.Color(0, 0, 0, 0));

        jScrollPane25.setBorder(null);

        tableLate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No Transaction", "Username", "Product", "Level", "Designer", "Due on", "Amount", "Status", "Action"
            }
        ));
        tableLate.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane25.setViewportView(tableLate);
        if (tableLate.getColumnModel().getColumnCount() > 0) {
            tableLate.getColumnModel().getColumn(8).setHeaderValue("Action");
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        jScrollPane19.setViewportView(jPanel14);

        materialTabbed1.addTab("Late", jScrollPane19);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane9;
    private Admin.Swing.MaterialTabbed materialTabbed1;
    private Dashboard.Swing.RoundPanel roundPanel2;
    private Dashboard.Swing.Table tableActive;
    private Dashboard.Swing.Table tableCancelled;
    private Dashboard.Swing.Table tableFinished;
    private Dashboard.Swing.Table tableLate;
    private Dashboard.Swing.Table tablePending;
    private Dashboard.Swing.Table tableWaiting;
    // End of variables declaration//GEN-END:variables
}
