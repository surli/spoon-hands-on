package fr.inria.spirals.processor;


import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.reference.CtReference;

/**
 * This processor is used to rename an element of the model.
 * It also shows the difference between a declared element and a reference in Spoon model
 */
public class RenameLinearCountingProcessor extends AbstractProcessor<CtElement> {
    private String oldName;
    private String newName;

    public RenameLinearCountingProcessor(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    @Override
    public boolean isToBeProcessed(CtElement candidate) {

        // in that case it's a declared element
        // like public class MyClass or public void mymethod()
        if (candidate instanceof CtNamedElement) {
            CtNamedElement namedElement = (CtNamedElement) candidate;
            return namedElement.getSimpleName().equals(oldName);

        // in that case it's a reference element
        // like MyClass variable; (the type of variable is a reference to MyClass)
        // or mymethod(parameter); (here mymethod is an invocation which has a reference to the executable, here's the declaration of the method)
        } else if (candidate instanceof CtReference) {
            CtReference reference = (CtReference) candidate;
            return reference.getSimpleName().equals(oldName);
        }
        return false;
    }

    @Override
    public void process(CtElement element) {
        if (element instanceof CtNamedElement) {
            CtNamedElement namedElement = (CtNamedElement) element;
            namedElement.setSimpleName(this.newName);
        } else if (element instanceof CtReference) {
            CtReference reference = (CtReference) element;
            reference.setSimpleName(this.newName);
        }
    }
}
