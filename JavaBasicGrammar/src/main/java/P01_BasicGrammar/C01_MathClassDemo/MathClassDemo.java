package P01_BasicGrammar.C01_MathClassDemo;

/**
 * @author : ZWH 2021/4/26
 * @version : 1.0
 */
public class MathClassDemo {
    public static void main(String[] args) {
        System.out.println(Math.abs(-1));//|-1|
        System.out.println(Math.sqrt(2));//√
        System.out.println(Math.ceil(-3.14));
        System.out.println(Math.floor(-3.14));
        System.out.println(Math.pow(2,3));//2^3

        Point p1 = new Point();
        p1.set(3,5);
        Point p2 = new Point();
        p2.set(2,4);
        System.out.println(p1.calcDistance(p2));
        p1.changePoint(p2);
        p1.show();
        p2.show();
    }
}

class Point {
    int x;
    int y;

    //设置二维的坐标点
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void show(){
        System.out.println("["+x+","+y+"]");
    }

    public double calcDistance(Point p){
        return Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
    }

    public void changePoint(Point p){
        int a = p.x;
        p.x = x;
        x = a;
        int b = p.y;
        p.y = y;
        y = b;
    }
}