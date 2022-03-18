package ludwiniak.wiktor.hdd.utils;

import java.util.Objects;

public class Call {
    private int location;

    public Call(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Call)) return false;
        Call call = (Call) o;
        return location == call.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public String toString() {
        return Integer.toString(location);
    }
}
