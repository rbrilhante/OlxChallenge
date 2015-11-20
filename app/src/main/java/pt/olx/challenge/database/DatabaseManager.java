package pt.olx.challenge.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by Asus on 20-11-2015.
 */
public class DatabaseManager {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;


    public DatabaseManager(Context context) {

        databaseHelper = new DatabaseHelper(context);
    }


    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }


    public void close() {
        databaseHelper.close();
    }


    public void saveEntry(String tableName, ContentValues cv) {

        database.insert(tableName, null, cv);
    }


    public Cursor getAllEntries(String tableName, String[] columns) {

        return database.query(tableName, columns, null, null, null, null, null);
    }
}
