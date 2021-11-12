package P99_20210924_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CombatantTest {
    public static void main(String[] args) {
        Map<String, Integer> winCounts = new HashMap<>();
        winCounts.put("Deadpool", 0);//times Deadpool win
        winCounts.put("Kingkong", 0);//times Kingkong win
        winCounts.put("Spiderman", 0);//times Spiderman win

        double hit_rate1 = 1.0 / 3;//Deadpool's hit rate
        double hit_rate2 = 1.0 / 2;//Kingkong's hit rate
        double hit_rate3 = 1.0;//Spiderman's hit rate

        //initialize three shooters in the three arguments conductor
        Combatant combatant1 = new Combatant("Deadpool", hit_rate1, true);
        Combatant combatant2 = new Combatant("Kingkong", hit_rate2, true);
        Combatant combatant3 = new Combatant("Spiderman", hit_rate3, true);

        int round = 10000;
        for (int i = 0; i < round; ++i) {
            System.out.println("Round " + (i + 1) + " :");

            ArrayList<Combatant> combatants = resurrection(combatant1, combatant2, combatant3);
            while (combatants.size() > 1) {
                Combatant shooter = combatants.get(0);
                combatants.remove(shooter);
                Combatant target = null;
                for (Combatant combatant : combatants) {
                    if (target == null || combatant.getHit_rate() > target.getHit_rate()) {
                        target = combatant;
                    }
                }
                shooter.ShootAtTarget(target);
                if (!target.isAlive()) {
                    combatants.remove(target);
                }
                combatants.add(shooter);
            }

            //在前边加个Map：key是name，value是赢的次数，当combatants只剩一个的时候直接拿name去加一
            if (combatants.size() == 1 && combatants.get(0).isAlive()) {
                String name = combatants.get(0).getName();
                winCounts.put(name, winCounts.get(name) + 1);
            }

            System.out.println();
        }
        //print the result
        System.out.println();
        System.out.println("After " + round + " battles");
        System.out.printf("The winning rate of %-10s is %23f", combatant1.getName(), (float) (winCounts.get(combatant1.getName()) * 1.0 / round));
        System.out.println();
        System.out.printf("The winning rate of %-10s is %23f", combatant2.getName(), (float) (winCounts.get(combatant2.getName()) * 1.0 / round));
        System.out.println();
        System.out.printf("The winning rate of %-10s is %23f", combatant3.getName(), (float) (winCounts.get(combatant3.getName()) * 1.0 / round));
        System.out.println();
    }

    //reset the game--make them all alive
    public static ArrayList<Combatant> resurrection(Combatant s1, Combatant s2, Combatant s3) {
        s1.setAlive(true);
        s2.setAlive(true);
        s3.setAlive(true);

        ArrayList<Combatant> combatants = new ArrayList<>(3);
        combatants.add(s1);
        combatants.add(s2);
        combatants.add(s3);
        return combatants;
    }
}

class Combatant { // design the shooter fields
    private String name;
    private double hit_rate;
    private boolean alive; // true = alive  and false = death

    public Combatant(String name, double hit_rate, boolean alive) {
        this.name = name;
        this.hit_rate = hit_rate;
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHit_rate() {
        return hit_rate;
    }

    public void setHit_rate(double hit_rate) {
        this.hit_rate = hit_rate;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void ShootAtTarget(Combatant target) { // shoot the target
        if (Math.random() <= this.hit_rate) { // once the random possibility is lower than the hit_rate, then the target
            target.setAlive(false);// get killed
            System.out.println(this.name + " killed " + target.getName());
        } else {
            System.out.println(this.name + " don't kill " + target.getName());
        }
    }
}
