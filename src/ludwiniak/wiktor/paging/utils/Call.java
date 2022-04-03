package ludwiniak.wiktor.paging.utils;

import java.util.Objects;

public class Call {
    public int id;
    public int lastCall = 0;

    public Call(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Call call = (Call) o;
        return id == call.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
