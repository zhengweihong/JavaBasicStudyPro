package P03_2021050260.Q01;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

/**
 * @author : ZWH 2021/5/2
 * @version : 1.0
 */
public class TotalOutput {
    public static void main(String[] args) {
        String filename1 = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/EarnMoney/src/main/java/P02_20210502XYWX60/Q01/student.txt";
        String filename2 = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/EarnMoney/src/main/java/P02_20210502XYWX60/Q01/score.txt";
        String filename = "/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/EarnMoney/src/main/java/P02_20210502XYWX60/Q01/total.txt";
        HashMap<Integer, Student> studentHashMap = new HashMap<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename1));
            String oneLineData = null;
            while ((oneLineData = br.readLine()) != null) {
                String[] stu = oneLineData.split(" ");
                studentHashMap.put(Integer.parseInt(stu[2]), new Student(Integer.parseInt(stu[2]), stu[0], Integer.parseInt(stu[1])));
            }

            br = new BufferedReader(new FileReader(filename2));
            while ((oneLineData = br.readLine()) != null) {
                String[] scores = oneLineData.split(" ");
                int stuId = Integer.parseInt(scores[0]);
                int math = Integer.parseInt(scores[1]);
                int eng = Integer.parseInt(scores[2]);
                int com = Integer.parseInt(scores[3]);
                double average = (math + eng + com) / 3.0;
                if (average >= 80) {
                    if (studentHashMap.containsKey(stuId)) {
                        Student student = studentHashMap.get(stuId);
                        student.setMath(math);
                        student.setEng(eng);
                        student.setCom(com);
                        student.setAverage(average);
                    }
                } else {
                    if (studentHashMap.containsKey(stuId)) {
                        studentHashMap.remove(stuId);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename));
            Set<Integer> integers = studentHashMap.keySet();
            for (Integer stuId : integers) {
                Student stu = studentHashMap.get(stuId);
                bw.write(stuId + " " + stu.getName() + " " + stu.getStuClass() + " " + stu.getMath() + " " + stu.getEng() + " " + stu.getCom() + " " + String.format("%.2f", stu.getAverage()));
                bw.newLine();
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
