package sudoko.userinterface.logic;

import sudoko.constants.GameState;
import sudoko.constants.Messages;
import sudoko.problemdomain.IStorage;
import sudoko.problemdomain.SudokoGame;
import sudoko.userinterface.IUserInterfaceContract;

import java.io.IOException;

public class ControlLogic implements IUserInterfaceContract.EventListener {

    private IStorage storage;

    private IUserInterfaceContract.view view;

    public ControlLogic(IStorage storage, IUserInterfaceContract.view view) {
        this.storage = storage;
        this.view = view;
    }

    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokoGame gameData = storage.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;

            gameData = new SudokoGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState
            );

            storage.updateGameData(gameData);

            view.updateSquare(x,y,input);

            if (gameData.getGameState() == GameState.COMPLETE){
                view.showDialog(Messages.GAME_COMPLETE);
            }
        }catch (IOException e){
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }

    }

    @Override
    public void onDialogClick() {
        try {
            storage.updateGameData(
                    GameLogic.getNewGame()
            );

            view.updateBoard(storage.getGameData());
        }catch (IOException e){
            view.showError(Messages.ERROR);
        }
    }
}
