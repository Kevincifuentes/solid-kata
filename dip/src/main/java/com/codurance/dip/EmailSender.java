package com.codurance.dip;

public class EmailSender implements Sender {
    public void notifyAll(List<Employee> employees) {
        employees.stream()
            .map(Employee::getBirthdayEmail)
            .forEach(email -> System.out.print("To:"+email.getTo()+", Subject: "+email.getSubject()+", Message: "+email.getMessage()));
    }
}
