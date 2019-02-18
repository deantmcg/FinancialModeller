/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financialmodeller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dean McGuigan
 */
public class AccountHolder
{
    private String id;
    private String firstname;
    private String surname;
    private Date dob;
    
    public AccountHolder(String _firstname, String _surname, Date _dob)
    {
        this.firstname = _firstname.toUpperCase();
        this.surname = _surname.toUpperCase();
        this.dob = _dob;
        DateFormat df = new SimpleDateFormat("ddMMyy");
        
        // genereates id from users' forename, surname and DOB
        this.id = (firstname.charAt(0) + surname.substring(0, 3) + df.format(dob)).toLowerCase();
    }
    
    public AccountHolder(String _id, String _firstname, String _surname, Date _dob)
    {
        this.id = _id;
        this.firstname = _firstname;
        this.surname = _surname;
        this.dob = _dob;
    }
    
    public String getID()
    {
        return id;
    }
    
    public String getFullname()
    {
        return firstname + " " + surname;
    }
    
    public String getFirstname()
    {
        return firstname;
    }
    
    public String getSurname()
    {
        return surname;
    }
    
    public Date getDob()
    {
        return dob;
    }
}
