package JavaLib.Token;

public class TokenCycle extends Token{

    public static final String stringFor = "for";
    public static final String stringWhile = "while";


    public static String[] token() {
        return new String[]{stringFor, stringWhile};
    }
}
