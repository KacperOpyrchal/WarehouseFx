package sample.Tools;

import javafx.scene.control.Button;

import static sample.Tools.SceneProvider.*;

public class MenuItem implements Item {

    private String name;

    private Button button;

    private Action action = () -> {};

    public MenuItem(String name) {
        this.name = name;
        button = contentButton(name);
    }

    public MenuItem(String name, Action action) {
        this.name = name;
        this.action = action;
        button = contentButton(name);
    }

    @Override
    public void setOnClickListener(Action action) {
        this.action = action;
    }

    @Override
    public void onClick() {
        action.call();
    }

    @Override
    public String getValue() {
        return name;
    }

    @Override
    public void editValue(String value) {
        name = value;
    }

    @Override
    public void deleteValue() {
        name = null;
    }

    @Override
    public Button getButton() {
        return button;
    }

    @Override
    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public void updateItem(String name) {
        this.name = name;
        button.setText(name);
    }
}
