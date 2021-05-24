package P14_2021052435;

import java.io.*;
import java.util.*;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class PersonsPrint {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        String fileName = "EarnMoney/src/main/java/P14_2021052435/抽奖名单.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                String[] personLine = readLine.split(" ");
                personList.add(new Person(Integer.parseInt(personLine[0]),personLine[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }
}

class Person {
    public int personID;
    public String name;

    public Person(int personID, String name) {
        this.personID = personID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", name='" + name + '\'' +
                '}';
    }
}