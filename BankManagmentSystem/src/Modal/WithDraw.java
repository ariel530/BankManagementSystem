/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author SSC
 */
public class WithDraw extends Transactions{
    public WithDraw(int id, String senderAccountNumber, Date sendingDate, Time sendingTime, double transactionAmount) {
        super(id, senderAccountNumber, sendingDate, sendingTime, "WITHDRAW", transactionAmount);
    }

    @Override
    public String getTransactionType() {
        return "WITHDRAW";
    }
    
     @Override
    public String toString()
    {
        return  String.format("%-8s %-20s %-20s %-20s %-20s %-10s %-5s", ""+super.getId(),super.getSenderAccountNumber(),"",""+super.getSendingDate().toString(),""+super.getSendingTime(),getTransactionType(),""+super.getTransactionAmount());
    }
}
