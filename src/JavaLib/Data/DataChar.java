package JavaLib.Data;

public class DataChar extends Data{

    private char dataString;

    public DataChar() {
    }

    public DataChar(String name, char dataString) {
        super(name);
        setType("char");
        this.dataString = dataString;
    }

    public char getDataString() {
        return dataString;
    }

    public void setDataString(char dataString) {
        this.dataString = dataString;
    }

}
