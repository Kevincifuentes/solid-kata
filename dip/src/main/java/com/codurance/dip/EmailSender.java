package com.codurance.dip;

public class EmailSender implements Sender {
    public void sendAll(List<Email> emails) {
        emails.forEach(email -> System.out.print("To:"+email.getTo()+", Subject: "+email.getSubject()+", Message: "+email.getMessage()));
    }
}
