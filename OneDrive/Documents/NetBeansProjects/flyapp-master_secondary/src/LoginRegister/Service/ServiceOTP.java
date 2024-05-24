package LoginRegister.Service;

import connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceOTP {

    private final Connection con;
    private final OTPMail otpMail;

    public ServiceOTP() {
        con = DatabaseConnection.getInstance().getConnection();
        otpMail = new OTPMail();
    }

    public boolean sendOtpEmail(String recipientEmail) {
        try {
            int userId = getUserIdByEmail(recipientEmail);
            if (userId > 0) {
                String otp = otpMail.generateOTP();
                storeOTP(userId, otp);
                String messageText = "Dear User,\n\nYour OTP code is: " + otp + "\n\nBest regards,\nYour Application Team";
                otpMail.sendEmail(recipientEmail, "Your OTP Code", messageText);
                return true;
            } else {
                System.out.println("Email not found in the database.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void storeOTP(int userId, String otp) throws SQLException {
        String query = "INSERT INTO otp (userID, otp_code, expiration_time) VALUES (?, ?, DATE_ADD(NOW(), INTERVAL 30 MINUTE))";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, otp);
            preparedStatement.executeUpdate();
        }
    }

    private int getUserIdByEmail(String email) throws SQLException {
        String queryUser = "SELECT userID FROM user WHERE email = ? AND status = 'Verified' LIMIT 1";
        String queryAdmin = "SELECT adminID FROM admin WHERE email = ? LIMIT 1";
        String queryDesigner = "SELECT designer_id FROM designer WHERE email = ? LIMIT 1";

        try (PreparedStatement userStmt = con.prepareStatement(queryUser)) {
            userStmt.setString(1, email);
            ResultSet userResultSet = userStmt.executeQuery();

            if (userResultSet.next()) {
                return userResultSet.getInt("userID");
            }
        }

        try (PreparedStatement adminStmt = con.prepareStatement(queryAdmin)) {
            adminStmt.setString(1, email);
            ResultSet adminResultSet = adminStmt.executeQuery();

            if (adminResultSet.next()) {
                return adminResultSet.getInt("adminID");
            }
        }

        try (PreparedStatement designerStmt = con.prepareStatement(queryDesigner)) {
            designerStmt.setString(1, email);
            ResultSet designerResultSet = designerStmt.executeQuery();

            if (designerResultSet.next()) {
                return designerResultSet.getInt("designer_id");
            }
        }

        return -1;  // If the email is not found in any table
    }

    public boolean validateOTP(String email, String otp) {
        String query = "SELECT otp_code FROM otp JOIN user ON otp.userID = user.userID WHERE user.email = ? AND otp_code = ? AND expiration_time > NOW()";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, otp);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
