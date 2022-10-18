import java.util.Random;

public class GameTable {
    Random rand = new Random();
    private final String[][] GameTable;
    private String[][] invisibleTable;
    int rawN = 0;

    public int getRawN() {
        return rawN;
    }

    public GameTable() {
        this.GameTable = new String[][]{
                {" ? ", " ? ", " ? ", " ? ", " ? "},
                {" ? ", " ? ", " ? ", " ? ", " ? "},
                {" ? ", " ? ", " ? ", " ? ", " ? "},
                {" ? ", " ? ", " ? ", " ? ", " ? "}
        };

        invisibleTable=  new String[4][5];
    }


    public String[][] getGameTable() {
        return GameTable;
    }

    public void fillInvisibleTable() {
        for (int i = 0; i < 7; i++) {
            int pos1 = rand.nextInt(3);
            int pos2 = rand.nextInt(4);
            while (invisibleTable[pos1][pos2]!=null) {
                pos1 = rand.nextInt(3);
                pos2 = rand.nextInt(4);
            }
            invisibleTable[pos1][pos2] = "*";
        }
    }
    public void print2(){
        for (int i=0; i<invisibleTable.length;i++){
            for(int j=0; j<invisibleTable[i].length;j++){
                System.out.print(invisibleTable[i][j]+ " ");
            }
            System.out.println();
        }

    }


    public void print() {
        System.out.println("   1   2   3   4   5");
        System.out.println("a " +GameTable[0][0] + "|" +GameTable[0][1] + "|"+ GameTable[0][2] + "|"+ GameTable[0][3] + "|"+ GameTable[0][4]);
        System.out.println("  ---+---+---+---+---");
        System.out.println("b "+ GameTable[1][0] + "|" +GameTable[1][1] + "|"+ GameTable[1][2] + "|"+ GameTable[1][3] + "|"+ GameTable[1][4]);
        System.out.println("  ---+---+---+---+---");
        System.out.println("c "+GameTable[2][0] + "|" +GameTable[2][1] + "|"+ GameTable[2][2] + "|"+ GameTable[2][3] + "|"+ GameTable[2][4]);
        System.out.println("  ---+---+---+---+---");
        System.out.println("d "+GameTable[3][0] + "|"+ GameTable[3][1] + "|"+ GameTable[3][2] + "|"+ GameTable[3][3] + "|"+ GameTable[3][4]);

    }
    public int choice(String rawS, int colon){
        if(rawS.equals("a")){
            rawN=0;
        }
        else if(rawS.equals("b")){
            rawN=1;
        }
        else if(rawS.equals("c")){
            rawN=2;
        }
        else if (rawS.equals("d")){
            rawN=3;
        }
        if(getInvisibleTable()[rawN][colon]!=null){
            return 0;
        }
        else {
           getGameTable()[rawN][colon]=" x ";
        }
        return 1;
    }

    public String[][] getInvisibleTable() {
        return invisibleTable;
    }
}



