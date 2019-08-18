package com.demostatefulejb;

import javax.ejb.Stateful;

@Stateful
public class LocalCounterBean implements LocalCounter {
    private int operand = 0;

    @Override
    public void increment() {
        this.operand++;
    }

    @Override
    public void decrement() {
        this.operand--;
    }

    @Override
    public int getOperand() {
        return this.operand;
    }
}
