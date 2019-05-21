package JavaLib.Rule;

import JavaLib.Rule.RuleCore.RuleOfFunction;
import JavaLib.Rule.RuleCore.RuleOfName;
import JavaLib.Rule.RuleCore.RuleOfStrongTyping;
import JavaLib.Rule.RuleOOP.RuleEncapsulation;
import JavaLib.Rule.RuleOOP.RuleOfClass;
import JavaLib.Rule.RuleOOP.RuleOfExtendsAndImplements;
import JavaLib.Rule.RuleOOP.RuleOfStaticAndFinal;

import java.util.ArrayList;

// клас для проверки всех правил
public class JavaRules {

    /**
     * @param splitCodeBySpace список со всеми токкнами
     * @return тру если все правила были соблюдены
     */
    public static boolean JavaRules(ArrayList<ArrayList<String>> splitCodeBySpace) {
        for (int i = 0; i < splitCodeBySpace.size(); i++) {
            for (int j = 0; j < splitCodeBySpace.get(i).size(); j++) {
                //проверка на название начинатеся на букввы
                if (!RuleOfName.checkName(splitCodeBySpace.get(i).get(j), i + 1, j + 1)) return false;

                //проверка на правильное описание класса
                if (!RuleOfClass.checkSyntacticClass(splitCodeBySpace,
                        splitCodeBySpace.get(i).get(j), i, j)) return false;

                //проверка на инкапсуляцию
                if (!RuleEncapsulation.checkSyntacticEncapsulation(splitCodeBySpace,
                        splitCodeBySpace.get(i).get(j), i, j)) return false;

                //проверка на static i final
                if (!RuleOfStaticAndFinal.checkSyntacticEncapsulation(splitCodeBySpace,
                        splitCodeBySpace.get(i).get(j), i, j)) return false;

                //проверка на extend i implement
                if (!RuleOfExtendsAndImplements.checkSyntacticClass(splitCodeBySpace,
                        splitCodeBySpace.get(i).get(j), i, j)) return false;

                //проверка на строгую типизацию
                if (!RuleOfStrongTyping.checkStrongTyping(splitCodeBySpace,
                        splitCodeBySpace.get(i).get(j), i, j)) return false;

                //проверка на правильную инициацию метода
                if (!RuleOfFunction.checkFunction(splitCodeBySpace,
                        splitCodeBySpace.get(i).get(j), i, j)) return false;
            }
        }

        return true;
    }

}
