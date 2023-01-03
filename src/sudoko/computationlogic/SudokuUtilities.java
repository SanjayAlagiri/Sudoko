package sudoko.computationlogic;

import sudoko.problemdomain.SudokoGame;

public class SudokuUtilities {
    public static void copySudokuArrayValues(int[][] oldArray , int[][] newArray){
        for (int xIndex = 0 ; xIndex  < SudokoGame.GRID_BOUNDARY ; xIndex++){
            for (int yIndex = 0 ; yIndex  < SudokoGame.GRID_BOUNDARY ; yIndex++){
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }
    }
    public static int[][] copyToNewArray(int[][] oldArray){
        int[][] newArray = new int[SudokoGame.GRID_BOUNDARY][SudokoGame.GRID_BOUNDARY];

        for (int xIndex = 0 ; xIndex  < SudokoGame.GRID_BOUNDARY ; xIndex++){
            for (int yIndex = 0 ; yIndex  < SudokoGame.GRID_BOUNDARY ; yIndex++){
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }

        return newArray;
    }
}
