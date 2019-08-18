package com.demostatefulejb;

import javax.ejb.Local;

@Local
public interface LocalCounter {
    void increment();
    void decrement();
    int getOperand();
}
