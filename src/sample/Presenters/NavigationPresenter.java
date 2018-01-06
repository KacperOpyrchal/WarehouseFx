package sample.Presenters;

import com.sun.tools.javac.util.Pair;
import sample.Data.GlobalStage;
import sample.Views.NavigationView;
import sample.Views.View;

import java.util.ArrayList;
import java.util.List;

public class NavigationPresenter {

    private NavigationView view;
    private List<Pair<View, String>> commandStack = new ArrayList<>();
    private int i = -1;

    public NavigationPresenter(NavigationView navigationView) {
        this.view = navigationView;
    }

    public void onNext() {
        if(i + 1 < commandStack.size()){
            i++;
            GlobalStage.getGlobalStage().getSceneFromStack(commandStack.get(i));
            if(i + 1 == commandStack.size()) {
                view.setDisable(false, true);
            }
        }
    }

    public void onPrev() {
        if(i > 0) {
            i--;
            GlobalStage.getGlobalStage().getSceneFromStack(commandStack.get(i));
            if(i == 0) {
                view.setDisable(true, false);
            }
        }
    }

    public void updateStack(Pair<View, String> view) {
        this.view.updateTitle(view.snd);
        i++;
        if(commandStack.size() != i) {
            for(int j = i; j < commandStack.size(); ++j) {
                commandStack.remove(j);
            }
        }
        commandStack.add(view);

        if(i == 0){
            if(commandStack.size() == 1) {
                this.view.setDisable(true, true);
            } else {
                this.view.setDisable(true, false);
            }
        } else {
            this.view.setDisable(false, true);
        }
    }

}
