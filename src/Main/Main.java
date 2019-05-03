package Main;

public class Main {

    public static void main(String[] args) {

        System.out.println("TEST BY showSplitCodeByEnter\n****************************" +
                "\n****************************");
        Test.showSplitCodeByEnter();
        System.out.println("TEST BY showSplitCodeByToken\n****************************" +
                "\n****************************");
        Test.showSplitCodeByToken();
        System.out.println("TEST BY showSplitCodeBySpace\n****************************" +
                "\n****************************");
        Test.showSplitCodeBySpace();
        System.out.println("TEST BY rules\n****************************" +
                "\n****************************");
        Test.showRules();
        System.out.println("TEST BY all object\n****************************" +
                "\n****************************");
        try {
            Test.showAllObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
