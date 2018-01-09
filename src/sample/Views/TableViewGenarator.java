package sample.Views;

import javafx.scene.control.Label;
import sample.Data.DatabaseClasses.*;
import sample.Data.DatabaseWrapper;
import sample.Tools.Action;

import java.util.List;

import static sample.Tools.SceneProvider.label;

public class TableViewGenarator {

    static GeneralTableView<Warehouse>  getWarehouseView() {
        GeneralTableView<Warehouse> generalTableView = new GeneralTableView<>(DatabaseWrapper.loadAllWarehouses(),
                label("ID"), label("Name"), label("Capacity"));
        generalTableView.withReload(() -> generalTableView.reload(DatabaseWrapper.loadAllWarehouses(),
                label("ID"), label("Name"), label("Capacity")));
        return generalTableView;
    }

    static GeneralTableView<Employee>  getEmployeeView() {
        GeneralTableView<Employee> generalTableView = new GeneralTableView<>(DatabaseWrapper.loadAllEmployee(),
                label("ID"), label("Name"), label("Surname"), label("Position"), label("Salary"));
        generalTableView.withReload(() -> generalTableView.reload(DatabaseWrapper.loadAllEmployee(),
                label("ID"), label("Name"), label("Surname"), label("Position"), label("Salary")));
        return generalTableView;
    }

    static GeneralTableView<Equipment>  getEquipmentView() {
        GeneralTableView<Equipment> generalTableView = new GeneralTableView<>(DatabaseWrapper.loadAllEquipment(),
                label("ID"), label("Name"));
        generalTableView.withReload(() -> generalTableView.reload(DatabaseWrapper.loadAllEquipment(),
                label("ID"), label("Name")));
        return generalTableView;
    }

    static GeneralTableView<Manager>  getManagerView() {
        GeneralTableView<Manager> generalTableView = new GeneralTableView<>(DatabaseWrapper.loadAllManager(),
                label("ID"), label("Name"), label("Surname"), label("Salary"));
        generalTableView.withReload(() -> generalTableView.reload(DatabaseWrapper.loadAllManager(),
                label("ID"), label("Name"), label("Surname"), label("Salary")));
        return generalTableView;
    }

    static GeneralTableView<Product>  getProductView() {
        GeneralTableView<Product> generalTableView = new GeneralTableView<>(DatabaseWrapper.loadAllProduct(),
                label("ID"), label("Name"), label("Price"), label("Weight"), label("Amount"));
        generalTableView.withReload(() -> generalTableView.reload(DatabaseWrapper.loadAllProduct(),
                label("ID"), label("Name"), label("Price"), label("Weight"), label("Amount")));
        return generalTableView;
    }

    static GeneralTableView<Provider>  getProviderView() {
        GeneralTableView<Provider> generalTableView = new GeneralTableView<>(DatabaseWrapper.loadAllProvider(),
                label("ID"), label("Name"));
        generalTableView.withReload(() -> generalTableView.reload(DatabaseWrapper.loadAllProvider(),
                label("ID"), label("Name")));
        return generalTableView;
    }

    static GeneralTableView<Section>  getSectionView() {
        GeneralTableView<Section> generalTableView = new GeneralTableView<>(DatabaseWrapper.loadAllSection(),
                label("ID"), label("Name"));
        generalTableView.withReload(() -> generalTableView.reload(DatabaseWrapper.loadAllSection(),
                label("ID"), label("Name")));
        return generalTableView;
    }
}
