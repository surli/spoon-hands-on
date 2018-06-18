package fr.inria.spirals.publicapi;

import fr.inria.spirals.privateapi.PrivateType;
import fr.inria.spirals.publicapi.subpack.TypePublic;

public class MyPublicType {
    private PrivateType privateType;

    public MyPublicType() {
        this.privateType = new PrivateType();
    }

    public int getANumber() {
        return privateType.getANumber();
    }

    public PrivateType getPrivateType() {
        return privateType;
    }

    public TypePublic getTypePublic() {
        return new TypePublic();
    }
}
