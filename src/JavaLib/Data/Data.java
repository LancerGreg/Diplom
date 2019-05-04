package JavaLib.Data;

import JavaLib.Token.TokenOOP;
import JavaLib.Token.TokenTypeData;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.ArrayList;
import java.util.Arrays;

/*
клас для хранение росподиленіх обектов кода
 */
public class Data  {

    private String name;
    private String type;
    private static ArrayList<Data> myData;

    public Data() {
    }

    public Data(String name) {
        this.name = name;
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

    public static ArrayList<Data> getMyData() {
        return myData;
    }

    public static void setMyData(ArrayList<Data> myData) {
        Data.myData = myData;
    }

    /**
     *
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
     * @throws ClassNotFoundException трай кетч для проверки подлености класа
     */
    public static ArrayList<Data> addAllObject(ArrayList<ArrayList<String>> splitCodeBySpace) throws ClassNotFoundException {
        ArrayList<Data> listObject = new ArrayList<>();
        for (int i = 0; i < splitCodeBySpace.size(); i++) {
            for (int j = 0; j < splitCodeBySpace.get(i).size(); j++) {
                for (int k = 0; k < tokenByData().size(); k++) {
                    if (splitCodeBySpace.get(i).get(j).equals(tokenByData().get(k))){
                        switch (tokenByData().get(k)){
                            case TokenTypeData.stringBoolean:{
                                listObject.add(new DataBoolean(splitCodeBySpace.get(i).get(j + 1), false));
                                DataBoolean.getMyData().add(new DataBoolean(splitCodeBySpace.get(i).get(j + 1), false));
                                break;
                            }
                            case TokenTypeData.stringByte:{
                                listObject.add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                DataNum.getMyData().add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                break;
                            }
                            case TokenTypeData.stringChar:{
                                listObject.add(new DataChar(splitCodeBySpace.get(i).get(j + 2), '0'));
                                DataChar.getMyData().add(new DataChar(splitCodeBySpace.get(i).get(j + 2), '0'));
                                break;
                            }
                            case TokenTypeData.stringShort:{
                                listObject.add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                break;
                            }
                            case TokenTypeData.stringInt:{
                                listObject.add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                DataNum.getMyData().add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                break;
                            }
                            case TokenTypeData.stringLong:{
                                listObject.add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                DataNum.getMyData().add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                break;
                            }
                            case TokenTypeData.stringFloat:{
                                listObject.add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                DataNum.getMyData().add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                break;
                            }
                            case TokenTypeData.stringDouble:{
                                listObject.add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                DataNum.getMyData().add(new DataNum(splitCodeBySpace.get(i).get(j + 1), 0));
                                break;
                            }
                            case TokenTypeData.stringString:{
                                listObject.add(new DataString(splitCodeBySpace.get(i).get(j + 1), ""));
                                DataString.getMyData().add(new DataString(splitCodeBySpace.get(i).get(j + 1), ""));
                                break;
                            }
                            case TokenOOP.stringClass:{
                                listObject.add(new DataClass(splitCodeBySpace.get(i).get(j + 1)));
                                DataClass.getMyData().add(new DataClass(splitCodeBySpace.get(i).get(j + 1)));
                                break;
                            }
                            case TokenTypeData.stringVoid:{
                                listObject.add(new DataVoid(splitCodeBySpace.get(i).get(j + 1)));
                                DataVoid.getMyData().add(new DataVoid(splitCodeBySpace.get(i).get(j + 1)));
                                break;
                            }
                            case TokenOOP.stringInterface:{
                                listObject.add(new DataInterface(splitCodeBySpace.get(i).get(j + 1)));
                                DataClass.getMyData().add(new DataInterface(splitCodeBySpace.get(i).get(j + 1)));
                                break;
                            }
                            default:{
                                listObject.add(new DataClass(splitCodeBySpace.get(i).get(j)));
                                DataClass.getMyData().add(new DataClass(splitCodeBySpace.get(i).get(j + 1)));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return listObject;
    }

}
