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
                                            String massage, int xstay, int ystay) {

        ArrayList<Data> listDataObject = Data.addAllObject(splitCodeBySpace);
        if (massage.equals(TokenOfOperation.equals)) {
            for (int i = 0; i < listDataObject.size(); i++) {
                if (listDataObject.get(i).getPositionX() == xstay &&
                        listDataObject.get(i).getPositionY() == ystay - 1 &&
                        listDataObject.get(i).getName() != null) {
                    for (int k = i; k < listDataObject.size(); k++) {
                        if (!listDataObject.get(k).getType().equals(listDataObject.get(i).getType())){
                            if (listDataObject.get(k).getPositionX() != listDataObject.get(i).getPositionX()) break;
                            else {
                                System.out.println("Error(" + xstay + "," + listDataObject.get(k).getPositionY() + ") java \"" +
                                        listDataObject.get(k).getData() + "\" have type " + listDataObject.get(k).getType()
                                        + " expected type: " + listDataObject.get(i).getType());
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

}
