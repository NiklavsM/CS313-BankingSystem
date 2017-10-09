public interface Account {
    String getAccountType();

    double getBalance();

    Details getOwnerDetails();

    void setAccountType(String type);

    void setBalance(double newBalance);

    void setOwnerDetails(Details details);
}
