package financialmodeller;

import java.util.Date;

/**
 *
 * @author Dean McGuigan
 */
public class Withdrawal extends Transaction
{
    // used when a withdrawal has been declined
    public Withdrawal(String ID, double amount, Date date, String desc)
    {
        setID(ID);
        setType(TransactionType.Withdrawal);
        setAmount(amount);
        setDate(date);
        setDescription(desc);
    }
    
    // used for a general withdrawal
    public Withdrawal(String ID, double amount, Date date)
    {
        setID(ID);
        setType(TransactionType.Withdrawal);
        setAmount(amount);
        setDate(date);
    }
}
