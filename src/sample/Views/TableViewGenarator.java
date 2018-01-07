package sample.Views;

import sample.Data.DatabaseClasses.Warehouse;
import sample.Data.DatabaseWrapper;

import java.util.List;

import static sample.Tools.SceneProvider.label;

public class TableViewGenarator {

    static GeneralTableView<Warehouse> getWarehouseView() {
        List<Warehouse> list = DatabaseWrapper.loadAllWarehouses();
        GeneralTableView<Warehouse> generalTableView = new GeneralTableView<>(list,
                label("ID"), label("Name"), label("Capacity"));
        return generalTableView;
    }

}
