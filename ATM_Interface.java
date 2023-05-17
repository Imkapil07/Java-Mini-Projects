import java.util.*;
class Bank
{
    public static HashMap<Integer,ArrayList<String>>accounts =new HashMap<Integer,ArrayList<String>>();
    public static ArrayList<String> user1=new ArrayList<>();
    public static ArrayList<ArrayList<String>>history =new ArrayList<ArrayList<String>>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){ 
            System.out.println("*********************** ATM INTERFACE *****************************");
            System.out.println("\nUser Menu:\n1.Login for User\n2.Exit \n"); 
            System.out.println("*********************** ATM INTERFACE *****************************");
            System.out.println("Enter Choice: "); 
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    login();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Choice Available in User Menu only");
            }
        }
    }
    public static void login() {
        user1.add("1234");
        user1.add("Kapil");
        user1.add("10000");
        accounts.put(1234, user1);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        int accno=sc.nextInt();
        System.out.println("Enter Pin of Account Number: ");
        int pin=sc.nextInt();
        String pin1=String.valueOf(pin);
        if(accounts.containsKey(accno))
        {
            if(pin1.equals((accounts.get(accno).get(0))))
            {
                System.out.println("Welcome User!!!!!!!!!!!");
                Transaction(accno);
            }
            else
            {
                System.out.println("Please Enter Correct Pin for Account Number."+accno);
            }
        }
        else
            System.out.println("Enter Correct Account Number.");
    }
    public static void Transaction(int accno) {
        Scanner sc=new Scanner(System.in);
        while(true)
        {  
        
            System.out.println("User Menu:\n1.Check Balance\n2.WithDraw\n3.Deposit\n4.Account Transfer\n5.Mini Statement\n6.Exit\nEnter Choice: ");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    balanceCheck(accno);
                    break;
                case 2:
                    withDraw(accno);
                    break;
                case 3:
                    Deposit(accno);
                    break;
                case 4:
                    Transfer(accno);
                    break;
                case 5:
                    miniStatement(accno);
                    break;
                case 6:
                    System.out.println("Thanks For using!!!!!!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Choice Available in User Menu only");
            }
        }
    }
    public static void balanceCheck(int accno) {
        System.out.println("The Balance Amount in your Account is: "+accounts.get(accno).get(2)+"Rs");
    }
    public static void withDraw(int accno) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Amount to Be With Drawn: ");
        int cash=sc.nextInt();
        if(cash<=Integer.parseInt(accounts.get(accno).get(2))){
            System.out.println("Cash Has dispenses Collect Your Ammount of "+cash+"Rs");
            String amount=accounts.get(accno).get(2);
            int amount1=Integer.parseInt(amount);
            amount1-=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=accounts.get(accno);
            details.set(2, amount);
            accounts.put(accno,details);
            ArrayList<String> historyDetails=new ArrayList<>();
            historyDetails.add(String.valueOf(accno));
            historyDetails.add("With Draw");
            historyDetails.add(String.valueOf(cash));
            history.add(historyDetails);
            System.out.println("The Balance Amount in your Account is: "+accounts.get(accno).get(2)+"Rs");
        }
        else{
            System.out.println("Sorry Insufficent Balance In your Account.");
        }
    }
    public static void Deposit(int accno) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Amount to Be Deposit: ");
        int cash=sc.nextInt();
        System.out.println("Your Amount is Credited in your Account of"+cash+"Rs");
            String amount=accounts.get(accno).get(2);
            int amount1=Integer.parseInt(amount);
            amount1+=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=accounts.get(accno);
            details.set(2, amount);
            accounts.put(accno,details);
            ArrayList<String> historyDetails=new ArrayList<>();
            historyDetails.add(String.valueOf(accno));
            historyDetails.add("Deposit");
            historyDetails.add(String.valueOf(cash));
            history.add(historyDetails);
            System.out.println("The Balance Amount in your Account is: "+accounts.get(accno).get(2)+"Rs");
    }
    public static void miniStatement(int accno) {
        System.out.println("------------------------------------------------");
        System.out.println("| Sno. | Account Number | Transaction | Amount | ");
        System.out.println("------------------------------------------------");
        int c=0;
        for(ArrayList<String> i:history)
        {
            if(Integer.parseInt(i.get(0))==accno){
                System.out.print("| "+c+"    ");
                for(int j=0;j<3;j++){
                    if(j==0)
                    System.out.print("| "+i.get(j)+"           ");
                    else if(j==1){
                        if(i.get(j).equals("With Draw"))
                        System.out.print("| "+i.get(j)+"   ");
                        else if(i.get(j).equals("Transfer"))
                        System.out.print("| "+i.get(j)+"    ");
                        else
                        System.out.print("| "+i.get(j)+"     ");
                    }
                    else
                    System.out.print("| "+i.get(j)+"    ");
                }
                System.out.print("|");
                System.out.println();
                c++;
                System.out.println("------------------------------------------------");
            }
        }   
    }
    public static void Transfer(int accno) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Account Number to Transfer Money: ");
        int acc1=sc.nextInt();
        System.out.println("Enter Amount to Be With Drawn: ");
        int cash=sc.nextInt();
        if(cash<=Integer.parseInt(accounts.get(accno).get(2))){
            System.out.println("Ammount of "+cash+"Rs"+"Transfered to "+acc1);
            String amount=accounts.get(accno).get(2);
            int amount1=Integer.parseInt(amount);
            amount1-=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=accounts.get(accno);
            details.set(2, amount);
            accounts.put(accno,details);
            ArrayList<String> historyDetails=new ArrayList<>();
            historyDetails.add(String.valueOf(accno));
            historyDetails.add("Transfer");
            historyDetails.add(String.valueOf(cash));
            history.add(historyDetails);
            System.out.println("The Balance Amount in your Account is: "+accounts.get(accno).get(2)+"Rs");
        }
        else{
            System.out.println("Sorry Insufficent Balance In your Account.");
        }
    }
}
