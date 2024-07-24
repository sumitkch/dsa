package solid;

import java.util.Date;

public final class Immutable {
    private final String name;
    private final Date dob;
    private final int id;

    public Immutable(String name, Date dob, int id) {
        this.name = name;
        this.dob = (Date) dob.clone();
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public int getId() {
        return id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
