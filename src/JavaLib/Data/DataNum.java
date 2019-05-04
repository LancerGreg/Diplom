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

    public DataNum(String name, byte numByte) {
        super(name);
        setType("byte");
        this.numByte = numByte;
    }

    public DataNum(String name, short numShort) {
        super(name);
        setType("short");
        this.numShort = numShort;
    }

    public DataNum(String name, int numInt) {
        super(name);
        setType("int");
        this.numInt = numInt;
    }

    public DataNum(String name, long numLong) {
        super(name);
        setType("long");
        this.numLong = numLong;
    }

    public DataNum(String name, float numFloat) {
        super(name);
        setType("float");
        this.numFloat = numFloat;
    }

    public DataNum(String name, double numDouble) {
        super(name);
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
