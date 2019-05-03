package JavaLib.Token;

public class TokenTypeData extends Token{

    public static final String stringBoolean = "boolean";
    public static final String stringTrue = "true";
    public static final String stringFalse = "false";

    public static final String stringByte = "byte";
    public static final String stringShort = "short";
    public static final String stringInt = "int";
    public static final String stringLong = "long";

    public static final String stringComma = ",";
    public static final String stringFloat = "float";
    public static final String stringDouble = "double";

    public static final String stringChar = "char";
    public static final String stringString = "String";

    public static final String stringVoid = "void";


    public static String[] token() {
        return new String[]{stringBoolean, stringTrue, stringFalse, stringByte, stringShort,
                stringInt, stringLong, stringComma, stringFloat, stringDouble, stringChar,
                stringString, stringVoid};
    }

    /**
     *
     * @return вектор всех типов даных, без значения
     */
    public static String[] tokenByType() {
        return new String[]{stringBoolean, stringByte, stringShort, stringInt, stringLong, stringFloat,
                stringDouble, stringChar, stringString, stringVoid};
    }
}
