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
public class Complains {

    private int id;
    private String clientUsername;
    private String Questions;
    private Date askedDate;
    private Time askedTime;
    private String adminUserName;
    private String answer;
    private Date answerDate;
    private Time answerTime;
    private boolean isAnswer;

    public Complains(int id, String clientUsername, String Questions, Date askedDate, Time askedTime, String adminUserName, String answer, Date answerDate, Time answerTime, boolean isAnswer) {
        this.id = id;
        this.clientUsername = clientUsername;
        this.Questions = Questions;
        this.askedDate = askedDate;
        this.askedTime = askedTime;
        this.adminUserName = adminUserName;
        this.answer = answer;
        this.answerDate = answerDate;
        this.answerTime = answerTime;
        this.isAnswer = isAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String Questions) {
        this.Questions = Questions;
    }

    public Date getAskedDate() {
        return askedDate;
    }

    public void setAskedDate(Date askedDate) {
        this.askedDate = askedDate;
    }

    public Time getAskedTime() {
        return askedTime;
    }

    public void setAskedTime(Time askedTime) {
        this.askedTime = askedTime;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public Time getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Time answerTime) {
        this.answerTime = answerTime;
    }

    public boolean isIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(boolean isAnswer) {
        this.isAnswer = isAnswer;
    }

}
