package sudoko.userinterface;

public interface IUserInterfaceContract {
    interface EventListener{
        void onSudokuInput(int x , int y , int input);
        void onDialogClick();

    }
    interface view {
        void setListener(IUserInterfaceContract.EventListener listener);
        void updateSquare(int x ,int y , int input);
        void updateBoard(SudokuGame game);
        void showDialog(String Message);
        void showError(String message);
    }
}
