package financialmodeller;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Report {
    private static final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    public static String GetHighestBal(ArrayList<Transaction> transactions)
    {
        double highest = 0;
        String date = "Error";
        
        // gets the lowest transaction and stores its details
        for(int i=0; i < transactions.size(); i++)
        {
            if(transactions.get(i).getBalanceAfter() > highest)
            {
                highest = transactions.get(i).getBalanceAfter();
                date = FormatDate(transactions.get(i).getDate());
            }
        }
        // returns the string ready to be displayed on the report
        return formatter.format(highest) + " on " + date;
    }

    public static String GetLowestBal(ArrayList<Transaction> transactions)
    {
        double lowest = transactions.get(0).getBalanceAfter();
        String date = FormatDate(Calendar.getInstance().getTime());
        
        // gets the lowest transaction and stores its details
        for(int i=1; i < transactions.size(); i++)
        {
            if(transactions.get(i).getBalanceAfter() < lowest)
            {
                lowest = transactions.get(i).getBalanceAfter();
                date = FormatDate(transactions.get(i).getDate());
            }
        }
        // returns the string ready to be displayed on the report
        return formatter.format(lowest) + " on " + date;
    }

    private static String FormatDate(Date d)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(d);
    }
}
