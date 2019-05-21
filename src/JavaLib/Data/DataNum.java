package JavaLib.Data;

public class DataNum extends Data{

    private byte numByte;
    private short numShort;
    private int numInt;
    private long numLong;

    private float numFloat;
    private double numDouble;

    public DataNum() {
    }

    public DataNum(String name, byte numByte, Object dataByte, int x, int y) {
        super(name, dataByte, x, y);
        setType("byte");
        this.numByte = numByte;
    }

    public DataNum(String name, short numShort, Object dataShort, int x, int y) {
        super(name, dataShort, x, y);
        setType("short");
        this.numShort = numShort;
    }

    public DataNum(String name, int numInt, Object dataInt, int x, int y) {
        super(name, dataInt, x, y);
        setType("int");
        this.numInt = numInt;
    }

    public DataNum(String name, long numLong, Object dataLong, int x, int y) {
        super(name, dataLong, x, y);
        setType("long");
        this.numLong = numLong;
    }

    public DataNum(String name, float numFloat, Object dataFloat, int x, int y) {
        super(name, dataFloat, x, y);
        setType("float");
        this.numFloat = numFloat;
    }

    public DataNum(String name, double numDouble, Object dataDouble, int x, int y) {
        super(name, dataDouble, x, y);
        setType("double");
        this.numDouble = numDouble;
    }

    public byte getNumByte() {
        return numByte;
    }

    public void setNumByte(byte numByte) {
        this.numByte = numByte;
    }

    public short getNumShort() {
        return numShort;
    }

    public void setNumShort(short numShort) {
        this.numShort = numShort;
    }

    public int getNumInt() {
        return numInt;
    }

    public void setNumInt(int numInt) {
        this.numInt = numInt;
    }

    public long getNumLong() {
        return numLong;
    }

    public void setNumLong(long numLong) {
        this.numLong = numLong;
    }

    public float getNumFloat() {
        return numFloat;
    }

    public void setNumFloat(float numFloat) {
        this.numFloat = numFloat;
    }

    public double getNumDouble() {
        return numDouble;
    }

    public void setNumDouble(double numDouble) {
        this.numDouble = numDouble;
    }
}
