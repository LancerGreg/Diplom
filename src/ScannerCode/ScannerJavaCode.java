package ScannerCode;

import JavaLib.Token.Token;
import JavaLib.Token.TokenMath;
import JavaLib.Token.TokenOfOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
класс для обноружение токенов в коде
 */
public class ScannerJavaCode {

    /**
     * @return список токенов которые пишутся слитно
     */
    public static ArrayList<String> tokenByRuleByDataType() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenMath.tokenForTwiceOperand()));
        stringArrayList.addAll(Arrays.asList(TokenOfOperation.tokenForTwiceOperand()));
        stringArrayList.addAll(Arrays.asList(TokenOfOperation.tokenForTwiceOperand()));


        return stringArrayList;
    }

    /**
     * строка кода разбивается на одельные блоки стрингов и запсуется на масив стрингов
     идет замена всех табуляций на пробелы
     запись масива стрингов на лист стрингов
     *
     * @param codeNo стринг кода который приходит из-вне
     * @return список в котором код разбитый на строки
     */
    public static ArrayList<String> splitCodeByEnter(String codeNo){
        ArrayList<String> splitCode = new ArrayList<>();
        String[] codeSplitByEnter = codeNo.replaceAll("\t", " ").split("\n");
        Collections.addAll(splitCode, codeSplitByEnter);
        return splitCode;
    }

    /**
     * разбиваем некоторые строки на токены, ибо некоторые могут быть написано слитно
     *
     * @param splitCodeByEnter список в котором код разбитый на строки
     * @return список в которому все токены разделены друг от друга пробелами
     */
    public static ArrayList<String> splitCodeByToken(ArrayList<String> splitCodeByEnter){
        for (int i = 0; i < splitCodeByEnter.size(); i++) {
            splitCodeByEnter.set(i, Token.replaceTokenBySpace(splitCodeByEnter.get(i)));
        }

        return splitCodeByEnter;
    }

    /**
     * лист строк разбивается на одельные блоки в котором есть листы с разбитыми строками на пробелы
     *
     * @param splitCodeByToken список в которому все токены разделены друг от друга пробелами
     * @return список всех токенов разбиты на каждой строке
     */
    public static ArrayList<ArrayList<String>> splitCodeBySpace(ArrayList<String> splitCodeByToken){
        ArrayList<ArrayList<String>> splitCode = new ArrayList<>();
        for (String splitCodeByTokens : splitCodeByToken) {
            String[] splitCodeBySpace = splitCodeByTokens.split(" ");
            ArrayList<String> arraySplitCodeBySpace = new ArrayList<>();
            Collections.addAll(arraySplitCodeBySpace, splitCodeBySpace);
            arraySplitCodeBySpace.remove("");
            splitCode.add(arraySplitCodeBySpace);
        }

        return splitCode;
    }

}
