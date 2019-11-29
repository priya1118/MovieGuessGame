public class BankAccount {
    private String account;
    private long balance;
    public void createAccount(String accountid){
        account=accountid;
    }
    public String getAccount(){
        return account;
    }
}
