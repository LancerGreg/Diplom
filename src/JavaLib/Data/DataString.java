package JavaLib.Data;

public class DataString extends Data{

    private String dataString;

    public DataString() {
    }

    public DataString(String name, String dataString) {
        super(name);
        setType("String");
        this.dataString = dataString;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }
}
