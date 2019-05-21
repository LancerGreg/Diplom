package Main;

import JavaLib.Data.Data;
import JavaLib.Rule.JavaRules;

import java.util.ArrayList;

import static ScannerCode.ScannerJavaCode.*;

public class Test {

    public static String code =
            "class nameClass{\n" +
                    "\n" +
                    "\tpublic static final int i = 43453;\n" +
                    "\n" +
                    "\tpublic static String s = \" lol\";\n" +
                    "\n" +
                    "\tpublic static char c = \'c\';\n" +
                    "\n" +
                    "\tpublic static boolean b = true;\n" +
                    "\n" +
                    "\tprivate void nameVoid(int i; String s){\n" +
                    "\t\tSystem.out.println(i+s);\n" +
                    "\t}\n" +
                    "\n" +
                    "\tpublic static void main(String[] args){\n" +
                    "\t\tmainVoid(i, s);\n" +
                    "\t}\n" +
                    "\n" +
                    "}";

    private static ArrayList<String> splitCodeByEnter = splitCodeByEnter(code);
    private static ArrayList<String> splitCodeByToken = splitCodeByToken(splitCodeByEnter);
    private static ArrayList<ArrayList<String>> splitCodeBySpace = splitCodeBySpace(splitCodeByToken);


    public static void showSplitCodeByEnter() {
        for (int i = 0; i < splitCodeByEnter.size(); i++) {
            System.out.println(splitCodeByEnter.get(i));
        }
    }

    public static void showSplitCodeByToken() {
        for (int i = 0; i < splitCodeByToken.size(); i++) {
            System.out.println(splitCodeByToken.get(i));
        }
    }

    public static void showSplitCodeBySpace() {
        for (int i = 0; i < splitCodeBySpace.size(); i++) {
            for (int j = 0; j < splitCodeBySpace.get(i).size(); j++) {
                System.out.print(splitCodeBySpace.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void showAllObject() throws ClassNotFoundException {
        ArrayList<Data> addAllObject = Data.addAllObject(splitCodeBySpace);
        for (int i = 0; i < addAllObject.size(); i++) {
            System.out.println("Type - " + addAllObject.get(i).getType()
                    + "\t - Name - " + addAllObject.get(i).getName()
                    + "\t - Value - " + addAllObject.get(i).getData());
        }
    }

    public static void showRules() {
        System.out.println(JavaRules.JavaRules(splitCodeBySpace));
    }


}
