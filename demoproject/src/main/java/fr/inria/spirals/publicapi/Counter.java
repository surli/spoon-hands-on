package fr.inria.spirals.publicapi;

public abstract class Counter {
    private int seed;

    public Counter(int i) {
        this.seed = i;
    }

    protected int getSeed() {
        return this.seed;
    }

    public abstract int nextNumber();
}
