package LoginRegister.Service;

import connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class ServiceForgetPassword {

    private final Connection con;
    private final OTPMail otpMail;

    public ServiceForgetPassword() {
        con = DatabaseConnection.getInstance().getConnection();
        otpMail = new OTPMail();
    }

    public void sendPassword(String recipientEmail, String password) {
        String subject = "Your Account Password";
        String messageText = """
                Dear User,

                Your account password is: """ + password + "\n\n"
                + "Best regards,\n"
                + "Your Application Team";

        otpMail.sendEmail(recipientEmail, subject, messageText);
        JOptionPane.showMessageDialog(null, "Password sent successfully to " + recipientEmail);
    }

    public boolean sendPasswordEmail(String recipientEmail, String password) {
        sendPassword(recipientEmail, password);
        return true;
    }

    public String getPasswordByEmail(String recipientEmail) {
        String queryUser = "SELECT password FROM user WHERE email = ? AND status = 'Verified' LIMIT 1";
        String queryAdmin = "SELECT password FROM admin WHERE email = ? LIMIT 1";
        String passwordFromDatabase = null;

        try {
            passwordFromDatabase = getPasswordFromTable(queryUser, recipientEmail);

            if (passwordFromDatabase == null) {
                passwordFromDatabase = getPasswordFromTable(queryAdmin, recipientEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return passwordFromDatabase;
    }

    private String getPasswordFromTable(String query, String email) throws SQLException {
        String passwordFromDatabase = null;

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                passwordFromDatabase = resultSet.getString("password");
            }
        }

        return passwordFromDatabase;
    }
}
