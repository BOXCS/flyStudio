package Admin.analytic.Model;

public class DesignerAnalytics {

    private String username;
    private String level;
    private double monthlyIncome;
    private String month;

    public DesignerAnalytics(String username, String level, double monthlyIncome, String month) {
        this.username = username;
        this.level = level;
        this.monthlyIncome = monthlyIncome;
        this.month = month;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
