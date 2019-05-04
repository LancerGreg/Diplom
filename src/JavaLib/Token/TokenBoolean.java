package JavaLib.Token;

public class TokenBoolean extends Token{

    public static final String stringIf = "if";
    public static final String stringElse = "else";
    public static final String stringTry = "try";
    public static final String stringCatch = "catch";


    public static String[] token() {
        return new String[]{stringIf, stringElse, stringTry, stringCatch};
    }
}
