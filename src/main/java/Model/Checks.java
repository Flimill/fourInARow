package Model;

import java.util.List;



public class Checks {
    public static Constants checkStatus(){
        Constants winner = checkForWinner();
        Constants draw = checkForDraw();
        if (winner != Constants.Empty)
            return winner;
        else return draw;
    }

    public static Constants checkForWinner(){
        List<Slot> matrix = Field.getMainField().getMatrix();
        List<List<Constants>> horizontalLines = Field.getHorizontalLinesFromMatrix(matrix);
        List<List<Constants>> verticalLines = Field.getVerticalLinesFromMatrix(matrix);
        List<List<Constants>> diagonalLines = Field.getDiagonalLinesFromMatrix(matrix);
        for (List<Constants> line: horizontalLines){
            if(checkLine(line) != Constants.Empty)
                return checkLine(line);
        }
        for (List<Constants> line: verticalLines){
            if(checkLine(line) != Constants.Empty)
                return checkLine(line);
        }
        for (List<Constants> line: diagonalLines){
            if(checkLine(line) != Constants.Empty)
                return checkLine(line);
        }
        return Constants.Empty;
    }


    public static Constants checkForDraw(){
        List<Constants> topLine = Field.getHorizontalLinesFromMatrix(Field.getMainField().getMatrix()).get(0);
        boolean allFilled = true;
        for (Constants cell: topLine){
            if (cell == Constants.Empty) {
                allFilled = false;
                break;
            }
        }
        if (allFilled){
            Field.turnOffGameStatus();
            return Constants.Draw;
        }

        return Constants.Empty;
    }

    public static Constants checkLine(List<Constants> line){
        int scoreGreenPlayer = 0;
        int scoreBluePlayer = 0;
        Constants prevSlotBelonging = Constants.Empty;
        for (Constants belonging: line){
            if (belonging != prevSlotBelonging){
                scoreGreenPlayer = 0;
                scoreBluePlayer = 0;
            }
            switch (belonging){
                case GreenPlayer -> {
                    scoreGreenPlayer++;
                }
                case BluePlayer -> {
                    scoreBluePlayer++;
                }
            }
            if (scoreGreenPlayer == 4) return Constants.GreenPlayer;
            else if (scoreBluePlayer == 4) return Constants.BluePlayer;
            prevSlotBelonging = belonging;
        }
        return Constants.Empty;
    }
}
