package fr.inria.spirals.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtNamedElement;

/**
 * This processor will only print on the standard output the list of encountered CtNamedElements.
 */
public class EmptyProcessor extends AbstractProcessor<CtNamedElement> {

    /**
     * This method should normally be used to filter the elements we want to process or not.
     * Here, by returning true, we decide to process every elements of the model.
     */
    @Override
    public boolean isToBeProcessed(CtNamedElement element) {
        return true;
    }

    /**
     * This method is used to process an element (thanks Captain Obvious!)
     * You can do everything you want: transforming an element in the model, checking a property, ... or printing it on the standard output.
     */
    @Override
    public void process(CtNamedElement element) {
        System.out.println("Processing..." + element.getSimpleName());
    }
}
