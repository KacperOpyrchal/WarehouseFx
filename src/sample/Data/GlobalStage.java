package sample.Data;

import com.sun.tools.javac.util.Pair;
import javafx.stage.Stage;
import sample.Tools.SceneProvider;
import sample.Views.View;

public class GlobalStage {

    private static GlobalStage globalStage = null;

    private Stage stage;

    private GlobalStage() { }

    public void initStage(Stage stage) {
        this.stage = stage;
    }

    public void introduceNewScene(Pair<View, String> view) {
        stage.setScene(SceneProvider.generalUseScene(view));
    }

    public void getSceneFromStack(Pair<View, String> view) {
        stage.setScene(SceneProvider.generalReuseScene(view));
    }

    public synchronized static GlobalStage getGlobalStage() {
        if(globalStage == null) {
            globalStage = new GlobalStage();
        }
        return globalStage;
    }
}
