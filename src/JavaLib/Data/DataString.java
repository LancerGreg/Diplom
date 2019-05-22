package JavaLib.Data;

public class DataString extends Data{

    public DataString() {
    }

    public DataString(String name, Object dataString, int x, int y) {
        super(name, dataString, x, y);
        setType("String");
    }

}
