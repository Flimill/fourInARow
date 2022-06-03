package Model;


public class Computer {
    public static boolean computerPlayer;

    public static Integer makesMove(){
        int move = (int) (Math.random()*7 + 1);
        while (Field.findFreePosition(Field.getMainField().getLine(move)) == -1){
            move = (int) (Math.random()*7 + 1);
        }
        return move;
    }
}
