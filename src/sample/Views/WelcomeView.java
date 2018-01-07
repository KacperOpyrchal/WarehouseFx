package sample.Views;

import com.sun.tools.javac.util.Pair;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.Data.DatabaseWrapper;
import sample.Data.GlobalStage;
import sample.Data.DatabaseClasses.Warehouse;
import sample.Tools.SceneProvider;

import java.util.ArrayList;
import java.util.List;

import static sample.Tools.SceneProvider.*;

public class WelcomeView implements View{

    private Button warehouseButton = button("Warehouses");
    private Button employeeButton = button("Employees");
    private Button equipmentButton = button("Equipments");
    private Button managerButton = button("Managers");
    private Button productButton = button("Products");
    private Button providerButton = button("Providers");
    private Button sectionButton = button("Sections");

    @Override
    public Pane getPane() {
        setUpListeners();


        GridPane gridPane = SceneProvider.gridPane();
        gridPane.addRow(0, warehouseButton, sectionButton);
        gridPane.addRow(1, employeeButton, managerButton);
        gridPane.addRow(2, productButton, providerButton);
        gridPane.addRow(3, equipmentButton);

        return gridPane;
    }

    @Override
    public void setUpListeners() {
        warehouseButton.setOnAction(e -> {
            GlobalStage.getGlobalStage().introduceNewScene(new Pair<>(TableViewGenarator.getWarehouseView(), "Warehauses"));
        });
    }

    private Button button(String str) {
        Button btn = submitButton(str);
        btn.setMinWidth(300);
        return btn;
    }
}
