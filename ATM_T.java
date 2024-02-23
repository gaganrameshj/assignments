import java.util.Scanner;

public class ATM_T
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter card number : ");
        String cardnumber = scanner.nextLine();
        System.out.print("Please enter expiry month : ");
        int expirymonth = scanner.nextInt();
        System.out.print("Please enter expiry year : ");
        int expiryyear = scanner.nextInt();
        if(cardVerify(cardnumber,expirymonth,expiryyear))
        {
            System.out.println("Entered card is Valid!");
            System.out.println("Please enter the PIN : ");
            int pin = scanner.nextInt();
            if(pinverify(pin))
            {
                System.out.println("Entered pin is correct!");
                System.out.println("1.Money Withdrawal.\n2.Account Balance.\n3.Deposit\n4.Change PIN\n5.Transfer Funds\n6.Update User information\n7.Change Language");
                int choice = scanner.nextInt();
                choiceSelection(choice, pin);
            }
            else
            {
                System.out.println("Entered pin is not correct!");
            }
        }
        else {
            System.out.println("Entered card is Invalid!");
        }
    }

    public static Boolean cardVerify(String cardnumber, int expirymonth, int expiryyear)
    {
        if(cardnumber.length()==12)
        {
            String saved = "112233445566";
            if (cardnumber.equals("112233445566"))
            {
                if (expirymonth==05 && expiryyear==27)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean pinverify(int pin)
    {
        if (pin == 555)
        {
            return true;
        }
        return false;
    }

    public static void choiceSelection(int choice, int pin)
    {
        Scanner scanner = new Scanner(System.in);
        long balance = 2500000;
        String name = "Gagan";
        String phoneNumber = "9999000007";
        switch(choice)
        {
            case 1:
                System.out.println("Enter withdrawal amount: ");
                long withdrawal = scanner.nextLong();
                if (withdrawal<=balance)
                {
                    System.out.println("New Account Balance : "+(balance-withdrawal) );
                    System.out.println("Please collect the cash!");
                }
                else
                {
                    System.out.println("Insufficient balance!");
                }
                break;
            case 2:
                System.out.println("Account Balance is "+ balance);
                break;
            case 3:
                System.out.println("Enter the amount you want to deposit :");
                long depo = scanner.nextLong();
                long newbalance = balance + depo;
                System.out.println("Money Deposited!\nNew Account Balance is "+ newbalance);
                balance = newbalance;
                break;
            case 4:
                System.out.println("Please enter the new PIN : ");
                int newPin = scanner.nextInt();
                if (newPin==pin)
                {
                    System.out.println("Please Enter a different PIN : ");
                }
                else
                {
                    pin=newPin;
                    System.out.println("PIN Updated");
                }
                break;
            case 5:
                System.out.println("Please enter the recipient account number :");
                String recipientAC = scanner.nextLine();
                System.out.println("Please enter the amount too be transferred : ");
                long amount = scanner.nextLong();
                if (amount<=balance)
                {
                    System.out.println("Amount "+ amount + " Rupees is transferred to A/C number "+recipientAC);
                    balance = balance-amount;
                }
                else
                {
                    System.out.println("Amount is greater than your account balance");
                }
                break;
            case 6:
                System.out.println("Press 1 to change Name\nPress 2 to change phone number :");
                int change = scanner.nextInt();
                if (change==1)
                {
                    System.out.println("Please enter new name :");
                    name= scanner.nextLine();
                    System.out.println("Name has been updated to "+name);
                } else if (change==2)
                {
                    System.out.println("Please enter new number :");
                    phoneNumber= scanner.nextLine();
                    System.out.println("Phone number has been updated to "+phoneNumber);
                }
                else {
                    System.out.println("Please enter valid option");
                }
                break;
            case 7:
                System.out.println(displayLanguageOptions());
                int languageChoice = scanner.nextInt();
                changeLanguage(languageChoice);
                break;
            default:
                System.out.println("Please enter valid option!");
        }
    }

    public static String displayLanguageOptions()
    {
        return("Default language is English.\n \nChoose a different language: \n1. Kannada\n2. Hindi\n3. Español");
    }

    public static boolean changeLanguage(int languageChoice)
    {
        boolean languageChanged = false;

        switch (languageChoice) {
            case 1:
                System.out.println("ಭಾಷೆಯನ್ನು ಕನ್ನಡಕ್ಕೆ ಬದಲಾಯಿಸಲಾಗಿದೆ");
                languageChanged = true;
                break;
            case 2:
                System.out.println("भाषा बदलकर हिंदी कर दी गई है");
                languageChanged = true;
                break;
            case 3:
                System.out.println("Lengua establecida en Español");
                languageChanged = true;
                break;
            default:
                System.out.println("Invalid language choice");
        }

        return languageChanged;
    }
}
