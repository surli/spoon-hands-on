package fr.inria.spirals.privateapi.counters;

import fr.inria.spirals.publicapi.Counter;

import java.util.Random;

public class ComplexCounter extends Counter {

    private Random random;

    public ComplexCounter(int seed) {
        super(seed);

        this.random = new Random(this.getSeed());
    }

    public int nextNumber() {
        return this.random.nextInt();
    }
}
