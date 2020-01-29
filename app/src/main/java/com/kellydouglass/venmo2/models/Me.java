package com.kellydouglass.venmo2.models;


public class Me {

    private String paidDate;
    private double amountPaid;
    private String paidTo;
    private String paidFrom;
    private String paymentText;


    public Me(String paidDate, double amountPaid, String paidTo, String paidFrom, String paymentText) {
        this.paidDate = paidDate;
        this.amountPaid = amountPaid;
        this.paidTo = paidTo;
        this.paidFrom = paidFrom;
        this.paymentText = paymentText;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getPaidTo() {
        return paidTo;
    }

    public String getPaidFrom() {
        return paidFrom;
    }

    public String getPaymentText() {
        return paymentText;
    }
}
