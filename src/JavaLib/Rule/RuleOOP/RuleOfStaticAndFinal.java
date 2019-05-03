package JavaLib.Rule.RuleOOP;

import JavaLib.Token.TokenOOP;
import JavaLib.Token.TokenTypeData;

import java.util.ArrayList;
import java.util.Arrays;

//класс для проверки правильной инициализации final i static
public class RuleOfStaticAndFinal {

    /**
     *
     * @return список всех возможных токенов для Final (после)
     */
    public static ArrayList<String> tokenForFinalNextToken() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenOOP.tokenForFinal()));
        stringArrayList.addAll(Arrays.asList(TokenTypeData.tokenByType()));

        return stringArrayList;
    }

    /**
     *
     * @return список всех возможных токенов для Final (до)
     */
    public static ArrayList<String> tokenForFinalPreviousToken() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenOOP.tokenForFinal()));

        return stringArrayList;
    }

    /**
     *
     * @return список всех возможных токенов для Static (после)
     */
    public static ArrayList<String> tokenForStaticNextToken() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenOOP.tokenForStatic()));
        stringArrayList.addAll(Arrays.asList(TokenTypeData.tokenByType()));

        return stringArrayList;
    }

    /**
     *
     * @return список всех возможных токенов для Static (до)
     */
    public static ArrayList<String> tokenForStaticPreviousToken() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenOOP.tokenForStatic()));

        return stringArrayList;
    }

    /**
     *
     * @param splitCodeBySpace список всех токоенов
     * @param massage текущий токен
     * @param xstay текущая строка токена
     * @param ystay номерация текущого токена
     * @return тру если правильно реализован Static i Final
     */
    public static boolean checkSyntacticEncapsulation(ArrayList<ArrayList<String>> splitCodeBySpace,
                                                      String massage, int xstay, int ystay) {

        boolean checkNextToken = false;
        boolean checkPreviousToken = false;

        if (massage.equals(TokenOOP.stringFinal)) {
            for (int i = 0; i < tokenForFinalNextToken().size(); i++) {
                if (splitCodeBySpace.get(xstay).get(ystay + 1).equals(tokenForFinalNextToken().get(i))) {
                    checkNextToken = true;
                    break;
                }
            }

            if (!checkNextToken) {
                System.out.println("Error(" + xstay + "," + (ystay + 1) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay + 1) + "\" <identifier> expected");
                return false;
            }

            if (ystay != 0) {
                for (int i = 0; i < tokenForFinalPreviousToken().size(); i++) {
                    if (splitCodeBySpace.get(xstay).get(ystay - 1).equals(tokenForFinalPreviousToken().get(i))) {
                        checkPreviousToken = true;
                        break;
                    }
                }
                if (!checkPreviousToken) {
                    System.out.println("Error(" + xstay + "," + (ystay - 1) + ") java \"" +
                            splitCodeBySpace.get(xstay).get(ystay - 1) + "\" <identifier> data");
                    return false;
                }
            }

            return true;
        }

        if (massage.equals(TokenOOP.stringStatic)) {
            checkNextToken = false;
            checkPreviousToken = false;
            for (int i = 0; i < tokenForStaticNextToken().size(); i++) {
                if (splitCodeBySpace.get(xstay).get(ystay + 1).equals(tokenForStaticNextToken().get(i))) {
                    checkNextToken = true;
                    break;
                }
            }
            if (!checkNextToken) {
                System.out.println("Error(" + xstay + "," + (ystay + 1) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay + 1) + "\" <identifier> expected");
                return false;
            }

            if (ystay != 0) {
                for (int i = 0; i < tokenForStaticPreviousToken().size(); i++) {
                    if (splitCodeBySpace.get(xstay).get(ystay - 1).equals(tokenForStaticPreviousToken().get(i))) {
                        checkPreviousToken = true;
                        break;
                    }
                }
                if (!checkPreviousToken) {
                    System.out.println("Error(" + xstay + "," + (ystay - 1) + ") java \"" +
                            splitCodeBySpace.get(xstay).get(ystay - 1) + "\" <identifier> data");
                    return false;
                }
            }
        }

        return true;
    }

}
