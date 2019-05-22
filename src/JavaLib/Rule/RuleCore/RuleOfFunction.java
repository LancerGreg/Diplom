package JavaLib.Rule.RuleCore;

import JavaLib.Data.Data;
import JavaLib.Token.TokenTypeData;

import java.util.ArrayList;

public class RuleOfFunction {

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


                //присвоение всех локальных даных методу
                for (int i = 0; i < listDataObject.size(); i++) {
                    if (listDataObject.get(i).getPositionX() == xstay) {
                        listDataObjectFromSecondOrder.add(listDataObject.get(i));
                    }
                }
                for (int i = 0; i < listDataObject.size(); i++) {
                    if (listDataObject.get(i).getPositionX() == xstay &&
                            listDataObject.get(i).getType().equals(TokenTypeData.stringVoid)){
                        listDataObject.get(i).setLocalVar(listDataObjectFromSecondOrder);
                    }
                }
            }

        return true;
    }


}
