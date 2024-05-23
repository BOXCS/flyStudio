/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Admin.analytic;

import Admin.analytic.Model.DesignerAnalytics;
import Admin.analytic.service.service;
import Dashboard.Designer.Analythics.Model.modelChart;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.SwingUtilities;
import jnafilechooser.api.JnaFileChooser;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import raven.alerts.MessageAlerts;

/**
 *
 * @author LENOVO
 */
public class AnalyticAdminmain extends javax.swing.JPanel {

    private service service;

    public AnalyticAdminmain() {
        initComponents();
        service = new service();
        init();
        setOpaque(false);
        earnTodate();
        mostSellingLevel();
        orderComplete();
        displayCompletion();

        displayEarnInMonth();

        cmdDownloadExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cmdDownloadExcelActionPerformed(evt);
            }
        });
    }

    private void init() {
        chart1.addLegend("Sales", new Color(12, 84, 175), new Color(0, 108, 247));
        chart1.addLegend("Cancelled", new Color(54, 4, 143), new Color(104, 49, 200));
        chart1.addLegend("Completed", new Color(5, 125, 0), new Color(95, 209, 69));
        updateChart();
        chart1.start();
    }

    private void earnTodate() {
        try {
            double totalEarning = service.getTotalAmount();

            String formattedEarning = String.format("$ %.1f", totalEarning);

            total.setText(formattedEarning);
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan saat mengakses database: " + e.getMessage());
            total.setText("N/A");
        }
    }

    private void mostSellingLevel() {

        try {
            String mostLevel = service.getMostFrequentLevel();

            lbAvgLevel.setText(mostLevel);
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan saat mengakses database: " + e.getMessage());
            lbAvgLevel.setText("N/A");
        }
    }

    private void orderComplete() {
        try {
            int Complete = service.getFinishedStatus();
            lbCompleted.setText(String.valueOf(Complete));
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan saat mengakses database: " + e.getMessage());
            lbCompleted.setText("N/A");

        }
    }

    private void displayCompletion() {

        try {
            double averageSuccessRate = service.getAverageSuccessRate();

            lbCompletion.setText(String.format("%.2f%%", averageSuccessRate));
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan saat mengakses database: " + e.getMessage());
            total.setText("N/A");
        }
    }

    private void displayEarnInMonth() {

        try {
            // Mendapatkan total penghasilan untuk bulan saat ini dan nama bulan dari serviceDesigner
            Map<String, Double> totalEarningsByMonth = service.getTotalAmountForCurrentMonth();

            // Cek apakah Map berisi data untuk bulan saat ini
            if (!totalEarningsByMonth.isEmpty()) {
                // Ambil total penghasilan dan nama bulan pertama dari Map
                String monthName = totalEarningsByMonth.keySet().iterator().next();
                double totalEarningInMonth = totalEarningsByMonth.get(monthName);

                // Format penghasilan ke dalam format uang
                String formattedEarning = String.format("$ %.1f", totalEarningInMonth);

                // Setel nilai ke label
                lbEarnMonth.setText(formattedEarning);
                lbMonth.setText("Earned in " + monthName);
            } else {
                // Jika tidak ada data, setel label ke "N/A" dan bulan saat ini
                lbEarnMonth.setText("$ 0");

                // Format nama bulan saat ini menjadi title case
                DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
                String formattedMonthName = LocalDate.now().format(monthFormatter);

                lbMonth.setText("Earned in " + formattedMonthName);
            }
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
            System.err.println("Terjadi kesalahan saat mengakses database: " + e.getMessage());
            e.printStackTrace();
            lbEarnMonth.setText("N/A");
            lbMonth.setText("N/A");
        }
    }

    private void updateChart() {

        try {
            // Mendapatkan data total amount per bulan saat ini
            Map<String, Double> totalAmountByMonth = service.getTotalAmountByMonth();

            // Mendapatkan jumlah transaksi dengan status "Cancelled"
            Map<String, Integer> cancelledCountByMonth = service.getCountOfCancelledStatus();

            // Mendapatkan jumlah transaksi dengan status "Finished"
            Map<String, Integer> completedCountByMonth = service.getCountOfFinishedStatusByMonth();

            // Iterasi melalui total amount per bulan
            for (Map.Entry<String, Double> entry : totalAmountByMonth.entrySet()) {
                // Ambil nama bulan dan total amount
                String monthName = entry.getKey();
                double salesAmount = entry.getValue();

                // Debugging: periksa nama bulan dan cancelledCount
                System.out.println("Month: " + monthName + ", Cancelled Count: " + cancelledCountByMonth.getOrDefault(monthName, 0));

                int cancelledCount = cancelledCountByMonth.getOrDefault(monthName, 0);
                int completedCount = completedCountByMonth.getOrDefault(monthName, 0);

                // Tambahkan data ke dalam chart untuk bulan yang sesuai
                chart1.addData(new modelChart(monthName, new double[]{
                    salesAmount, // Data untuk legend "Sales"
                    (double) cancelledCount, // Data untuk legend "Cancelled"
                    (double) completedCount // Data untuk legend "Completed"
                }));
            }

            // Mulai chart jika diperlukan
            chart1.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Terjadi kesalahan saat mengakses database: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is alwaysk
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Dashboard.Swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbAvgLevel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbCompletion = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbCompleted = new javax.swing.JLabel();
        lbMonth = new javax.swing.JLabel();
        lbEarnMonth = new javax.swing.JLabel();
        chart1 = new Dashboard.Designer.Analythics.Chart.Chart();
        cmdDownloadExcel = new Dashboard.Swing.Button();

        setPreferredSize(new java.awt.Dimension(1366, 768));

        roundPanel1.setBackground(new java.awt.Color(0, 0, 0, 50));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Analytics");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Earnings to date");

        total.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setText("$ Amount");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Avg. selling level");

        lbAvgLevel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbAvgLevel.setForeground(new java.awt.Color(255, 255, 255));
        lbAvgLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAvgLevel.setText("most level");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Order completion");

        lbCompletion.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbCompletion.setForeground(new java.awt.Color(255, 255, 255));
        lbCompletion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCompletion.setText("% Completion");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Orders completed");

        lbCompleted.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbCompleted.setForeground(new java.awt.Color(255, 255, 255));
        lbCompleted.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCompleted.setText("Completed");

        lbMonth.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbMonth.setForeground(new java.awt.Color(255, 255, 255));
        lbMonth.setText("Earned in Month");

        lbEarnMonth.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbEarnMonth.setForeground(new java.awt.Color(255, 255, 255));
        lbEarnMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEarnMonth.setText("$ Amount");

        cmdDownloadExcel.setBackground(new java.awt.Color(132, 132, 215));
        cmdDownloadExcel.setForeground(new java.awt.Color(255, 255, 255));
        cmdDownloadExcel.setText("Download Report File");
        cmdDownloadExcel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cmdDownloadExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDownloadExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdDownloadExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(total)))
                        .addGap(68, 68, 68)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbAvgLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCompletion, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbEarnMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(236, 236, 236))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(cmdDownloadExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbAvgLevel))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbCompletion))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbCompleted))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(lbMonth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbEarnMonth))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(total)))
                .addGap(87, 87, 87)
                .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDownloadExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDownloadExcelActionPerformed
        JnaFileChooser fileDialog = new JnaFileChooser();
        fileDialog.setTitle("Specify a file to save");

        if (fileDialog.showSaveDialog((java.awt.Window) SwingUtilities.getWindowAncestor(this))) {
            File fileToSave = fileDialog.getSelectedFile();
            if (fileToSave != null) {
                saveExcelFile(fileToSave);
            }
        }
    }//GEN-LAST:event_cmdDownloadExcelActionPerformed

    private void saveExcelFile(File fileToSave) {
    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
        XSSFSheet sheet = workbook.createSheet("Designer Analytics Report");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Username");
        headerRow.createCell(1).setCellValue("Level");
        headerRow.createCell(2).setCellValue("Monthly Income");
        headerRow.createCell(3).setCellValue("Month");

        // Get designer analytics data from the service
        List<DesignerAnalytics> analyticsData = service.getDesignerAnalytics();

        // Debugging: Log the retrieved data
        System.out.println("Retrieved " + analyticsData.size() + " records");

        // Create data rows
        int rowIndex = 1;
        for (DesignerAnalytics data : analyticsData) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(data.getUsername());
            row.createCell(1).setCellValue(data.getLevel());
            row.createCell(2).setCellValue(data.getMonthlyIncome());
            row.createCell(3).setCellValue(data.getMonth());

            // Debugging: Log the data being written to the Excel file
            System.out.println("Writing data: " + data.getUsername() + ", " + data.getLevel() + ", " + data.getMonthlyIncome() + ", " + data.getMonth());
        }

        // Adjust column width to fit the content
        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }

        // Debugging: Log the file path
        System.out.println("Saving file to: " + fileToSave.getAbsolutePath() + ".xlsx");

        // Save the Excel file
        try (FileOutputStream outputStream = new FileOutputStream(fileToSave.getAbsolutePath() + ".xlsx")) {
            workbook.write(outputStream);
        }

        MessageAlerts.getInstance().showMessage("Success", "Download Success", MessageAlerts.MessageType.SUCCESS);
    } catch (Exception e) {
        // Debugging: Log the exception
        e.printStackTrace();
        MessageAlerts.getInstance().showMessage("ERROR", "Download Error", MessageAlerts.MessageType.ERROR);
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Dashboard.Designer.Analythics.Chart.Chart chart1;
    private Dashboard.Swing.Button cmdDownloadExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbAvgLevel;
    private javax.swing.JLabel lbCompleted;
    private javax.swing.JLabel lbCompletion;
    private javax.swing.JLabel lbEarnMonth;
    private javax.swing.JLabel lbMonth;
    private Dashboard.Swing.RoundPanel roundPanel1;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
