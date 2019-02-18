package financialmodeller;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Simulation {
    private static Timer timer = new Timer();
    private static Date date = new Date();
    private Calendar cal = Calendar.getInstance();
    private Account account;

    // starts simulation
    public void StartSimulation(Account selectedAccount)
    {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Simulation Running");
                
                // generates a number between 1 or 2
                Random rand = new Random();
                int type = rand.nextInt(2) + 1;
                // generates the amount of transaction
                int amount = rand.nextInt(2000) + 100;
                
                /*
                if random number generated is 1 - make deposit
                if random number generated is 1 - make withdrawal
                */
                if(type == 1)
                    selectedAccount.makeDeposit(amount, cal.getTime());
                else
                    selectedAccount.makeWithdrawal(amount, cal.getTime());
                
                // Adds a month to stored date
                cal.add(Calendar.MONTH, 1);
                date = cal.getTime();
                account = selectedAccount;
            }
        }, 0, 5000);
    }

    // stops simulation
    public Account StopSimulation()
    {
        System.out.println("Simulation Stopped");
        timer.cancel();
        return account;
    }
    
    // returns current date of simulation
    public Date getDate()
    {
        return date;
    }
    
    // returns updated account
    public Account getAccount()
    {
        return account;
    }
}
