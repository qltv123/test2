import java.util.Scanner;

public class Map {
    int height;
    int width;
    Player player;
    Box box;
    storagePoint storagePoint;

    public Map(int height, int width){
        this.height = height;
        this.width = width;
        player = new Player(2,3);
        box = new Box(3,3);
        storagePoint = new storagePoint(4,3);
    }

    public void run(){
        this.move(); //Di chuyển Player và Box
        this.clamp(); //check biên của player và box
        this.printMap(); // In map

        if(     this.box.x == this.storagePoint.x &&
                this.box.y == this.storagePoint.y){
            System.out.println("YOU WON!!!");
            System.exit(0);
        }
    }

    private void move() {
        Scanner inp = new Scanner(System.in);
        String input = inp.next();
        if (input.equalsIgnoreCase("D")){
            this.player.y++;
        }
        if (input.equalsIgnoreCase("A")){
            this.player.y--;
        } if (input.equalsIgnoreCase("W")){
            this.player.x--;
        } if (input.equalsIgnoreCase("S")){
            this.player.x++;
        } if (input.equalsIgnoreCase("D") && this.player.x == this.box.x && this.player.y == this.box.y){
            this.box.y++;
        } if (input.equalsIgnoreCase("A") && this.player.x == this.box.x && this.player.y == this.box.y){
            this.box.y--;
        } if (input.equalsIgnoreCase("W") && this.player.x == this.box.x && this.player.y == this.box.y){
            this.box.x--;
        } if (input.equalsIgnoreCase("S") && this.player.x == this.box.x && this.player.y == this.box.y){
            this.box.x++;
        }
    }

    //Check biên
    private void clamp() {
        // Biên Trên
        if(this.player.x <0){
            this.player.x = 0;
        } if (this.box.x <0){
            this.box.x = 0;
            this.player.x = this.box.x + 1;
        }

        //Biên dưới
        if (this.player.x > this.height - 1){
            this.player.x = this.height - 1;
        } if (this.box.x > this.height - 1){
            this.box.x = this.height - 1;
            this.player.x = this.box.x -1;
        }

        //Biên cạnh trái
        if(this.player.y < 0){
            this.player.y = 0;
        } if(this.box.y < 0){
            this.box.y = 0;
            this.player.y = this.box.y + 1;
        }

        //Biên cạnh phải
        if(this.player.y > this.width -1){
            this.player.y = this.width - 1;
        } if(this.box.y > this.width -1){
            this.box.y = this.width - 1;
            this.player.y = this.box.y - 1;
        }
    }

    public void printMap(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if( i == player.x && j == player.y){
                    System.out.print(" P ");
                } else if (i == box.x && j == box.y){
                    System.out.print(" B ");
                } else if(i == storagePoint.x && j == storagePoint.y){
                    System.out.print(" S ");
                }
                else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
