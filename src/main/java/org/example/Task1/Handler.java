package org.example.Task1;

import lombok.Setter;

public abstract class Handler {

    private final int quantity;
    @Setter
    private Handler next;

    public Handler(int quantity) {
        this.quantity = quantity;
    }

    public int process(int amount) throws IllegalArgumentException {
        if (amount == 0) {
            return 0;
        }

        if (next == null && amount % quantity != 0) {
            throw new IllegalArgumentException("Can not be calculated!");
        } else if (next == null) {
            return (amount / quantity);
        }

        return (amount / quantity) + next.process(amount % quantity);
    }
}
