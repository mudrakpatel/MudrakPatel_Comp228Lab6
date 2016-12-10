package exercise1;

 import java.util.ArrayList;
 import java.util.concurrent.Executors;
 import java.util.concurrent.ExecutorService;

/**
 * Created by Mudrak on 12/9/2016.
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account(400.0);
        Transaction transaction1 = new Transaction("withdraw",account1);
        Transaction transaction2 = new Transaction("deposit",account1);
        Transaction transaction3 = new Transaction("withdraw",account1);
        ArrayList<Transaction> transactionArray = new ArrayList<>();
        transactionArray.add(transaction1);
        transactionArray.add(transaction2);
        transactionArray.add(transaction3);

        // create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();

/*        executorService.execute(transaction1);
        executorService.execute(transaction2);

        executorService.shutdown();*/

        /*transaction1.run();
        transaction2.run();*/
        /*------------------------------------------------------------------------------*/
        for(Transaction transaction : transactionArray){
            executorService.execute(transaction);
        }
        System.out.println("Task started, main ends...");


    }
}
