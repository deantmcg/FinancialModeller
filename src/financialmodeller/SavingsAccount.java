package financialmodeller;

import java.util.Date;

/**
 *
 * @author Dean McGuigan
 */
public class SavingsAccount extends Account
{
    public SavingsAccount(AccountHolder holder, Date date, int balance)
    {
        setAccountType(AccountType.Savings);
        setHolder(holder);
        setOverdraft(0);
        setMinBalance(100);
        setMaxWithdrawals(2); // per year
        Deposit deposit = new Deposit(holder.getID(), balance, date, "New Account Created");
    }
}
