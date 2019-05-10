package com.logicshore.sqliteimageupload;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 21-12-2017.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "Login";

    // Contacts table name
    private static final String TABLE_CONTACTS = "LoginValues";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "pass_word";
    private static final String KEY_IMAGE = "image_data";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PASSWORD + " TEXT," + KEY_IMAGE+"TEXT)";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
        // we can take AUTO INCREMENT alse for KEY_ID
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(sqLiteDatabase);
    }





    // Adding new contact

    public void insertData(String s, String s1) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, s); // Contact Name
        values.put(KEY_PASSWORD, s1);
       // values.put(KEY_IMAGE,imgPath);
        // Contact Phone Number
        //values.put(KEY_IMAGE, String.valueOf(imageview));
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    public Cursor getAllContacts() {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        return cursor;
    }
    public void deleteallfamily() {
        SQLiteDatabase sd = this.getWritableDatabase();
        sd.delete(TABLE_CONTACTS, null, null);
        sd.close();
    }
}
