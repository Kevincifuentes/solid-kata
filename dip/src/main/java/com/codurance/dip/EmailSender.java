package com.codurance.dip;

public class EmailSender {
    public void notifyAll(List<Employee> employees) {
        emails.forEach(email -> System.out.print("To:"+email.getTo()+", Subject: "+email.getSubject()+", Message: "+email.getMessage()));
    }
}
