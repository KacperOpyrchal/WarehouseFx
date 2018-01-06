package sample.Tools;

import javafx.scene.control.Button;

public interface Item {

    void setOnClickListener(Action action);

    void onClick();

    String getValue();

    void editValue(String value);

    void deleteValue();

    Button getButton();

    void setButton(Button button);

    void updateItem(String name);
}