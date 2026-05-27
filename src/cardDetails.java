public class cardDetails {
    public double principleAmt;
    public double paidAmt;
    public double cardBalance;
    public double APR;
    public double interestRate;
    public double cardMinimum;

    public cardDetails(){
        principleAmt = 6000;
        paidAmt = 0;
        cardBalance = principleAmt - paidAmt;
        APR = 0.18; // percent, annual
        interestRate = 0.18 / 12; // percent, monthly
        cardMinimum = 0.02 * cardBalance; // 2% percent of cardBalance
    }

    /* FIXME:
       Needs to be changed to have the interest paid not affect the principal amt,
       if $90 of the $120 is interest, then the remaining bal should be
       $5970.00, not $5880.00
    */
    public void payMinimum(){
        cardBalance -= cardMinimum; 
        paidAmt = principleAmt - cardBalance;
    }

    public void printBalance(){
        System.out.printf("Remaining Balance: $%.2f\n", cardBalance);
    }
}
