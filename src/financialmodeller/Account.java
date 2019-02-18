package financialmodeller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Dean McGuigan
 */
public class Account
{
    private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private final Date dateCreated = new Date();
    private AccountType accountType;
    private AccountHolder holder;
    private double balance = 0;
    private double minBalance;
    private double overdraft;
    private int maxWithdrawals;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    
    public Date getDateCreated()
    {
        return dateCreated;
    }
    
    public AccountType getAccountType()
    {
        return accountType;
    }
    
    public void setAccountType(AccountType _accountType)
    {
        this.accountType = _accountType;
    }
    
    public AccountHolder getHolder()
    {
        return holder;
    }
    
    public void setHolder(AccountHolder _holder)
    {
        this.holder = _holder;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public void setBalance(double _balance)
    {
        this.balance = _balance;
    }
    
    // Will update the balance - used for deposits and withdrawals
    public void updateBalance(double amount)
    {
        this.balance += amount;
    }
    
    public double getMinBalance()
    {
        return minBalance;
    }
    
    public void setMinBalance(double _minBalance)
    {
        this.minBalance = _minBalance;
    }
            
    public double getAvailable()
    {
        return (overdraft + minBalance);
    }
    
    public double getOverdraft()
    {
        return overdraft;
    }
    
    public void setOverdraft(double _overdraft)
    {
        this.overdraft = _overdraft;
    }
    
    public int getMaxWithdrawals()
    {
        return maxWithdrawals;
    }
    
    public void setMaxWithdrawals(int _maxWithdrawals)
    {
        this.maxWithdrawals = _maxWithdrawals;
    }
    
    public ArrayList<Transaction> getTransactionss()
    {
        return transactions;
    }
    
    // adds transaction to stored transaction array list
    public void addTransaction(Transaction transaction)
    {
        this.transactions.add(transaction);
    }
    
    public Transaction makeWithdrawal(double amount, Date date)
    {
        Transaction withdrawal = new Withdrawal(holder.getID(), amount, date);
        int withdrawalsSinceJanuary = 0;
        
        /* 
        sets calender variable to January 1st of year matching date varaiable
        used for calculating transactions in the last year
        */
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        
        /* 
        calculates how many transactions have been made since 
        January of the year stored in the date variable
        */
        for (Transaction t : transactions)
        {
            if (t.getDate().after(cal.getTime()) && t.getType() == TransactionType.Withdrawal && t.getSuccess())
            {
                withdrawalsSinceJanuary++;
            }
        }
        
        // declines transaction if maximum withdrawals have been exceeded
        if (getMaxWithdrawals() != 0 && (withdrawalsSinceJanuary >= getMaxWithdrawals()))
        {
            withdrawal.setBalanceAfter(balance);
            withdrawal.setSuccess(false);
            withdrawal.setDescription("Maximum yearly withdrawals reached");
        }
        else
        {
            if ((balance - amount) > getAvailable())
            {
                // carries out transaction
                updateBalance(amount * -1);
                withdrawal.setBalanceAfter(balance);
                withdrawal.setSuccess(true);
                withdrawal.setDescription("Withdrawal of £" + Double.toString(amount) + " successful. New balance £" + 
                        Double.toString(getBalance()));
            }
            else
            {
                // rejects transaction if there are insufficient funds available
                withdrawal.setBalanceAfter(balance);
                withdrawal.setSuccess(false);
                withdrawal.setDescription("Insufficient funds");
            }
        }
        
        transactions.add(withdrawal);
        return withdrawal;
    }
    
    public Transaction makeDeposit(double amount, Date date)
    {
        Transaction deposit = new Deposit(holder.getID(), amount, date);
        transactions.add(deposit);
        updateBalance(amount);
        deposit.setSuccess(true);
        deposit.setDescription("Deposit of £" + Double.toString(amount) + " successful. New balance £" + 
                        Double.toString(getBalance()));
        
        /* Calculates the reward or interest for this deposit depending on
           the account type
        */
        if(getAccountType() == AccountType.Current)
            calculateReward(deposit);
        else if (getAccountType() == AccountType.Savings)
            calculateInterest(deposit);
        
        deposit.setBalanceAfter(balance);
        return deposit;
    }
    
    // used for current accounts - adds £10 if £500 has been deposited
    private void calculateReward(Transaction deposit)
    {
        if (deposit.getAmount() >= 500)
            updateBalance(10);
    }
    
    // used for savings accounts - adds 3% to each deposit
    private void calculateInterest(Transaction deposit)
    {
        double interest = getBalance() * 0.03;
        updateBalance(interest);
    }
}
