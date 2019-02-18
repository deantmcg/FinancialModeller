package financialmodeller;

import java.util.ArrayList;

public class FinancialModeller
{
    public static void main(String[] args)
    {
        ArrayList<Account> accounts = new ArrayList<Account>();
        AccountViewer viewer = new AccountViewer();
        viewer.show();
    }
}
