package eu.sig.training.ch04;

// tag::CheckingAccount[]
public class CheckingAccount extends Accounts {
    private static final float INTEREST_PERCENTAGE = 0.01f;
    private Money balance = new Money();
    private int transferLimit = 100;
    
    public Transfer makeTransfer(String counterAccount, Money amount)
        throws BusinessException {
        // 1. Check withdrawal limit:
        if (amount.greaterThan(this.transferLimit)) {
            throw new BusinessException("Limit exceeded!");
        }
        
        Transfer transfer;
        try {
        	transfer = getMakeTransfer(counterAccount, amount);
        	return transfer;
        } catch(BusinessException e) {
        	throw new BusinessException(e.getMessage());
        }
    }

    public void addInterest() {
        Money interest = balance.multiply(INTEREST_PERCENTAGE);
        if (interest.greaterThan(0)) {
            balance.add(interest);
        } else {
            balance.substract(interest);
        }
    }
  
}
// end::CheckingAccount[]
