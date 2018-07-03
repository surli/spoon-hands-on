package fr.inria.spirals.publicapi.utils;

import fr.inria.spirals.privateapi.counters.SimpleCounter;
import fr.inria.spirals.publicapi.Counter;

public class BadNameCounter {
    private SimpleCounter innerCounter;

    public BadNameCounter() {
    }

    public int next() {
        return this.getOrCreateInnerCounter().nextNumber();
    }

    public SimpleCounter getOrCreateInnerCounter() {
        if (this.innerCounter == null) {
            this.innerCounter = new SimpleCounter(0);
        }
        return this.innerCounter;
    }

    public Counter getCounter() {
        return this.innerCounter;
    }
}
