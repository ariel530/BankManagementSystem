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
public class Transfer extends Transactions {

    private String recieverName;

    public Transfer(int id, String senderAccountNumber, String recieverName, Date sendingDate, Time sendingTime, double transactionAmount) {
        super(id, senderAccountNumber, sendingDate, sendingTime, "TRANSFER", transactionAmount);
        this.recieverName = recieverName;
    }

    @Override
    public String getTransactionType() {
        return "TRANSFER";
    }

    public String getRecieverName() {
        return recieverName;
    }

    public void setRecieverName(String recieverName) {
        this.recieverName = recieverName;
    }

    @Override
    public String toString()
    {
        return  String.format("%-8s %-20s %-20s %-20s %-20s %-10s %-5s", ""+super.getId(),super.getSenderAccountNumber(),getRecieverName(),""+super.getSendingDate().toString(),""+super.getSendingTime(),getTransactionType(),""+super.getTransactionAmount());
    }
}
