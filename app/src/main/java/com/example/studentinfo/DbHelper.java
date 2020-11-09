package com.example.studentinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "usersdb";
    private static final String TABLE_Users = "studentinfo";
    private static final String KEY_ID = "id";

    private static final String STUID = "stuid";
    private static final String M1 = "m1";
    private static final String M2 = "m2";
    private static final String M3 = "m3";

    public DbHelper(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + STUID + " TEXT,"
                + M1 + " TEXT,"
                + M2 + " TEXT,"
                + M3 + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        onCreate(db);
    }

    // Adding new User Details
    void insertUserDetails(String stuid, String m1, String m2, String m3){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(STUID, stuid);
        cValues.put(M1, m1);
        cValues.put(M2, m2);
        cValues.put(M3, m3);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Users,null, cValues);
        db.close();
    }

    public List<StudentModel> getStudentdetails(){
        List<StudentModel> studentModels = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_Users;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            StudentModel studentModel = new StudentModel();
            studentModel.setStudent_id(cursor.getString(cursor.getColumnIndex(STUID)));
            studentModel.setM1(cursor.getString(cursor.getColumnIndex(M1)));
            studentModel.setM2(cursor.getString(cursor.getColumnIndex(M2)));
            studentModel.setM3(cursor.getString(cursor.getColumnIndex(M3)));
            studentModels.add(studentModel);
        }
        return  studentModels;
    }

}
