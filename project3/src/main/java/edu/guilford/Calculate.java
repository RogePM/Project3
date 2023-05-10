package edu.guilford;

public class Calculate {
    private double bill;
    private double tip;
    private double total;



    // create constructor default
    public Calculate() {
        bill = 0;
        tip = 0;
        total = 0;
    }

    public Calculate(double bill, double tip, double total) {
        // create constructor
        this.bill = bill;
        this.tip = tip;
        this.total = total;
    
        // create getters and setters

    }
    //method to calculate the tip 
    public double calculateTip(double bill, double tip) {
        double tipAmount = bill * (tip / 100);
        return tipAmount;
    }
    //method to calculate the total
    public double calculateTotal(double bill, double tip) {
        double totalAmount = bill + tip;
        return totalAmount;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
   
    


    //to string method
    @Override
    public String toString() {
        return "Calculate{" +
                "bill=" + bill +
                ", tip=" + tip +
                ", total=" + total +
                '}';
    }
}
