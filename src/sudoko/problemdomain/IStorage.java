package sudoko.problemdomain;

import java.io.IOException;

public interface IStorage {
    void updateGameData(SudokoGame) throws IOException;
    SudokoGame getGameData() throws IOException;
}
