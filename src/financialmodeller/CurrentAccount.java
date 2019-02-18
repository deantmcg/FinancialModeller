package financialmodeller;

import java.util.Date;

/**
 *
 */
public class CurrentAccount extends Account
{
    public CurrentAccount(AccountHolder holder, Date date, int balance)
    {
        setAccountType(AccountType.Current);
        setHolder(holder);
        setOverdraft(-1000);
        setMinBalance(1);
        Deposit deposit = new Deposit(holder.getID(), balance, date, "New Account Created");
    }
}
