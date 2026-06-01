// need to fix this

public class cardDetails {

    public double principleAmt; // original loan amount
    public double paidAmt; // total paid, including interest
    public double cardBalance; // current balance of the card
    public double APR; // yearly interest rate. 18%
    public double interestRate; // monthly interest rate
    public double cardMinimum; // minimum rate * balance of card
    public double minimumRate; // percent of balance needed for minimum, 2%
    public double interestPaid; // amount of $ in the minimum payment that goes to interest
    public double principalPaid; // amount og $ in the min payment that lowers the balance

    public cardDetails(){

        principleAmt = 6000;
        paidAmt = 0;
        cardBalance = principleAmt - paidAmt; // might be a problem not sure is paidAMT is needed
        APR = 0.18; // percent, annual
        interestRate = APR / 12; // percent, monthly
        minimumRate = 0.02; // percent
    }



   public void payMinimum()
   {
    payPayment(0);

   }
    public void payPayment(double extrapayment) {
     cardMinimum = minimumRate * cardBalance; // 2% percent of cardBalance
        if (cardMinimum < 25 && cardBalance < 25)
        { 
            cardMinimum = cardBalance;
        }
        else if (cardMinimum < 25)
        {
            cardMinimum = 25;
        }

        interestPaid = interestRate * cardBalance;
        principalPaid = cardMinimum - interestPaid;

        principalPaid += extrapayment;

         if (principalPaid > cardBalance)
          {
            principalPaid = cardBalance; // can't pay more than the remaining balance
        }

        cardBalance -= principalPaid; 

        paidAmt += cardMinimum;
    }

    public void printBalance()
    {
        System.out.printf("Remaining Balance: $%.2f\n", cardBalance);
    }

    public void printTotalPaid()
    {
        System.out.printf("Total Amount Paid: $%.2f\n", paidAmt);
    }

    
}



