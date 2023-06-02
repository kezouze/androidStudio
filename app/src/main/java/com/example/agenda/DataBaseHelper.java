package com.example.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String AGENDA_TABLE = "AGENDA_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_SURNAME = "SURNAME";
    public static final String COLUMN_ADRESS = "ADRESS";
    public static final String COLUMN_CP = "CP";
    public static final String COLUMN_CITY = "CITY";
    public static final String COLUMN_PHONE = "PHONE";
    public static final String COLUMN_GENDER = "GENDER";
    public static final String COLUMN_BIRTHDAY = "BIRTHDAY";
    public static final String COLUMN_PLACE = "PLACE";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "agenda.db", null, 1);
    }

    // this is called the first time a database is accessed. There should be code in here to create a new database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + AGENDA_TABLE + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_SURNAME + " TEXT, " + COLUMN_ADRESS + " TEXT, " + COLUMN_CP + " INT, " + COLUMN_CITY + " TEXT, " + COLUMN_PHONE + " INT, " + COLUMN_GENDER + " CHAR, " + COLUMN_BIRTHDAY + " TEXT, " + COLUMN_PLACE + " TEXT )";
        db.execSQL(createTableStatement);
    }


    // this is called if the database version number changes. It prevents previous users apps from breaking when you change the database design
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }

    public boolean addOne(AgendaModel agendaModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        // insersion dans la bdd
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, agendaModel.getName());
        cv.put(COLUMN_SURNAME, agendaModel.getSurname());
        cv.put(COLUMN_ADRESS, agendaModel.getAdress());
        cv.put(COLUMN_CP, agendaModel.getCp());
        cv.put(COLUMN_CITY, agendaModel.getCity());
        cv.put(COLUMN_PHONE, agendaModel.getPhone());
        cv.put(COLUMN_GENDER, agendaModel.getGender());
        cv.put(COLUMN_BIRTHDAY, agendaModel.getBirthday());
        cv.put(COLUMN_PLACE, agendaModel.getPlace());

        long insert = db.insert(AGENDA_TABLE, null, cv);
        if(insert == -1) {
            return false;
        } else {
            return true;
        }
    }

     public List<AgendaModel> getEveryone() {
        List<AgendaModel> returnList = new ArrayList<>();

        // get data from the database
         String queryString = "SELECT * FROM " + AGENDA_TABLE;
         SQLiteDatabase db = this.getReadableDatabase();
        // Cursor = complex object returned from a query
         Cursor cursor = db.rawQuery(queryString, null);

         // loop through the cursor and create new angenda objects. Put them into the return list
         if(cursor.moveToFirst()){
            do {
                int contactID = cursor.getInt(0);
                String contactName = cursor.getString(1);
                String contactSurname = cursor.getString(2);
                String contactAdress = cursor.getString(3);
                int contactCp = cursor.getInt(4);
                String contactCity = cursor.getString(5);
                int contactPhone = cursor.getInt(6);
                String contactGender = cursor.getString(7);
                String contactBirthday = cursor.getString(8);
                String contactPlace = cursor.getString(9);

                AgendaModel newAgenda = new AgendaModel(contactID, contactName, contactSurname, contactAdress, contactCp, contactCity, contactPhone,contactGender, contactBirthday, contactPlace);
                returnList.add(newAgenda);
            } while(cursor.moveToFirst());
         } else {
             // failure. do not add anything to the list
         }
         // close both the cursor and the db when done
         cursor.close();
         db.close();
         return returnList;
     }
}
