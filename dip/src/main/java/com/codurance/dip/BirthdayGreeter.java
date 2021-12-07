package com.codurance.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Publisher publisher;
    private final TimeProvider timeProvider;

    public BirthdayGreeter(EmployeeRepository employeeRepository, Publisher publisher, TimeProvider timeProvider) {
        this.employeeRepository = employeeRepository;
        this.publisher = publisher;
        this.clock = clock;
    }

    public void sendGreetings() {
        MonthDay today = timeProvider.monthDay();
        
        final var users = employeeRepository.findEmployeesBornOn(today)
                .stream();
        
        publisher.notify(users);
    }
}
