package fr.inria.spirals.publicapi.utils;

import fr.inria.spirals.privateapi.counters.SimpleCounter;
import fr.inria.spirals.publicapi.Counter;

public class LinearCounting {
    private SimpleCounter innerCounter;

    public LinearCounting() {
        this.innerCounter = new SimpleCounter(0);
    }

    public int next() {
        return this.innerCounter.nextNumber();
    }

    public SimpleCounter getInnerCounter() {
        return this.innerCounter;
    }

    public Counter getCounter() {
        return this.innerCounter;
    }
}
