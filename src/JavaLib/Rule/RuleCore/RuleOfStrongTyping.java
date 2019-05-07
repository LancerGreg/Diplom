package JavaLib.Rule.RuleCore;

import JavaLib.Data.Data;
import JavaLib.Token.TokenMath;
import JavaLib.Token.TokenOfOperation;

import java.util.ArrayList;
import java.util.Arrays;

public class RuleOfStrongTyping {

    /**
     * @return список токенов - операндов
     */
    public static ArrayList<String> tokenByRuleByDataType() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenOfOperation.token()));
        stringArrayList.addAll(Arrays.asList(TokenMath.tokenForRuleOfStrongTyping()));

        return stringArrayList;
    }

    /**
     * Метод на проверку строгои типизации
     *
     * @param splitCodeBySpace список всех токенов
     * @param massage          текущий токен
     * @param xstay            позиция строки токенна
     * @param ystay            позиция токена в строке
     * @return тру если строгая типизация присудствует
     */
    public static boolean checkStrongTyping(ArrayList<ArrayList<String>> splitCodeBySpace,
                                              String massage, int xstay, int ystay){

        if (massage.equals(TokenOfOperation.equals)) {
            String type = "";
            for (int i = 0; i < Data.addAllObject(splitCodeBySpace).size(); i++) {
                if (splitCodeBySpace.get(xstay).get(ystay - 1).equals(Data.addAllObject(splitCodeBySpace).get(i).getName())) {
                    type = Data.addAllObject(splitCodeBySpace).get(i).getType();
                    break;
                }
            }
            for (int i = ystay + 1; i < splitCodeBySpace.get(xstay).size(); i++) {
                boolean flag = false;
                for (int j = 0; j < tokenByRuleByDataType().size(); j++) {
                    if (splitCodeBySpace.get(xstay).get(i).equals(tokenByRuleByDataType().get(j))) {
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    for (int j = 0; j < Data.addAllObject(splitCodeBySpace).size(); j++) {
                        if (splitCodeBySpace.get(xstay).get(i).equals(Data.addAllObject(splitCodeBySpace).get(j).getName())
                                && Data.addAllObject(splitCodeBySpace).get(j).getType().equals(type)) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    System.out.println("Error(" + xstay + "," + i + ") java \"" + splitCodeBySpace.get(xstay).get(i) + "\" expected type: " + type);
                    return false;
                }
            }
        }

        return true;
    }

}
