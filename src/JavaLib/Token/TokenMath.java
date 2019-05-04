package JavaLib.Token;

public class TokenMath extends Token{

    public static final String inc = "++";
    public static final String ibs = "+="; //inc before sum
    public static final String ias = "=+"; //inc after sum
    public static final String iam = "=-";
    public static final String ims = "-=";
    public static final String imm = "--";

    public static final String equals = "=";
    public static final String plus = "+";
    public static final String minus = "-";
    public static final String multiply = "*";
    public static final String division = "/";
    public static final String dwr = "%"; //division without remaining

    public static String[] token() {
        return new String[]{equals, plus, minus, multiply, division, dwr, inc, ibs, ias, iam, ims, imm};
    }
}
