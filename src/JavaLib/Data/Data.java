package JavaLib.Data;

import JavaLib.Token.*;

import java.util.ArrayList;
import java.util.Arrays;

/*
клас для хранение росподиленіх обектов кода
 */
public class Data {

    private String name;
    private String type;
    private Object data;
    private int positionX;
    private int positionY;

    public static ArrayList<Data> myData = new ArrayList<>();

    public Data() {
    }

    public Data(String name, Object data, int positionX, int positionY) {
        this.name = name;
        this.data = data;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * @return список всех возможных токенов которые будут класыфикувать наши обеткы в коде
     */
    public static ArrayList<String> tokenByData() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(Arrays.asList(TokenTypeData.tokenByType()));
        stringArrayList.add(TokenOOP.stringClass);

        return stringArrayList;
    }

    //TODO :: if token
    //TODO :: значение

    /**
     * расподиление всех обектов та внесення в спиок
     *
     * @param splitCodeBySpace лист
     * @return список всех обектов кода
     */
    public static ArrayList<Data> addAllObject(ArrayList<ArrayList<String>> splitCodeBySpace) {
        ArrayList<Data> listObject = new ArrayList<>();
        for (int i = 0; i < splitCodeBySpace.size(); i++) {
            boolean flagCloseChar = false;
            boolean flagCloseString = false;
            boolean flagToken = false;
            for (int j = 0; j < splitCodeBySpace.get(i).size(); j++) {
                if (!flagToken) {
                    //добавление чаров в обекты
                    if (splitCodeBySpace.get(i).get(j).equals(TokenOfOperation.stringIndicatorChar)) {
                        if (!flagCloseChar) {
                            if (!splitCodeBySpace.get(i).get(j + 2).equals(TokenOfOperation.stringIndicatorChar)) {
                                System.out.println("Error(" + i + "," + (j + 2) + ") java \"" +
                                        splitCodeBySpace.get(i).get(j + 2) + "\" expected: " + "'");
                                System.exit(0);
                            }
                            flagCloseChar = true;
                            char symbol = splitCodeBySpace.get(i).get(j + 1).charAt(0);
                            listObject.add(new DataChar(null, symbol, i, j + 1));
                            DataChar.myData.add(new DataChar(null, symbol, i, j + 1));
                            break;
                        } else flagCloseChar = false;
                    }
                    //добавление строк в обекты
                    if (splitCodeBySpace.get(i).get(j).equals(TokenOfOperation.stringIndicatorString)) {
                        if (!flagCloseString) {
                            if (!splitCodeBySpace.get(i).get(j + 2).equals(TokenOfOperation.stringIndicatorString)) {
                                System.out.println("Error(" + i + "," + (j + 2) + ") java \"" +
                                        splitCodeBySpace.get(i).get(j + 2) + "\" expected: " + "'");
                                System.exit(0);
                            }
                            flagCloseString = true;
                            String symbol = splitCodeBySpace.get(i).get(j + 1);
                            listObject.add(new DataString(null, symbol, i, j + 1));
                            DataString.myData.add(new DataString(null, symbol, i, j + 1));
                            break;
                        } else flagCloseString = false;
                    }
                    //булеанови обекты
                    if (splitCodeBySpace.get(i).get(j).equals(TokenTypeData.stringFalse) ||
                            splitCodeBySpace.get(i).get(j).equals(TokenTypeData.stringTrue)) {
                        boolean num = Boolean.parseBoolean(splitCodeBySpace.get(i).get(j));
                        listObject.add(new DataBoolean(null, num, i, j + 1));
                        DataBoolean.myData.add(new DataBoolean(null, num, i, j + 1));
                        break;
                    }
                    //добавление чисел в обекты
                    if (splitCodeBySpace.get(i).get(j).chars().allMatch(Character::isDigit)) {
                        try {
                            byte num = Byte.decode(splitCodeBySpace.get(i).get(j));
                            listObject.add(new DataNum(null, num, num, i, j));
                            DataNum.myData.add(new DataNum(null, num, num, i, j));
                            break;
                        } catch (IllegalArgumentException e) {
                            try {
                                short num = Short.decode(splitCodeBySpace.get(i).get(j));
                                listObject.add(new DataNum(null, num, num, i, j));
                                DataNum.myData.add(new DataNum(null, num, num, i, j));
                                break;
                            } catch (IllegalArgumentException ee) {
                                try {
                                    int num = Integer.decode(splitCodeBySpace.get(i).get(j));
                                    listObject.add(new DataNum(null, num, num, i, j));
                                    DataNum.myData.add(new DataNum(null, num, num, i, j));
                                    break;
                                } catch (IllegalArgumentException eee) {
                                    try {
                                        long num = Long.decode(splitCodeBySpace.get(i).get(j));
                                        listObject.add(new DataNum(null, num, num, i, j));
                                        DataNum.myData.add(new DataNum(null, num, num, i, j));
                                        break;
                                    } catch (IllegalArgumentException eeee) {
                                        try {
                                            float num = Float.parseFloat(splitCodeBySpace.get(i).get(j));
                                            listObject.add(new DataNum(null, num, num, i, j));
                                            DataNum.myData.add(new DataNum(null, num, num, i, j));
                                            break;
                                        } catch (IllegalArgumentException eeeee) {
                                            try {
                                                double num = Double.parseDouble(splitCodeBySpace.get(i).get(j));
                                                listObject.add(new DataNum(null, num, num, i, j));
                                                DataNum.myData.add(new DataNum(null, num, num, i, j));
                                                break;
                                            } catch (IllegalArgumentException eeeeee) {
                                                System.out.println("Have a problem with big num : ("
                                                        + i + "," + j + ") " + splitCodeBySpace.get(i).get(j));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (int k = 0; k < tokenByData().size(); k++) {
                        if (splitCodeBySpace.get(i).get(j).equals(tokenByData().get(k))) {
                            int positionNameVal = 0;
                            boolean flagName;
                            for (int l = j; l < splitCodeBySpace.get(i).size(); l++) {
                                flagName = false;
                                for (int m = 0; m < Token.allTokenArrayList().size(); m++) {
                                    if (Token.allTokenArrayList().get(m).equals(splitCodeBySpace.get(i).get(l))){
                                        flagName = false;
                                        break;
                                    }else{
                                        positionNameVal = l;
                                        flagName = true;
                                    }
                                }
                                if (flagName) break;
                            }
                            switch (tokenByData().get(k)) {
                                case TokenTypeData.stringBoolean: {
                                    listObject.add(new DataBoolean(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    DataBoolean.myData.add(new DataBoolean(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    break;
                                }
                                case TokenTypeData.stringByte: {
                                    listObject.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    DataNum.myData.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    break;
                                }
                                case TokenTypeData.stringChar: {
                                    listObject.add(new DataChar(splitCodeBySpace.get(i).get(positionNameVal), 0, i, positionNameVal));
                                    DataChar.myData.add(new DataChar(splitCodeBySpace.get(i).get(positionNameVal), 0, i, positionNameVal));
                                    break;
                                }
                                case TokenTypeData.stringShort: {
                                    listObject.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    DataNum.myData.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    break;
                                }
                                case TokenTypeData.stringInt: {
                                    listObject.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    DataNum.myData.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    break;
                                }
                                case TokenTypeData.stringLong: {
                                    listObject.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    DataNum.myData.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    break;
                                }
                                case TokenTypeData.stringFloat: {
                                    listObject.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    DataNum.myData.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    break;
                                }
                                case TokenTypeData.stringDouble: {
                                    listObject.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    DataNum.myData.add(new DataNum(splitCodeBySpace.get(i).get(positionNameVal), 0, 0, i, positionNameVal));
                                    break;
                                }
                                case TokenTypeData.stringString: {
                                    listObject.add(new DataString(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    DataString.myData.add(new DataString(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    break;
                                }
                                case TokenOOP.stringClass: {
                                    listObject.add(new DataClass(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    DataClass.myData.add(new DataClass(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    break;
                                }
                                case TokenTypeData.stringVoid: {
                                    listObject.add(new DataVoid(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    DataVoid.myData.add(new DataVoid(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    break;
                                }
                                case TokenOOP.stringInterface: {
                                    listObject.add(new DataInterface(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    DataClass.myData.add(new DataInterface(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    break;
                                }
                                default: {
                                    listObject.add(new DataClass(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    DataClass.myData.add(new DataClass(splitCodeBySpace.get(i).get(positionNameVal), null, i, positionNameVal));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return listObject;
    }

}
