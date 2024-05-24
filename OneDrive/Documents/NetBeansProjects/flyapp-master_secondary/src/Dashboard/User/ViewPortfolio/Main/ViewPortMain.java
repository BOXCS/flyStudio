package Dashboard.User.ViewPortfolio.Main;

import Dashboard.Swing.ModernScrollBarUI;
import Dashboard.User.ViewPortfolio.Component.PortfolioCard;
import Dashboard.User.ViewPortfolio.Service.ServiceViewPortfolio;
import LoginRegister.Model.ModelUser;
import java.awt.Dimension;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class ViewPortMain extends javax.swing.JPanel {

    private int designerId;
    private List<Integer> designerIds;
    private final List<ModelUser> users;
    private ServiceViewPortfolio serviceView;

    public ViewPortMain(List<ModelUser> users) {
        initComponents();
        setOpaque(false);
        this.users = users;
        serviceView = new ServiceViewPortfolio();
        configureScrollPane();
        body3.setLayout(new BoxLayout(body3, BoxLayout.Y_AXIS));
        addPortfolioCardsToBody();

        // Set "All" sebagai pilihan default
        cbFilterContent.setSelectedItem("All");

        // Menambahkan listener untuk JComboBox cbFilterContent
        cbFilterContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterPortfolioCardsByTypeContent((String) cbFilterContent.getSelectedItem());
            }
        });
    }

    private void configureScrollPane() {
        jScrollPane1.setOpaque(false);
        jScrollPane1.setBackground(null);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.getViewport().setBackground(null);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jScrollPane1.getHorizontalScrollBar().setUI(new ModernScrollBarUI());
        jScrollPane1.getVerticalScrollBar().setUI(new ModernScrollBarUI());

        body3.setOpaque(false);
        body3.setBackground(null);
    }

    private void addPortfolioCardsToBody() {
        for (ModelUser user : users) {
            PortfolioCard portfolioCard = new PortfolioCard(user);
            body3.add(Box.createVerticalStrut(20));
            body3.add(portfolioCard);
        }
    }

    private void filterPortfolioCardsByTypeContent(String typeContent) {
        // Hapus semua komponen dalam body3
        body3.removeAll();

        // Jika "All" dipilih, tambahkan kembali semua portofolio
        if (typeContent.equals("All")) {
            addPortfolioCardsToBody();
        } else {
            // Dapatkan data dari database yang sesuai dengan typeContent
            List<ModelUser> filteredUsers = serviceView.getUsersByTypeContent(typeContent);

            // Tambahkan ulang PortfolioCard berdasarkan data yang sudah difilter
            for (ModelUser user : filteredUsers) {
                PortfolioCard portfolioCard = new PortfolioCard(user);
                body3.add(Box.createVerticalStrut(20));
                body3.add(portfolioCard);
            }
        }

        // Validasi ulang layout
        validate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        body3 = new javax.swing.JPanel();
        roundPanel1 = new Dashboard.Swing.RoundPanel();
        cbFilterContent = new javax.swing.JComboBox<>();

        setOpaque(false);

        jScrollPane1.setOpaque(false);

        javax.swing.GroupLayout body3Layout = new javax.swing.GroupLayout(body3);
        body3.setLayout(body3Layout);
        body3Layout.setHorizontalGroup(
            body3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1352, Short.MAX_VALUE)
        );
        body3Layout.setVerticalGroup(
            body3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(body3);

        roundPanel1.setBackground(new java.awt.Color(0, 0, 0, 50));

        cbFilterContent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Video Editing", "Design Graphic", "3D Modelling" }));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbFilterContent, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbFilterContent, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body3;
    private javax.swing.JComboBox<String> cbFilterContent;
    private javax.swing.JScrollPane jScrollPane1;
    private Dashboard.Swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
