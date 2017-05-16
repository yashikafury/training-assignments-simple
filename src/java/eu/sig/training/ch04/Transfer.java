package eu.sig.training.ch04;

public class Transfer {
    CheckingAccount counterAccount;

    @SuppressWarnings("unused")
    public Transfer(Accounts acct1, CheckingAccount acct2, Money m) {}

//    @SuppressWarnings("unused")
//    public Transfer(SavingsAccount acct1, CheckingAccount acct2, Money m) {}

    public CheckingAccount getCounterAccount() {
        return this.counterAccount;
    }
}
