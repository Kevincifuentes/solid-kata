package com.codurance.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Sender sender;
    private final TimeProvider timeProvider;

    public BirthdayGreeter(EmployeeRepository employeeRepository, Sender sender, TimeProvider timeProvider) {
        this.employeeRepository = employeeRepository;
        this.sender = sender;
        this.timeProvider = timeProvider;
    }

    public void sendGreetings() {
        final var today = timeProvider.monthDay();
        
        final var users = employeeRepository.findEmployeesBornOn(today);
        
        sender.notifyAll(users);
    }
}
