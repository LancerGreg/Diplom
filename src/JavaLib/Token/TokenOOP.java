package JavaLib.Token;

public class TokenOOP extends Token{

    public static final String stringPublic = "public";
    public static final String stringProtected = "protected";
    public static final String stringPrivate = "private";
    public static final String stringClass = "class";
    public static final String stringAbstract = "abstract";
    public static final String stringInterface = "interface";

    public static final String stringStatic = "static";
    public static final String stringFinal = "final";

    public static final String stringExtends = "extends";
    public static final String stringImplements = "implements";


    public static String[] token() {
        return new String[]{stringPublic, stringProtected, stringPrivate, stringClass, stringAbstract,
                stringInterface, stringStatic, stringFinal, stringExtends, stringImplements};
    }

    /**
     *
     * @return масив всех возможных токенов до класа(до)
     */
    public static String[] tokenForClass() {
        return new String[]{stringPublic, stringProtected, stringPrivate, stringAbstract, stringFinal};
    }

    /**
     *
     * @return масив всех возможных токенов инкапусляции(после)
     */
    public static String[] tokenByType(){
        return new String[]{stringClass, stringAbstract, stringInterface, stringStatic, stringFinal};
    }

    /**
     *
     * @return масив всех возможных токенов для инкапсуляции(до)
     */
    public static String[] tokenByType2(){
        return new String[]{stringStatic, stringFinal};
    }

    public static String[] tokenForFinal(){
        return new String[]{stringStatic, stringInterface, stringClass, stringAbstract, stringPublic, stringProtected, stringPrivate};
    }

    public static String[] tokenForStatic(){
        return new String[]{stringFinal, stringInterface, stringClass, stringAbstract, stringPublic, stringProtected, stringPrivate};
    }
}
