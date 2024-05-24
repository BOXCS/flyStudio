package Dashboard.Designer.Model;

public class ModelDesignerAccount {

    /**
     * @return the designerId
     */
    public int getDesignerId() {
        return designerId;
    }

    /**
     * @param designerId the designerId to set
     */
    public void setDesignerId(int designerId) {
        this.designerId = designerId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the instagram
     */
    public String getInstagram() {
        return instagram;
    }

    /**
     * @param instagram the instagram to set
     */
    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String isStatus() {
        return status;
    }

    public ModelDesignerAccount(int designerId, String username, String email, String password, String instagram, String contentType, String status) {
        this.designerId = designerId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.instagram = instagram;
        this.contentType = contentType;
        this.status = status;
    }

    public ModelDesignerAccount() {
    }

    private int designerId;
    private String username;
    private String email;
    private String password;
    private String instagram;
    private String contentType;
    private String status;

}
