package com.codurance.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Publisher publisher;
    private final TimeProvider timeProvider;

    public BirthdayGreeter(EmployeeRepository employeeRepository, Publisher publisher, TimeProvider timeProvider) {
        this.employeeRepository = employeeRepository;
        this.publisher = publisher;
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
