package JavaLib.Rule.RuleOOP;

import JavaLib.Token.Token;
import JavaLib.Token.TokenOOP;
import JavaLib.Token.TokenTypeData;

import java.util.ArrayList;
import java.util.Arrays;

//класс для правила инкапсуляции
public class RuleEncapsulation {

    /**
     *
     * @return список возможных написання токенов после инкапсуляции
     */
    public static ArrayList<String> tokenByRuleByDataType() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenTypeData.tokenByType()));
        stringArrayList.addAll(Arrays.asList(TokenOOP.tokenByType()));

        return stringArrayList;
    }

    /**
     *
     * @return список возможных токенов которые пишутся до инициалазации инкаспуляции
     */
    public static ArrayList<String> tokenByRuleByDataType2() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenOOP.tokenByType2()));

        return stringArrayList;
    }

    /**
     *
     * @param splitCodeBySpace разбитый список токенов
     * @param massage проверка текущого токена
     * @param xstay текущая строка
     * @param ystay текуший токен
     * @return тру если правильно написали инициализацию инкапусляции
     */
    public static boolean checkSyntacticEncapsulation(ArrayList<ArrayList<String>> splitCodeBySpace,
                                                      String massage, int xstay, int ystay) {

        boolean checkNextToken = false;
        boolean checkPreviousToken = false;

        if (massage.equals(TokenOOP.stringPublic) ||
                massage.equals(TokenOOP.stringProtected) ||
                massage.equals(TokenOOP.stringPrivate)) {

            for (int i = 0; i < tokenByRuleByDataType().size(); i++) {
                if (splitCodeBySpace.get(xstay).get(ystay + 1).equals(tokenByRuleByDataType().get(i))) {
                    checkNextToken = true;
                    break;
                }
            }

            if (!checkNextToken) {
                System.out.println("Error(" + xstay + "," + (ystay + 1) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay + 1) + "\" expected type data");
                return false;
            }

            if (ystay != 0) {
                for (int i = 0; i < tokenByRuleByDataType2().size(); i++) {
                    if (splitCodeBySpace.get(xstay).get(ystay - 1).equals(tokenByRuleByDataType2().get(i))) {
                        checkPreviousToken = true;
                        break;
                    }
                }
                if (!checkPreviousToken){
                    System.out.println("Error(" + xstay + "," + (ystay - 1) + ") java \"" +
                            splitCodeBySpace.get(xstay).get(ystay - 1) + "\" expected type data");
                    return false;
                }
            }

            return true;

        }

        return true;
    }
}