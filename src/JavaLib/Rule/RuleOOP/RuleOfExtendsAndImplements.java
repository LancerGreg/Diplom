package JavaLib.Rule.RuleOOP;

import JavaLib.Data.DataClass;
import JavaLib.Data.DataInterface;
import JavaLib.Token.TokenOOP;
import JavaLib.Token.TokenOfOperation;

import java.util.ArrayList;

//клас на проверку правильного написания implement i extend
public class RuleOfExtendsAndImplements {

    /**
     * идет поиск токена extend или implement, проверка на то что следущий токен является nameClass или nameInterface,
     * и предедущие токены соотвествуют определению к класу
     *
     * @param splitCodeBySpace список всех токенов
     * @param massage текущий токен
     * @param xstay позиция строки токенна
     * @param ystay позиция токена в строке
     * @return тру если правильно инициализовали implement i extend
     */
    public static boolean checkSyntacticClass(ArrayList<ArrayList<String>> splitCodeBySpace,
                                              String massage, int xstay, int ystay) {

        if (massage.equals(TokenOOP.stringExtends)) {
            if (!(splitCodeBySpace.get(xstay).get(ystay - 2).equals(TokenOOP.stringClass) ||
                    splitCodeBySpace.get(xstay).get(ystay - 2).equals(TokenOOP.stringImplements))) {
                System.out.println("Error(" + (xstay) + "," + (ystay - 2) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay - 2) + "\" expected token class");
                return false;
            }
            boolean flag = false;
            for (int i = 0; i < DataClass.getMyData().size(); i++) {
                if (splitCodeBySpace.get(xstay).get(ystay + 1).equals(DataClass.getMyData().get(i).getName())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("Error(" + xstay + "," + (ystay + 1) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay + 1) + "\" expected some class");
                return false;
            }
            if (!(splitCodeBySpace.get(xstay).get(ystay + 2).equals(TokenOfOperation.bodyOperationOpen) ||
                    splitCodeBySpace.get(xstay).get(ystay + 2).equals(TokenOOP.stringImplements))) {
                System.out.println("Error(" + xstay + "," + (ystay + 2) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay + 2) + "\" expected of open block or implements");
                return false;
            }

        }
        if (massage.equals(TokenOOP.stringImplements)){
            if (!(splitCodeBySpace.get(xstay).get(ystay - 2).equals(TokenOOP.stringClass) ||
                    splitCodeBySpace.get(xstay).get(ystay - 2).equals(TokenOOP.stringExtends))) {
                System.out.println("Error(" + (xstay) + "," + (ystay - 2) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay - 2) + "\" expected token class");
                return false;
            }
            boolean flag = false;
            for (int i = 0; i < DataClass.getMyData().size(); i++) {
                if (splitCodeBySpace.get(xstay).get(ystay + 1).equals(DataInterface.getMyData().get(i).getName())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("Error(" + xstay + "," + (ystay + 1) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay + 1) + "\" expected some interface");
                return false;
            }
            if (!(splitCodeBySpace.get(xstay).get(ystay + 2).equals(TokenOfOperation.bodyOperationOpen) ||
                    splitCodeBySpace.get(xstay).get(ystay + 2).equals(TokenOOP.stringExtends) ||
                    splitCodeBySpace.get(xstay).get(ystay + 2).equals(TokenOfOperation.stringSeparator))) {
                System.out.println("Error(" + xstay + "," + (ystay + 2) + ") java \"" +
                        splitCodeBySpace.get(xstay).get(ystay + 2) + "\" expected of open block or implements");
                return false;
            }
        }

        return true;
    }
}
