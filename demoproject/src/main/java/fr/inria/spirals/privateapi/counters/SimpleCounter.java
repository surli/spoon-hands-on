package fr.inria.spirals.privateapi.counters;

import fr.inria.spirals.publicapi.Counter;

public class SimpleCounter extends Counter {
    public SimpleCounter(int i) {
        super(i);
    }

    public int nextNumber() {
        return this.getSeed()+1;
    }
}
