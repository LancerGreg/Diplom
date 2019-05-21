package JavaLib.Data;

public class DataBoolean extends Data{

    public DataBoolean() {
    }

    public DataBoolean(String name, Object dataBoolean, int x, int y) {
        super(name, dataBoolean, x, y);
        setType("boolean");
    }
}
