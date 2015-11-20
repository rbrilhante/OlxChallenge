package pt.olx.challenge.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pt.olx.challenge.database.DatabaseHelper;
import pt.olx.challenge.database.DatabaseManager;
import pt.olx.challenge.domain.OlxAd;

/**
 * Created by Asus on 20-11-2015.
 */
public class DatabaseUtils {

    private static DatabaseManager databaseManager;

    public static void initDatabase(Context context){
        if(databaseManager == null) {
            databaseManager = new DatabaseManager(context);
            try {
                databaseManager.open();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getDatabaseOlxAds() {

        List<OlxAd> olxAds = new ArrayList<OlxAd>();

        try {
            Cursor c = databaseManager.getAllEntries(DatabaseHelper.TABLE_NAME_CONTENT, DatabaseHelper.CONTENT_ALL_COLUMNS);

            c.moveToFirst();

            while (c.moveToNext()) {

                try {
                    OlxAd olxAd = new OlxAd();

                    olxAd.setId(c.getString(c.getColumnIndex(DatabaseHelper.ID)));
                    olxAd.setTitle(c.getString(c.getColumnIndex(DatabaseHelper.TITLE)));
                    olxAd.setDescription(c.getString(c.getColumnIndex(DatabaseHelper.DESCRIPTION)));
                    olxAd.setCityLabel(c.getString(c.getColumnIndex(DatabaseHelper.CITY_LABEL)));
                    olxAd.setListLabelAd(c.getString(c.getColumnIndex(DatabaseHelper.LIST_LABEL_AD)));
                    olxAd.setCreated(c.getString(c.getColumnIndex(DatabaseHelper.CREATED)));
                    olxAd.setMapLat(c.getDouble(c.getColumnIndex(DatabaseHelper.MAP_LAT)));
                    olxAd.setMapLon(c.getDouble(c.getColumnIndex(DatabaseHelper.MAP_LON)));
                    olxAd.setUserLabel(c.getString(c.getColumnIndex(DatabaseHelper.USER_LABEL)));

                    olxAds.add(olxAd);
                } catch (Exception e) { }
            }
        } catch (Exception e) { }

        DomainUtils.olxAdList = olxAds;
    }

    public static void saveOlxAd(OlxAd olxAd) {

        try {
            ContentValues cv = new ContentValues();

            cv.put(DatabaseHelper.ID, olxAd.getId());
            cv.put(DatabaseHelper.TITLE, olxAd.getTitle());
            cv.put(DatabaseHelper.DESCRIPTION, olxAd.getDescription());
            cv.put(DatabaseHelper.CITY_LABEL, olxAd.getCityLabel());
            cv.put(DatabaseHelper.LIST_LABEL_AD, olxAd.getListLabelAd());
            cv.put(DatabaseHelper.CREATED, olxAd.getCreated());
            cv.put(DatabaseHelper.MAP_LAT, olxAd.getMapLat());
            cv.put(DatabaseHelper.MAP_LON, olxAd.getMapLon());
            cv.put(DatabaseHelper.USER_LABEL, olxAd.getUserLabel());

            databaseManager.saveEntry(DatabaseHelper.TABLE_NAME_CONTENT, cv);

        } catch (Exception e) { }
    }
}
