package JavaLib.Token;

public class TokenOfOperation extends Token{

    public static final String finishedOperation = ";";
    public static final String callOperation = ".";

    public static final String giveOperation = "()";
    public static final String giveOperationOpen = "(";
    public static final String giveOperationClose = ")";
    public static final String bodyOperation = "{}";
    public static final String bodyOperationOpen = "{";
    public static final String bodyOperationClose = "}";

    public static final String stringIndicatorChar = "\'";
    public static final String stringIndicatorString = "\"";

    public static final String stringVector = "[]";
    public static final String stringVectorOpen = "[";
    public static final String stringVectorClose = "]";
    public static final String stringVectorOfKnow = "{}";
    public static final String stringVectorOfKnowOpen = "{";
    public static final String stringVectorOfKnowClose = "}";
    public static final String stringSeparator = ",";


    public static String[] token() {
        return new String[]{finishedOperation, callOperation, giveOperation, bodyOperation,
                giveOperationOpen, giveOperationClose, bodyOperationOpen, bodyOperationClose,
                stringVector, stringVectorOfKnow, stringSeparator,stringVectorOpen,
                stringVectorClose, stringVectorOfKnowOpen, stringVectorOfKnowClose,
                stringIndicatorChar, stringIndicatorString};
    }
}
