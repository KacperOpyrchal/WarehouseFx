package sample.Views;

import sample.Data.DatabaseClasses.*;
import sample.Data.DatabaseWrapper;

import java.util.List;

import static sample.Tools.SceneProvider.label;

public class TableViewGenarator {

    static GeneralTableView<Warehouse>  getWarehouseView() {
        return new GeneralTableView<>(DatabaseWrapper.loadAllWarehouses(),
                label("ID"), label("Name"), label("Capacity"));
    }

    static GeneralTableView<Employee>  getEmployeeView() {
        return new GeneralTableView<>(DatabaseWrapper.loadAllEmployee(),
                label("Name"), label("Surname"), label("Manager"));
    }

    static GeneralTableView<Equipment>  getEquipmentView() {
        return new GeneralTableView<>(DatabaseWrapper.loadAllEquipment(),
                label("ID"), label("Name"), label("Capacity"));
    }

    static GeneralTableView<Manager>  getManagerView() {
        return new GeneralTableView<>(DatabaseWrapper.loadAllManager(),
                label("ID"), label("Name"), label("Capacity"));
    }

    static GeneralTableView<Product>  getProductView() {
        return new GeneralTableView<>(DatabaseWrapper.loadAllProduct(),
                label("ID"), label("Name"), label("Capacity"));
    }

    static GeneralTableView<Provider>  getProviderView() {
        return new GeneralTableView<>(DatabaseWrapper.loadAllProvider(),
                label("ID"), label("Name"), label("Capacity"));
    }

    static GeneralTableView<Section>  getSectionView() {
        return new GeneralTableView<>(DatabaseWrapper.loadAllSection(),
                label("ID"), label("Name"), label("Capacity"));
    }
}
