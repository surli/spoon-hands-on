package fr.inria.spirals.publicapi;

import fr.inria.spirals.privateapi.counters.ComplexCounter;
import fr.inria.spirals.publicapi.utils.BadNameCounter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Store {
    private BadNameCounter badNameCounter;
    private ComplexCounter complexCounter;

    public Store() {
        this.badNameCounter = new BadNameCounter();
        this.complexCounter = new ComplexCounter(new Date().getYear());
    }

    public List<Integer> getNInteger(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            result.add(badNameCounter.next());
        }

        return result;
    }

    public void sortInteger(List<Integer> integerList) {
        Collections.sort(integerList, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return complexCounter.nextNumber();
            }
        });
    }


    public BadNameCounter getBadNameCounter() {
        return badNameCounter;
    }

    public Store setBadNameCounter(BadNameCounter badNameCounter) {
        this.badNameCounter = badNameCounter;
        return this;
    }

    public ComplexCounter getComplexCounter() {
        return complexCounter;
    }

    public void setComplexCounter(ComplexCounter complexCounter) {
        this.complexCounter = complexCounter;
    }
}
