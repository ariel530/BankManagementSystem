/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import Common.StaticData;
import Modal.Account;
import Modal.AccountType;
import Modal.Admin;
import Modal.Client;
import Modal.Complains;
import Modal.Deposit;
import Modal.Login;
import Modal.Transactions;
import Modal.Transfer;
import Modal.WithDraw;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author SSC
 */
public class DatabaseQueries {

    public static Connection createConnection() {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/bankmanagementsystem", "bank", "bank");

        } catch (Exception ex) {
            System.out.println("Connection Error " + ex.getMessage());
        }
        return con;
    }

    public static Login validateUserInfo(String username, String password) {
        Login tempUser = null;
        try {
            Connection tempCon = createConnection();
            String query = "select * from login where username=? and password=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                if (rst.getString(5).compareTo("ADMIN") == 0) {
                    tempUser = new Admin(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
                } else {
                    tempUser = new Client(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
                }
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("validateUserInfo :: " + e.getMessage());
        }
        return tempUser;
    }

    public static Login getUserByUsername(String username) {
        Login tempUser = null;
        try {
            Connection tempCon = createConnection();
            String query = "select * from login where username=? ";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                if (rst.getString(5).compareTo("ADMIN") == 0) {
                    tempUser = new Admin(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
                } else {
                    tempUser = new Client(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
                }
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getUserByUsername :: " + e.getMessage());
        }
        return tempUser;
    }

    public static ArrayList<Login> getAllClientData() {
        ArrayList<Login> data = new ArrayList<Login>();
        try {
            Connection tempCon = createConnection();
            String query = "select * from login where USERTYPE=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, "CLIENT");
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                data.add(new Login(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAllClientData :: " + e.getMessage());
        }
        return data;
    }

    public static ArrayList<AccountType> getAllAccountType() {
        ArrayList<AccountType> data = new ArrayList<AccountType>();
        try {
            Connection tempCon = createConnection();
            String query = "select * from accounttype ";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                data.add(new AccountType(rst.getInt(1), rst.getString(2)));
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAllAccountType :: " + e.getMessage());
        }
        return data;
    }

    public static AccountType getAccountTypeById(int id) {
        AccountType data = null;
        try {
            Connection tempCon = createConnection();
            String query = "select * from accounttype where id=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                data = (new AccountType(rst.getInt(1), rst.getString(2)));
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAccountTypeById :: " + e.getMessage());
        }
        return data;
    }

    public static AccountType getAccountTypeByName(String name) {
        AccountType data = null;
        try {
            Connection tempCon = createConnection();
            String query = "select * from accounttype where name=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                data = (new AccountType(rst.getInt(1), rst.getString(2)));
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAccountTypeByName :: " + e.getMessage());
        }
        return data;
    }

    public static int insertClientData(Client client) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            String query = "insert into login values(?,?,?,?,?)";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, client.getUserName());
            stmt.setString(2, client.getPassword());
            stmt.setString(3, client.getFirstName());
            stmt.setString(4, client.getLastName());
            stmt.setString(5, client.getUserType());
            effectedRows = stmt.executeUpdate();
            tempCon.close();

        } catch (Exception e) {
            System.out.println("insertClientData :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static int insertAccountData(Account account) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            String query = "insert into account values(?,?,CURRENT_DATE,?,?,?,?,?)";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, account.getAccountNumber());
            stmt.setString(2, account.getClientUsername());
            stmt.setInt(3, account.getAccountTypeId());
            stmt.setDouble(4, account.getBalance());
            stmt.setDouble(5, account.getTransferLimit());
            stmt.setDouble(6, account.getWithdrawLimit());
            stmt.setString(7, account.getStatus());
            effectedRows = stmt.executeUpdate();
            tempCon.close();

        } catch (Exception e) {
            System.out.println("insertAccountData :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static int updateClientData(Client client) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            String query = "update login set firstname=?,lastname=?,password=? where username=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, client.getFirstName());
            stmt.setString(2, client.getLastName());
            stmt.setString(3, client.getPassword());
            stmt.setString(4, client.getUserName());

            effectedRows = stmt.executeUpdate();
            tempCon.close();

        } catch (Exception e) {
            System.out.println("insertClientData :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static int updateAccountData(Account account) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            String query = "update account set ACCOUNTTYPEID=?,TRANSFERLIMIT=?,WITHDRAMLIMIT=?,STATUS=? where ACCOUNTNUMBER=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setInt(1, account.getAccountTypeId());
            stmt.setDouble(2, account.getTransferLimit());
            stmt.setDouble(3, account.getWithdrawLimit());
            stmt.setString(4, account.getStatus());
            stmt.setString(5, account.getAccountNumber());

            effectedRows = stmt.executeUpdate();
            tempCon.close();

        } catch (Exception e) {
            System.out.println("insertAccountData :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static ArrayList<Account> getAllAccountsData() {
        ArrayList<Account> data = new ArrayList<Account>();
        try {
            Connection tempCon = createConnection();
            String query = "select * from account ";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                data.add(new Account(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getInt(4), rst.getDouble(5), rst.getDouble(6), rst.getDouble(7), rst.getString(8)));
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAllAccountType :: " + e.getMessage());
        }
        return data;
    }

    public static Account getAccountDataByAccountNumber(String accNumber) {
        Account data = null;
        try {
            Connection tempCon = createConnection();
            String query = "select * from account where ACCOUNTNUMBER=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, accNumber);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                data = (new Account(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getInt(4), rst.getDouble(5), rst.getDouble(6), rst.getDouble(7), rst.getString(8)));
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAccountDataByByAccountNumber :: " + e.getMessage());
        }
        return data;
    }

    public static Account getAccountDataByClientUserName(String client) {
        Account data = null;
        try {
            Connection tempCon = createConnection();
            String query = "select * from account where CLIENTUSERNAME=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, client);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                data = (new Account(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getInt(4), rst.getDouble(5), rst.getDouble(6), rst.getDouble(7), rst.getString(8)));
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAccountDataByClientUserName :: " + e.getMessage());
        }
        return data;
    }

    public static int blockedAccountByClientUsername(String username) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            String query = "update account set status=? where CLIENTUSERNAME=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, "BLOCKED");
            stmt.setString(2, username);
            effectedRows = stmt.executeUpdate();
            tempCon.close();

        } catch (Exception e) {
            System.out.println("blockedAccountByClientUsername :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static int updateBlockedAccountByClientUsername(String username, String status) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            String query = "update account set status=? where CLIENTUSERNAME=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, status);
            stmt.setString(2, username);
            effectedRows = stmt.executeUpdate();
            tempCon.close();

        } catch (Exception e) {
            System.out.println("blockedAccountByClientUsername :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static int insertTransactionData(Transactions transactions) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            {
                String query = "insert into TRANSACTIONS values(default,?,?,CURRENT_DATE,CURRENT_TIMESTAMP,?,?)";
                PreparedStatement stmt = tempCon.prepareStatement(query);
                stmt.setString(1, transactions.getSenderAccountNumber());
                if (transactions.getTransactionType().equals("TRANSFER")) {
                    stmt.setString(2, ((Transfer) transactions).getRecieverName());
                } else {
                    stmt.setString(2, null);
                }

                stmt.setString(3, transactions.getTransactionType());
                stmt.setDouble(4, transactions.getTransactionAmount());
                effectedRows = stmt.executeUpdate();
            }

            tempCon.close();
            if (effectedRows > 0) {
                if (transactions.getTransactionType().equals("TRANSFER")) {
                    effectedRows = updateWithdrawBalanceByAccountNumber(transactions.getSenderAccountNumber(), transactions.getTransactionAmount());
                    effectedRows = updateDepositBalanceByAccountNumber(((Transfer) transactions).getRecieverName(), transactions.getTransactionAmount());
                } else if (transactions.getTransactionType().equals("DEPOSIT")) {
                    effectedRows = updateDepositBalanceByAccountNumber(transactions.getSenderAccountNumber(), transactions.getTransactionAmount());
                } else {
                    effectedRows = updateWithdrawBalanceByAccountNumber(transactions.getSenderAccountNumber(), transactions.getTransactionAmount());
                }

            }

        } catch (Exception e) {
            System.out.println("insertAccountData :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static double getTotalTransactionAmountOfSpecificType(String accountNumber, String type) {
        double totalAmount = 0;
        try {
            Connection tempCon = createConnection();
            String query = "select TRANSACTIONAMOUNT from transactions where SENDINGDATE=CURRENT_DATE and SENDERACCOUNTNUMBER=? and TRANSACTIONTYPE=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, accountNumber);
            stmt.setString(2, type);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                totalAmount += rst.getDouble(1);
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getTotalTransactionAmountOfSpecificType :: " + e.getMessage());
        }
        return totalAmount;
    }

    public static int updateDepositBalanceByAccountNumber(String accountNumber, double balance) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            String query = "update account set BALANCE=BALANCE+? where ACCOUNTNUMBER=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setDouble(1, balance);

            stmt.setString(2, accountNumber);
            effectedRows = stmt.executeUpdate();
            tempCon.close();

        } catch (Exception e) {
            System.out.println("updateDepositBalanceByAccountNumber :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static int updateWithdrawBalanceByAccountNumber(String accountNumber, double balance) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            String query = "update account set BALANCE=BALANCE-? where ACCOUNTNUMBER=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setDouble(1, balance);

            stmt.setString(2, accountNumber);
            effectedRows = stmt.executeUpdate();
            tempCon.close();

        } catch (Exception e) {
            System.out.println("updateWithdrawBalanceByAccountNumber :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static ArrayList<Transactions> getAllTransactionsData() {
        ArrayList<Transactions> data = new ArrayList<Transactions>();
        try {
            Connection tempCon = createConnection();
            String query = "select * from transactions ";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                if (rst.getString("TRANSACTIONTYPE").equals("TRANSFER")) {
                    data.add(new Transfer(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getTime(5), rst.getDouble(7)));
                } else if (rst.getString("TRANSACTIONTYPE").equals("DEPOSIT")) {
                    data.add(new Deposit(rst.getInt(1), rst.getString(2), rst.getDate(4), rst.getTime(5), rst.getDouble(7)));
                } else {
                    data.add(new WithDraw(rst.getInt(1), rst.getString(2), rst.getDate(4), rst.getTime(5), rst.getDouble(7)));
                }
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAllTransactionsData :: " + e.getMessage());
        }
        return data;
    }

    public static ArrayList<Transactions> getAllTransactionsDataByAccountNumber(String accountNumber) {
        ArrayList<Transactions> data = new ArrayList<Transactions>();
        try {
            Connection tempCon = createConnection();
            String query = "select * from transactions where SENDERACCOUNTNUMBER=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, accountNumber);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                if (rst.getString("TRANSACTIONTYPE").equals("TRANSFER")) {
                    data.add(new Transfer(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getTime(5), rst.getDouble(7)));
                } else if (rst.getString("TRANSACTIONTYPE").equals("DEPOSIT")) {
                    data.add(new Deposit(rst.getInt(1), rst.getString(2), rst.getDate(4), rst.getTime(5), rst.getDouble(7)));
                } else {
                    data.add(new WithDraw(rst.getInt(1), rst.getString(2), rst.getDate(4), rst.getTime(5), rst.getDouble(7)));
                }
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAllTransactionsDataByAccountNumber :: " + e.getMessage());
        }
        return data;
    }

    public static int insertComplainData(String question) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            String query = "insert into COMPLAINS(CLIENTUSERNAME,QUESTION,ASKEDDATE,ASKEDTIME) values(?,?,CURRENT_DATE,CURRENT_TIMESTAMP)";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, StaticData.loginUserInfo.getUserName());
            stmt.setString(2, question);
            effectedRows = stmt.executeUpdate();
            tempCon.close();

        } catch (Exception e) {
            System.out.println("insertComplainData :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static int updateComplainAnswerData(String answer, int id) {
        int effectedRows = -1;
        try {
            Connection tempCon = createConnection();
            String query = "update   COMPLAINS set ADMINUSERNAME=? , ANSWER=? , ANSWERDATE=CURRENT_DATE , ANSWERTIME=CURRENT_TIMESTAMP ,ISANSWER=true where id=? ";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, StaticData.loginUserInfo.getUserName());
            stmt.setString(2, answer);
            stmt.setInt(3, id);
            effectedRows = stmt.executeUpdate();
            tempCon.close();

        } catch (Exception e) {
            System.out.println("updateComplainAnswerData :: " + e.getMessage());
        }
        return effectedRows;
    }

    public static ArrayList<Complains> getAllComplainsData() {
        ArrayList<Complains> data = new ArrayList<Complains>();
        try {
            Connection tempCon = createConnection();
            String query = "select * from Complains ";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                data.add(new Complains(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getTime(5), rst.getString(6), rst.getString(7), rst.getDate(8), rst.getTime(9), rst.getBoolean(10)));
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAllComplainsData :: " + e.getMessage());
        }
        return data;
    }

    public static ArrayList<Complains> getAllComplainsDataByUserName(String username) {
        ArrayList<Complains> data = new ArrayList<Complains>();
        try {
            Connection tempCon = createConnection();
            String query = "select * from Complains where CLIENTUSERNAME=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                data.add(new Complains(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getTime(5), rst.getString(6), rst.getString(7), rst.getDate(8), rst.getTime(9), rst.getBoolean(10)));
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getAllComplainsDataByUserName :: " + e.getMessage());
        }
        return data;
    }

    public static Complains getComplainsDataById(int id) {
        Complains data = null;
        try {
            Connection tempCon = createConnection();
            String query = "select * from Complains where id=?";
            PreparedStatement stmt = tempCon.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                data = (new Complains(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getTime(5), rst.getString(6), rst.getString(7), rst.getDate(8), rst.getTime(9), rst.getBoolean(10)));
            }
            tempCon.close();
        } catch (Exception e) {
            System.out.println("getComplainsDataById :: " + e.getMessage());
        }
        return data;
    }

}
