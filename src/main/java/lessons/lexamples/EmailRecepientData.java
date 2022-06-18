package lessons.lexamples;

public class EmailRecepientData {
    private String emailId;
    private String firstName;
    private String lastName;
    private String couponCode;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @Override
    public String toString() {
        return "Email Id=" + emailId + ", First Name=" + firstName + " ,"
                + " Last Name=" + lastName + ", Coupon Code=" + couponCode + "";
    }

}
