
public class Program {
    public static void main(String[] args) {
        Map map = new Map(5,5);
        map.printMap();
        while(true){
            map.run();
        }
    }
}
