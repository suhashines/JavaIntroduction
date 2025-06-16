package JavaClass.BankSystem;

public class Branch {

    private int id;
    private String name;
    private Account []  accounts;
    private int accountCount;
	// add your code here
	// you are allowed to add variables here
    // there can be at most 20 branches  

    // you are not allowed to write any other constructor
    private static final int TOTAL_BRANCHES = 20 ;

    private static int branchCount = 0 ;

    private static Branch[]branches = new Branch[TOTAL_BRANCHES];
    public Branch(int id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new Account[10];
        // add your code here
        branches[branchCount++] = this ;
    }

    public static void transferBalance(Account account, Account account1, double money) {
        account.addBalance(-money);
        account1.addBalance(money);
    }

    public static void printAllBranchesInfo() {

        for(int i=0;i<branchCount;i++){
            branches[i].printBranchInfo();
        }

    }

    private void printBranchInfo(){
        System.out.println("Branch Id "+id+ "  Branch Name : "+name);
        for(int i=0;i<accountCount;i++){
            System.out.println(accounts[i].getNumber()+"  "+accounts[i].getCustomer()+"  "+accounts[i].getBalance());
        }
    }

    // you are not allowed to modify this method
    public void addAccount(Account a) {
        accounts[accountCount++] = a;
    }

    public double getBranchBalance() {
        double sum =0 ;
        for(int i=0;i<accountCount;i++){
            sum += accounts[i].getBalance();
        }

        return sum;
    }

    public Account getMinBalanceAccount() {

        Account minAccount = null ;

        double minBalance = Double.MAX_VALUE ; //infinity

        for(int i=0;i<accountCount;i++){

            Account account = accounts[i];

            if(account.getBalance()<minBalance){
                minBalance = account.getBalance();
                minAccount = account ;
            }
        }

        return minAccount ;
    }

    // add your code here



}
