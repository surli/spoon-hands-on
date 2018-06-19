package fr.inria.spirals.processor;


import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.reference.CtReference;

public class RenameLinearCountingProcessor extends AbstractProcessor<CtElement> {
    private String oldName;
    private String newName;

    public RenameLinearCountingProcessor(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    @Override
    public boolean isToBeProcessed(CtElement candidate) {
        if (candidate instanceof CtNamedElement) {
            CtNamedElement namedElement = (CtNamedElement) candidate;
            return namedElement.getSimpleName().equals(oldName);
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
