package fr.inria.spirals.processor;


import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtNamedElement;

public class RenameLinearCountingProcessor extends AbstractProcessor<CtNamedElement> {
    public static final String oldName = "LinearCounting";
    public static final String newName = "LinearCounter";

    @Override
    public boolean isToBeProcessed(CtNamedElement element) {
        return (element.getSimpleName().equals(oldName));
    }

    @Override
    public void process(CtNamedElement element) {
        element.setSimpleName(newName);
    }
}
