import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    GameTable bomb= new GameTable();
    String rawS;
    String colon;

    public void greeting(){

        System.out.println("Hello and welcome to mineSweeper!");
        System.out.println("");
        System.out.println("How to play:");
        System.out.println("Minesweeper is a game where mines are hidden behind some (?) marks.");
        System.out.println("Safe squares will be replaced with (X). ");
        System.out.println("You can use the letters and numbers to decide which (?) mark do you want to chose!");
        System.out.println("");
        System.out.println("What is the players name?");
        Player p1 = new Player(scan.next());
        System.out.println("Hello " + p1.getName() + " and good luck!!");
        System.out.println("");

    }
    public void mineField(){
        bomb.fillInvisibleTable();
    }
    public int play(){

        bomb.print();

        rawS = scan.next();
        colon = scan.next();


        if(!rawS.equals("a")&&!rawS.equals("b")&&!rawS.equals("c")&&!rawS.equals("d")){
            return -1;
        }
        else if(!colon.equals("1")&&!colon.equals("2")&&!colon.equals("3")&&!colon.equals("4")&&!colon.equals("5")){
            return -1;
        }
        else {
            colon= Integer.toString(Integer.parseInt(colon)-1);
            int result = bomb.choice(rawS, Integer.parseInt(colon));
            if (result == 0) {
                bomb.getGameTable()[bomb.getRawN()][Integer.parseInt(colon)] = " * ";
                bomb.print();
                return 0;
            } else {
                return 1;

            }
        }


    }

    public void playerChoiceLoop(){

        int c = 0;
        do {
            int decision = play();
            if (decision == 1) {
                c = 1;
            } else if (decision == 0) {
                System.out.println("You lost");
                c = 0;
            } else if (decision == -1) {
                System.out.println("please try again");
                c = 1;
            }
        }while(c==1);
    }

}

