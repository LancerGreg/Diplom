package JavaLib.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/*
класс для хранение определеных груп токенов для наступных класов проверки и сканирование кода
 */
public class Token {

    /**
     *
     * @return список всех токенов
     */
    public static ArrayList<String> allTokenArrayList() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenOfOperation.token()));
        stringArrayList.addAll(Arrays.asList(TokenOOP.token()));
        stringArrayList.addAll(Arrays.asList(TokenBoolean.token()));
        stringArrayList.addAll(Arrays.asList(TokenCycle.token()));
        stringArrayList.addAll(Arrays.asList(TokenMath.token()));
        stringArrayList.addAll(Arrays.asList(TokenTypeData.token()));

        return stringArrayList;
    }

    /**
     *
     * @return список вхожят все елементы которые не емеют букв
     */
    public static ArrayList<String> tokenBySpace() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenOfOperation.token()));
        stringArrayList.addAll(Arrays.asList(TokenMath.token()));

        return stringArrayList;
    }


    /**
     * выделяем все токены пробелами, для того что бы можно было поместить все на лист одельно друг от друга
     *
     * @param massage текущий месейдж в которому можут мистица несколько токенов
     * @return стринг в которому токены розделены друг от друга пробелами
     */
    public static String replaceTokenBySpace(String massage) {
        for (int i = 0; i < tokenBySpace().size(); i++) {
            massage = massage.replaceAll(Pattern.quote(tokenBySpace().get(i)),
                    " " + tokenBySpace().get(i) + " ").replaceAll("[\\s]{2,}", " ");
        }

        return massage;
    }

}
