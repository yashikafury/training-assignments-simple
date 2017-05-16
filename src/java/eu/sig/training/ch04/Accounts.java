package eu.sig.training.ch04;

public abstract class Accounts {
    @SuppressWarnings("unused")
    public static CheckingAccount findAcctByNumber(String number) {
        return new CheckingAccount();
    }

    // tag::isValid[]
    public static boolean isValid(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum = sum + (9 - i) * Character.getNumericValue(number.charAt(i));
        }
        return sum % 11 == 0;
    }
    // end::isValid[] 
    
    public void addInterest(Money balance, float interestPercentage) {
		Money interest = balance.multiply(interestPercentage);
        if (interest.greaterThan(0)) {
            balance.add(interest);
        } else {
            balance.substract(interest);
        }
    }
    
    public abstract Transfer makeTransfer(String counterAccount, Money amount) throws BusinessException;
    
    public Transfer getMakeTransfer(String counterAccount, Money amount)
    		throws BusinessException {
    	
    	if (isValid(counterAccount)) {
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount);
            return result;
        } else {
            throw new BusinessException("Invalid account number!!");
        }
    }
}