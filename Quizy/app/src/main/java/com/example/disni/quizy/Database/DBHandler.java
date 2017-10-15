package com.example.disni.quizy.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by disni on 9/30/2017.
 */

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(Context context, String name,SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UsersMaster.Users.TABLE_NAME + " (" +
                        UsersMaster.Users._ID + " INTEGER PRIMARY KEY," +
                        UsersMaster.Users.COLUMN_NAME_USERNAME + " TEXT," +
                        UsersMaster.Users.COLUMN_NAME_PASSWORD + " TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addInfo(String userName, String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_USERNAME, userName);
        values.put(UsersMaster.Users.COLUMN_NAME_PASSWORD, password);

        long newRowId = db.insert(UsersMaster.Users.TABLE_NAME, null, values);
    }

    public boolean readInfo(String userName, String password)
    {
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                UsersMaster.Users._ID,
                UsersMaster.Users.COLUMN_NAME_USERNAME,
                UsersMaster.Users.COLUMN_NAME_PASSWORD
        };

        // Filter results WHERE "username" = 'SLIIT User'
        //String selection = UsersMaster.Users._ID + " = ?";
        //String[] selectionArgs = { "SLIIT User" };

        String selection = UsersMaster.Users.COLUMN_NAME_USERNAME + " = ? AND " + UsersMaster.Users.COLUMN_NAME_PASSWORD + " = ?";
        String[] selectionArgs = { userName,  password};

        // How you want the results sorted in the     resulting Cursor
        String sortOrder = UsersMaster.Users.COLUMN_NAME_USERNAME + " DESC";

        Cursor cursor = db.query(
                UsersMaster.Users.TABLE_NAME,    // The table to query
                projection,                      // The columns to return
                selection,                            // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                            // don't group the rows
                null,                            // don't filter by row groups
                null                        // The sort order
        ); //no where statement or grouping values are set.

        // List userNames = new ArrayList<>();
        //List passwords = new ArrayList<>();

      /*  while(cursor.moveToNext()) {
            String userName = cursor.getString( cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_USERNAME));
            String password = cursor.getString( cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_PASSWORD));
            userNames.add(userName);
            passwords.add(password);
        }*/

        while(cursor.moveToNext()) {
            cursor.close();
            return true; // return true if there is a record fetched by the cursor.
        }
        cursor.close();
        return false;
    }

    public void updateInfo(String userName, String pwd){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_PASSWORD, pwd);

        String selection = UsersMaster.Users.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionArgs = { userName };

        int count = db.update(
                UsersMaster.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
    }

    public void deleteInfo(String userName){
        SQLiteDatabase db = getReadableDatabase();
        String selection = UsersMaster.Users.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionArgs = { userName };
        db.delete(UsersMaster.Users.TABLE_NAME, selection, selectionArgs);
    }
}
