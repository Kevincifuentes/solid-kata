package com.codurance.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final EmailSender emailSender;
    private final TimeProvider timeProvider;

    public BirthdayGreeter(EmployeeRepository employeeRepository, EmailSender emailSender, TimeProvider timeProvider) {
        this.employeeRepository = employeeRepository;
        this.emailSender = emailSender;
        this.timeProvider = timeProvider;
    }

    public void sendGreetings() {
        MonthDay today = timeProvider.monthDay();
        
        final var emails = employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(Employee:getBirthdayEmail)
                .collect(toList());
        
        publisher.notifyAll(emails);
    }
}
