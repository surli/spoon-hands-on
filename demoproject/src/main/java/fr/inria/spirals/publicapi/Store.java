package fr.inria.spirals.publicapi;

import fr.inria.spirals.privateapi.counters.ComplexCounter;
import fr.inria.spirals.publicapi.utils.LinearCounting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Store {
    private LinearCounting linearCounting;
    private ComplexCounter complexCounter;

    public Store() {
        this.linearCounting = new LinearCounting();
        this.complexCounter = new ComplexCounter(new Date().getYear());
    }

    public List<Integer> getNInteger(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            result.add(linearCounting.next());
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


    public LinearCounting getLinearCounting() {
        return linearCounting;
    }

    public void setLinearCounting(LinearCounting linearCounting) {
        this.linearCounting = linearCounting;
    }

    public ComplexCounter getComplexCounter() {
        return complexCounter;
    }

    public void setComplexCounter(ComplexCounter complexCounter) {
        this.complexCounter = complexCounter;
    }
}
