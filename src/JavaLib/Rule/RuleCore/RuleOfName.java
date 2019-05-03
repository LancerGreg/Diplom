package JavaLib.Rule.RuleCore;

import JavaLib.Token.Token;

import java.math.BigInteger;

public class RuleOfName {

    /**
     * идет поиск всех не токенов - тоесть название полей или класов и т.д. и если оно является токеном
     то выкидуем false c определением что в таком то месте есть ошибка и что именно не так
     *
     * @param massage текущий токен
     * @param a текущая строка
     * @param b текущий токен
     * @return тру если написания токено правильное, фолс наоборот
     */
     public static boolean checkName(String massage, int a, int b) {

        if (massage.substring(0, 1).matches("[a-zA-Z]")) {
            return true;
        }

        for (int i = 0; i < Token.allTokenArrayList().size(); i++) {
            if (Token.allTokenArrayList().get(i).equals(massage)) {
                return true;
            }
        }

        for (int i = 0; i < massage.length(); i++) {
            if (massage.substring(i, i + 1).matches("[a-zA-Z]")) {
                System.out.println("Error(" + a + "," + b + ") java \"" + massage + "\" token started with num");
                return false;
            }
        }

        return true;
    }

}
