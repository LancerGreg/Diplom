package JavaLib.Data;

public class DataBoolean extends Data{

    private boolean dataBoolean;

    public DataBoolean() {
    }

    public DataBoolean(String name, boolean dataBoolean) {
        super(name);
        setType("boolean");
        this.dataBoolean = dataBoolean;
    }

    public boolean isDataBoolean() {
        return dataBoolean;
    }

    public void setDataBoolean(boolean dataBoolean) {
        this.dataBoolean = dataBoolean;
    }
}
