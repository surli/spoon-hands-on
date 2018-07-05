package fr.inria.spirals.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtNamedElement;

public class EmptyProcessor extends AbstractProcessor<CtNamedElement> {

    @Override
    public boolean isToBeProcessed(CtNamedElement element) {
        return true;
    }

    @Override
    public void process(CtNamedElement element) {
        System.out.println("Processing..." + element.getSimpleName());
    }
}
