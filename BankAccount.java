public class BankAccount{

    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println("Checking: " + ba.getCheckingBalance());
        System.out.println("Savings: " + ba.getSavingsBalance());
        System.out.println("Both: " + ba.peekSumBalance());
        System.out.println("Testing bad withdrawal: ");
        ba.withdrawl(false, 10000);
        ba.deposit(true, 10);
        System.out.println("Savings: " + ba.getSavingsBalance());
        ba.withdrawl(true, 5);
        System.out.println("Savings now: " + ba.getSavingsBalance());

    }

    private double checkingBalance;
    private double savingsBalance;

    private static int numAccounts = 0;

    private static double totalMoneySaved = 0.0;

    public BankAccount() {
        numAccounts++;
    }
    
    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double  getSavingsBalance() {
        return this.savingsBalance;
    }

    public void deposit(boolean isSavings, double money) {
        totalMoneySaved += money;
        if(isSavings) {
            this.savingsBalance += money;
        }
        else {
            this.checkingBalance += money;
        }
    }

    public void withdrawl(boolean isSavings, double money) {
        if(isSavings) {
            if(money > this.savingsBalance) { 
                System.out.println("Not enough money!");
            }
            else {
            this.savingsBalance -= money;
            totalMoneySaved -= money;
            }
        }
        else {
            if(money > this.checkingBalance) {
                System.out.println("Not enough money!");
            }
            else { 
                this.checkingBalance -= money;
            totalMoneySaved -= money;
            }
        }
    }

    public double peekSumBalance() {
        return this.checkingBalance + this.savingsBalance;
    }
}