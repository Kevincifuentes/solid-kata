package com.codurance.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final EmailSender emailSender;
    private final Clock clock;

    public BirthdayGreeter(EmployeeRepository employeeRepository, EmailSender emailSender, Clock clock) {
        this.employeeRepository = employeeRepository;
        this.emailSender = emailSender;
        this.clock = clock;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        
        final var emails = employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(Employee:getBirthdayEmail)
                .collect(toList());
        
        emailSender.sendAll(emails);
    }
}
