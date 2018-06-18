package fr.inria.spirals.publicapi.subpack;

import fr.inria.spirals.privateapi.PrivateType;
import fr.inria.spirals.privateapi.subpack.AnotherType;

public class TypePublic {

    private PrivateType getPrivateType() {
        return new PrivateType();
    }

    public AnotherType getAnotherType() {
        return new AnotherType();
    }
}
