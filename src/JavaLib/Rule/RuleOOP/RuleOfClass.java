package JavaLib.Rule.RuleOOP;

import JavaLib.Token.Token;
import JavaLib.Token.TokenOOP;
import JavaLib.Token.TokenOfOperation;

import java.util.ArrayList;

public class RuleOfClass {

    /**
     * идет поиск токена class, проверка на то что следущий токен является nameClass, и предедущие токены
     соотвествуют определению к класу
     *
     * @param splitCodeBySpace список всех токенов
     * @param massage текущий токен
     * @param xstay позиция строки токенна
     * @param ystay позиция токена в строке
     * @return тру если правильно инициализовали класс
     */
    public static boolean checkSyntacticClass(ArrayList<ArrayList<String>> splitCodeBySpace,
                                              String massage, int xstay, int ystay) {

        if (massage.equals(TokenOOP.stringClass)) {
            for (int i = 0; i < Token.allTokenArrayList().size(); i++) {
                if (splitCodeBySpace.get(xstay).get(ystay + 1).equals(Token.allTokenArrayList().get(i))) {
                    System.out.println("Error(" + xstay + "," + (ystay + 1) + ") java \"" +
                            splitCodeBySpace.get(xstay).get(ystay + 1) + "\" expected class name");
                    return false;
                }
            }

            for (int i = ystay - 1; i >= 0; i--) {
                boolean flag = false;
                for (int j = 0; j < TokenOOP.tokenForClass().length; j++) {
                    if (splitCodeBySpace.get(xstay).get(i).equals(TokenOOP.tokenForClass()[j])){
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    System.out.println("Error(" + xstay + "," + i + ") java \"" +
                            splitCodeBySpace.get(xstay).get(i) + "\" expected other class's classification");
                    return false;
                }
            }

            if (!(splitCodeBySpace.get(xstay).get(ystay + 2).equals(TokenOOP.stringExtends) ||
                    splitCodeBySpace.get(xstay).get(ystay + 2).equals(TokenOfOperation.bodyOperationOpen) ||
                    splitCodeBySpace.get(xstay).get(ystay + 2).equals(TokenOOP.stringImplements))){
                System.out.println("Error(" + xstay + "," + (ystay + 2) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay + 2) + "\" expected of open block or extends or implements");
                return false;
            }
        }

        return true;
    }
}
