package pt.olx.challenge.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asus on 20-11-2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "olx_challenge.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME_CONTENT = "olxAd";

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String CITY_LABEL = "city_label";
    public static final String LIST_LABEL_AD = "list_label_ad";
    public static final String CREATED = "created";
    public static final String MAP_LAT = "map_lat";
    public static final String MAP_LON = "map_lon";
    public static final String USER_LABEL = "user_label";


    public static final String[] CONTENT_ALL_COLUMNS = {
            DatabaseHelper.ID,
            DatabaseHelper.TITLE,
            DatabaseHelper.DESCRIPTION,
            DatabaseHelper.CITY_LABEL,
            DatabaseHelper.LIST_LABEL_AD,
            DatabaseHelper.CREATED,
            DatabaseHelper.MAP_LAT,
            DatabaseHelper.MAP_LON,
            DatabaseHelper.USER_LABEL
    };

    private static final String DATABASE_CREATE_TABLE_CONTENT = "create table "
            + TABLE_NAME_CONTENT + "( "
            + ID + " text primary key, "
            + TITLE	+ " text, "
            + DESCRIPTION + " text, "
            + CITY_LABEL + " text, "
            + LIST_LABEL_AD + " text, "
            + CREATED + " text, "
            + MAP_LAT + " real, "
            + MAP_LON + " real, "
            + USER_LABEL + " text);";


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE_TABLE_CONTENT);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
