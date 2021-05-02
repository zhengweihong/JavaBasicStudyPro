package P03_2021050260.Q01;

/**
 * @author : ZWH 2021/5/2
 * @version : 1.0
 */
public class Student {
    private int stuId;
    private String name;
    private int stuClass;
    private int math;
    private int eng;
    private int com;
    private double average;

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", name='" + name + '\'' +
                ", stuClass=" + stuClass +
                ", math=" + math +
                ", eng=" + eng +
                ", com=" + com +
                ", average=" + average +
                '}';
    }

    public Student(int stuId, String name, int stuClass) {
        this.stuId = stuId;
        this.name = name;
        this.stuClass = stuClass;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStuClass() {
        return stuClass;
    }

    public void setStuClass(int stuClass) {
        this.stuClass = stuClass;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getCom() {
        return com;
    }

    public void setCom(int com) {
        this.com = com;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
