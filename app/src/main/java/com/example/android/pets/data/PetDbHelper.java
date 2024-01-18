package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;

import androidx.annotation.Nullable;

/**
 * Database helper for Pets app. Manages database creation and version management.
 */
public class PetDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    /** Name of the database file */
    public static final String DATABASE_NAME = "shelter.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    public static final int DATABASE_VERSION = 1;


    /** Name of the database file */
    public PetDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
         // CREATE TABLE pets(id INTEGER PRIMARY KEY, name TEXT, weight INTEGER);
        // Create a String that contains the SQL statement to create the pets table

        String SQL_CREATE_PETS_TABLE =
            "CREATE TABLE " + PetEntry.TABLE_NAME + "(" +
                PetEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PetEntry.COLUMN_PET_NAME + "TEXT NOT NULL, " +
                PetEntry.COLUMN_PET_BREED + "TEXT, " +
                PetEntry.COLUMN_PET_GENDER + "INTEGER NOT NULL, " +
                PetEntry.COLUMN_PET_WEIGHT + "INTEGER NOT NULL DEFAULT 0" + ");";

        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
//        onCreate(sqLiteDatabase);
    }

}
