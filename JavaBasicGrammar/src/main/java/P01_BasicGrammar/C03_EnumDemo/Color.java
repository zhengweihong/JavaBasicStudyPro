package P01_BasicGrammar.C03_EnumDemo;

/**
 * @author : ZWH 2021/4/26
 * @version : 1.0
 */
public enum Color {

    RED("red"),
    GREEN("green"),
    BLUE("blue");

    private String name;

    Color(String name){
        this.name = name;
    }
}
