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
        final var today = timeProvider.monthDay();
        
        final var users = employeeRepository.findEmployeesBornOn(today);
        
        sender.notifyAll(users);
    }
}
