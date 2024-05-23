package Admin.ViewOrder.Service;

import connection.DatabaseConnection;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import java.util.Map;
import javax.swing.JFileChooser;
import net.sf.jasperreports.engine.JasperExportManager;
//import notif.Mail.MailNotification;

public class ServiceViewOrder {

    public static void fetchActiveOrders(DefaultTableModel model) {
        model.setRowCount(0); // Menghapus semua baris yang ada pada tabel

        try {
            // Query untuk mendapatkan data dari tabel transaction dengan status Active dan username pengguna yang login
            String sql = "SELECT transaction_number, username, product_name, level, designer, created_at, amount, status FROM transaction WHERE status = 'Active'";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String number = r.getString("transaction_number");
                String username = r.getString("username");
                String product = r.getString("product_name");
                String level = r.getString("level");
                String designer = r.getString("designer");
                Timestamp created_at = r.getTimestamp("created_at");
                double amount = r.getDouble("amount");
                String status = r.getString("status");

                // Mengubah format tanggal menjadi "Feb 11, 2024"
                String formattedDate = new SimpleDateFormat("MMM dd, yyyy").format(created_at);

                // Menambahkan data ke dalam tabel
                model.addRow(new Object[]{number, username, product, level, designer, formattedDate, "$" + amount, status});
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fetchWaitingOrders(DefaultTableModel model) {
        model.setRowCount(0); // Menghapus semua baris yang ada pada tabel

        try {
            // Query untuk mendapatkan data dari tabel transaction dengan status Active dan username pengguna yang login
            String sql = "SELECT transaction_number, username, product_name, level, designer, created_at, amount, status FROM transaction WHERE status = 'Waiting'";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String number = r.getString("transaction_number");
                String username = r.getString("username");
                String product = r.getString("product_name");
                String level = r.getString("level");
                String designer = r.getString("designer");
                Timestamp created_at = r.getTimestamp("created_at");
                double amount = r.getDouble("amount");
                String status = r.getString("status");

                // Mengubah format tanggal menjadi "Feb 11, 2024"
                String formattedDate = new SimpleDateFormat("MMM dd, yyyy").format(created_at);

                // Menambahkan data ke dalam tabel
                model.addRow(new Object[]{number, username, product, level, designer, formattedDate, "$" + amount, status});
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fetchPendingOrders(DefaultTableModel model) {
        model.setRowCount(0); // Menghapus semua baris yang ada pada tabel

        try {
            // Query untuk mendapatkan data dari tabel transaction dengan status Active dan username pengguna yang login
            String sql = "SELECT transaction_number, username, product_name, level, designer, created_at, amount, status FROM transaction WHERE status = 'Pending'";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String number = r.getString("transaction_number");
                String username = r.getString("username");
                String product = r.getString("product_name");
                String level = r.getString("level");
                String designer = r.getString("designer");
                Timestamp created_at = r.getTimestamp("created_at");
                double amount = r.getDouble("amount");
                String status = r.getString("status");

                // Mengubah format tanggal menjadi "Feb 11, 2024"
                String formattedDate = new SimpleDateFormat("MMM dd, yyyy").format(created_at);

                // Menambahkan data ke dalam tabel
                model.addRow(new Object[]{number, username, product, level, designer, formattedDate, "$" + amount, status});
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fetchFinishedOrders(DefaultTableModel model) {
        model.setRowCount(0); // Menghapus semua baris yang ada pada tabel

        try {
            // Query untuk mendapatkan data dari tabel transaction dengan status Active dan username pengguna yang login
            String sql = "SELECT transaction_number, username, product_name, level, designer, created_at, amount, status FROM transaction WHERE status = 'Finished'";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String number = r.getString("transaction_number");
                String username = r.getString("username");
                String product = r.getString("product_name");
                String level = r.getString("level");
                String designer = r.getString("designer");
                Timestamp created_at = r.getTimestamp("created_at");
                double amount = r.getDouble("amount");
                String status = r.getString("status");

                // Mengubah format tanggal menjadi "Feb 11, 2024"
                String formattedDate = new SimpleDateFormat("MMM dd, yyyy").format(created_at);

                // Menambahkan data ke dalam tabel
                model.addRow(new Object[]{number, username, product, level, designer, formattedDate, "$" + amount, status});
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fetchCancelledOrders(DefaultTableModel model) {
        model.setRowCount(0); // Menghapus semua baris yang ada pada tabel

        try {
            // Query untuk mendapatkan data dari tabel transaction dengan status Active dan username pengguna yang login
            String sql = "SELECT transaction_number, username, product_name, level, designer, created_at, amount, status FROM transaction WHERE (status = 'Cancelled' OR status = 'Reported Cancel' OR status = 'Denied Cancel' OR status = 'Accepted Cancel')";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String number = r.getString("transaction_number");
                String username = r.getString("username");
                String product = r.getString("product_name");
                String level = r.getString("level");
                String designer = r.getString("designer");
                Timestamp created_at = r.getTimestamp("created_at");
                double amount = r.getDouble("amount");
                String status = r.getString("status");

                // Mengubah format tanggal menjadi "Feb 11, 2024"
                String formattedDate = new SimpleDateFormat("MMM dd, yyyy").format(created_at);

                // Menambahkan data ke dalam tabel
                model.addRow(new Object[]{number, username, product, level, designer, formattedDate, "$" + amount, status});
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fetchLateOrders(DefaultTableModel model) {
        model.setRowCount(0); // Menghapus semua baris yang ada pada tabel

        try {
            // Query untuk mendapatkan data dari tabel transaction dengan status Active dan username pengguna yang login
            String sql = "SELECT transaction_number, username, product_name, level, designer, created_at, amount, status FROM transaction WHERE (status = 'Late' OR status = 'Refund Requested')";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                String number = r.getString("transaction_number");
                String username = r.getString("username");
                String product = r.getString("product_name");
                String level = r.getString("level");
                String designer = r.getString("designer");
                Timestamp created_at = r.getTimestamp("created_at");
                double amount = r.getDouble("amount");
                String status = r.getString("status");

                // Mengubah format tanggal menjadi "Feb 11, 2024"
                String formattedDate = new SimpleDateFormat("MMM dd, yyyy").format(created_at);

                // Menambahkan data ke dalam tabel
                model.addRow(new Object[]{number, username, product, level, designer, formattedDate, "$" + amount, status});
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String loadCancellationReason(String transactionNumber) {
        String reason = "";
        try {
            String sql = "SELECT reason FROM canceltransaction WHERE transaction_number = ?";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, transactionNumber);
            ResultSet r = p.executeQuery();

            if (r.next()) {
                reason = r.getString("reason");
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reason;
    }

    public static String loadCancellationFootageLink(String transactionNumber) {
        String footageLink = "";
        try {
            String sql = "SELECT footage_link FROM footage WHERE transaction_number = ?";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, transactionNumber);
            ResultSet r = p.executeQuery();

            if (r.next()) {
                footageLink = r.getString("footage_link");
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return footageLink;
    }

    public static String loadCancellationInformation(String transactionNumber) {
        String information = "";
        try {
            String sql = "SELECT information FROM footage WHERE transaction_number = ?";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, transactionNumber);
            ResultSet r = p.executeQuery();

            if (r.next()) {
                information = r.getString("information");
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return information;
    }

    public static String loadCancellationDesigner(String transactionNumber) {
        String designer = "";
        try {
            String sql = "SELECT designer FROM footage WHERE transaction_number = ?";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, transactionNumber);
            ResultSet r = p.executeQuery();

            if (r.next()) {
                designer = r.getString("designer");
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return designer;
    }

    public static String loadCancellationUserEmail(String transactionNumber) {
        String userEmail = "";
        try {
            String sql = "SELECT user_email FROM footage WHERE transaction_number = ?";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, transactionNumber);
            ResultSet r = p.executeQuery();

            if (r.next()) {
                userEmail = r.getString("user_email");
            }

            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEmail;
    }

    public boolean updateTransactionStatusLate(String transactionNumber, String status) {
        try {
            String sql = "UPDATE transaction SET status = ? WHERE transaction_number = ?";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, status);
            p.setString(2, transactionNumber);
            int rowsUpdated = p.executeUpdate();
            p.close();
            return rowsUpdated > 0; // Mengembalikan true jika ada baris yang diperbarui
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateReport(String transactionNumber, String status) {
        try {
            String sql = "UPDATE transaction SET status = ? WHERE transaction_number = ?";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, status);
            p.setString(2, transactionNumber);
            int rowsUpdated = p.executeUpdate();
            p.close();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
