package sample.Data.DatabaseClasses;

import sample.SQLiteJDBC;

public class UpdatableWrapper {
    public static void deleteFromDatabase(String tableName, int id) {
        String sql = "DELETE FROM " + tableName + " WHERE ID = " + id + ";";
        try {
            SQLiteJDBC.proceedUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
