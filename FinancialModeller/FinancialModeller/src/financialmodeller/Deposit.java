package financialmodeller;

import java.util.Date;

/**
 *
 * @author Dean McGuigan
 */
public class Deposit extends Transaction
{
    // used for opening an account
    public Deposit(String ID, double amount, Date date, String desc)
    {
        setID(ID);
        setType(TransactionType.Deposit);
        setAmount(amount);
        setDate(date);
        setDescription(desc);
    }
    
    // used for a general 
    public Deposit(String ID, double amount, Date date)
    {
        setID(ID);
        setType(TransactionType.Deposit);
        setAmount(amount);
        setDate(date);
    }
}
