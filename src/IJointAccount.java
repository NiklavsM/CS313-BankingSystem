import java.util.List;

public interface IJointAccount {
    void addToAccountHolders(BankCustomer bc);
    List getAccountHolders();
    void removeFromAccountHolders(BankCustomer bc);
}
