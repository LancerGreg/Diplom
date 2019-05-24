package JavaLib.Rule.RuleCore;

import JavaLib.Data.Data;
import JavaLib.Token.TokenMath;
import JavaLib.Token.TokenOOP;
import JavaLib.Token.TokenOfOperation;
import JavaLib.Token.TokenTypeData;

import java.util.ArrayList;
import java.util.Arrays;

public class RuleOfFunction {

    /**
     * @return список токенов - операндов
     */
    public static ArrayList<String> tokenByRuleByDataType() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenOOP.tokenForRulesOfFunction()));

        return stringArrayList;
    }

    /**
     * проверка на правильное инициацию функции(типизировану и войд)
     *
     * @param splitCodeBySpace список всех токенов
     * @param massage          текущий токен
     * @param xstay            позиция строки токенна
     * @param ystay            позиция токена в строке
     * @return тру если инициация функции правильная
     */
    public static boolean checkFunction(ArrayList<ArrayList<String>> splitCodeBySpace,
                                        String massage, int xstay, int ystay) {
        ArrayList<Data> listDataObject = Data.addAllObject(splitCodeBySpace);
        ArrayList<Data> listDataObjectFromSecondOrder = Data.addAllObject(splitCodeBySpace);

        if (massage.equals(TokenTypeData.stringVoid)) {
            //правильность написание до войд функции
//            for (int i = 0; i < ystay; i++) {
//                boolean flag = false;
//                for (int j = 0; j < tokenByRuleByDataType().size(); j++) {
//                    if (splitCodeBySpace.get(xstay).get(i).equals(tokenByRuleByDataType().get(j))) {
//                        flag = true;
//                        break;
//                    }
//                }
//                if (!flag) {
//                    System.out.println("Error(" + xstay + "," + (i) + ") java \"" +
//                            splitCodeBySpace.get(xstay).get(i) + "\" expected other void classification");
//                    return false;
//                }
//            }
            //короче, я закоментировал, ибо есть уже проверка раньше, есил будет ошибка, то розкоментируй

            //правильность написание после войд функции
            boolean flag = false;
            for (int j = 0; j < listDataObject.size(); j++) {
                if (listDataObject.get(j).getType().equals(TokenTypeData.stringVoid) &&
                        listDataObject.get(j).getPositionX() == xstay &&
                        listDataObject.get(j).getPositionY() == ystay + 1) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("Error(" + xstay + "," + (ystay + 1) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay + 1) + "\" expected name void");
                return false;
            }

            //присвоение всех локальных даных методу
            for (int i = 0; i < listDataObject.size(); i++) {
                if (listDataObject.get(i).getPositionX() == xstay) {
                    listDataObjectFromSecondOrder.add(listDataObject.get(i));
                }
            }
            for (int i = 0; i < listDataObject.size(); i++) {
                if (listDataObject.get(i).getPositionX() == xstay &&
                        listDataObject.get(i).getType().equals(TokenTypeData.stringVoid)) {
                    listDataObject.get(i).setLocalVar(listDataObjectFromSecondOrder);
                }
            }
        } else if (isObject(listDataObject, massage, xstay, ystay)) {
            //проверка на функцию
            if (splitCodeBySpace.get(xstay).get(ystay + 1).equals(TokenOfOperation.giveOperationOpen)) {
                for (int i = 0; i < listDataObject.size(); i++) {
                    if (listDataObject.get(i).getPositionX() == xstay) {
                        listDataObjectFromSecondOrder.add(listDataObject.get(i));
                    }
                }
                for (int i = 0; i < listDataObject.size(); i++) {
                    if (listDataObject.get(i).getPositionX() == xstay &&
                            listDataObject.get(i).getPositionY() == ystay) {
                        listDataObject.get(i).setLocalVar(listDataObjectFromSecondOrder);
                    }
                }
                if (!splitCodeBySpace.get(xstay).get(splitCodeBySpace.get(xstay).size() - 1).equals(TokenOfOperation.bodyOperationOpen)){
                    System.out.println("Error(" + xstay + "," + (splitCodeBySpace.get(xstay).size() - 1) + ") java \"" +
                            splitCodeBySpace.get(xstay).get(splitCodeBySpace.get(xstay).size() - 1) +
                            "\" token \"{\" for open body's method");
                    return false;
                }
                if (!splitCodeBySpace.get(xstay).get(splitCodeBySpace.get(xstay).size() - 2).equals(TokenOfOperation.giveOperationClose)) {
                    System.out.println("Error(" + xstay + "," + (splitCodeBySpace.get(xstay).size() - 2) + ") java \"" +
                            splitCodeBySpace.get(xstay).get(splitCodeBySpace.get(xstay).size() - 2) +
                            "\" token \")\" for close given params method");
                    return false;
                }
            }//роверка написание после метода TODO
//            else if (!splitCodeBySpace.get(xstay).get(ystay + 1).equals(TokenOfOperation.equals) &&
//                    !splitCodeBySpace.get(xstay).get(ystay + 1).equals(TokenOfOperation.finishedOperation) &&
//                    !Data.returnDataFromPosition(listDataObject, xstay, ystay).getType().equals(TokenOOP.stringClass)) {
//                System.out.println("Error(" + xstay + "," + (ystay + 1) + ") java \"" +
//                        splitCodeBySpace.get(xstay).get(ystay + 1) + ": expected right finished initialization var");
//                return false;
//            }
        }

        return true;
    }

    //проверка является ли меседж обектом
    private static boolean isObject(ArrayList<Data> listDataObject, String massage, int xstay, int ystay) {
        for (Data aListDataObject : listDataObject) {
            if (massage.equals(aListDataObject.getName())
                    && xstay == aListDataObject.getPositionX() && aListDataObject.getPositionY() == ystay)
                return true;
        }
        return false;
    }

}
