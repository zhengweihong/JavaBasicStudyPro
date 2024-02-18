package P13_Builder;

/**
 * @author : ZWH
 * @date : 2024/02/18
 * @Description : 构建器模式，测试
 */
public class Main {
    public static void main(String[] args) {
        Cat miaomiao = new Cat.CatBuilder()
                .basicInfo(1, "miaomiao", 3)
                .weight(8)
                .location(5, 5)
                .build();
        System.out.println(miaomiao);
    }
}
