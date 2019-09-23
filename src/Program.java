import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Program {
    private static int x = 6 ;
    private static int y = 8;
    private static int turn = 4;
    private static char[][] map = new char[x][y];
    private static Target targets[]= new Target[3];
    public static int enemy = targets.length;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        while(true) {
            printMap();
            System.out.print("Fire: ");
            String[] input = sc.nextLine().split(" ");
            fire(input);
            checkTarget();
            System.out.println( enemy + " enemy left");
            System.out.println(turn + " rocket left");
            if(enemy < 1){
                System.out.println(" You win");
                System.exit(0);
            } if (turn < 1){
                System.out.println(" You lose");
                System.exit(0);
            }
        }
    }

    private static void checkTarget() {
        for (Target t : targets) {
            if (t != null) {
//                System.out.println("Not null: ");
//                System.out.println("Hint: " + t.get_x() + " " + t.get_y());
                return;
            } else {
                return;
            }
        }
        sc.close();
    }

    public static void fire(String[] input) {
        int fireX = Integer.parseInt(input[0]);
        int fireY = Integer.parseInt(input[1]);
        for (int i = 0; i < targets.length; i++ ) {
            if (targets[i] != null && targets[i].get_x() == fireX && targets[i].get_y() == fireY) {
                map[fireX][fireY] = 'O';
                targets[i] = null;
                turn--;
                enemy--;
                return;
            } else if (targets[i] != null && targets[i].get_x() != fireX && targets[i].get_y() != fireY){
                map[fireX][fireY] = 'X';
                turn--;
                return;
            }
        }

    }
    //
    private static void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++)
                System.out.print(map[i][j] + " ");
            System.out.print('\n');
        }
    }

    private static void initMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++)
                map[i][j] = '-';
        }
        for (int i = 0; i < targets.length ; i++) {
            targets[0] = new Target(1,2);
            targets[1] = new Target(2,2);
            targets[2] = new Target(3,2);
            System.out.println("Hint: " + targets[i].get_x() + " " + targets[i].get_y());
        }

    }

    public static class Target {
        int _x;
        int _y;
        public Target(int x, int y) {
            this._x = x;
            this._y = y;
        }

        public int get_x() {
            return _x;
        }

        public int get_y() {
            return _y;
        }

    }
}