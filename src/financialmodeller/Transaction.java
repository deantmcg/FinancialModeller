/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financialmodeller;

import java.util.Date;

/**
 *
 * @author Dean McGuigan
 */
public class Transaction
{
    private String id;
    private TransactionType type;
    private double amount;
    private Date date = new Date();
    private String description;
    private boolean success;
    private double balanceAfter;
    
    public String getID()
    {
        return id;
    }
    
    public void setID(String ID)
    {
        this.id = ID;
    }
    
    public TransactionType getType()
    {
        return type;
    }
    
    public void setType(TransactionType _type)
    {
        this.type = _type;
    }
    
    public void setAmount(double _amount)
    {
        this.amount = _amount;
    }
    
    public double getAmount()
    {
        return amount;
    }
    
    public Date getDate()
    {
        return date;
    }
    
    public void setDate(Date _date)
    {
        this.date = _date;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String desc)
    {
        this.description = desc;
    }
    
    public boolean getSuccess()
    {
        return success;
    }
    
    public void setSuccess(boolean _success)
    {
        this.success = _success;
    }
    public Double getBalanceAfter()
    {
        return balanceAfter;
    }
    
    public void setBalanceAfter(double _balAfter)
    {
        this.balanceAfter = _balAfter;
    }
}
