package com.hornet.nepalidateconverter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linux on 11/24/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="scheduler.db";
    public static final String TABLE_NAME="notesgetter";
    public static final String COL_0="ID";
    public static final String COL_1="date";
    public static final String COL_2="Person";
    public static final String COL_3="Place";
    public static final String COL_4="Task";

//    public static final String COL_5="Phone";
//    public static final String COL_6="Password";
//    public static final String COL_7="Email";
public class Notes{
    Integer ID;
            String date,Person,Task,Place;
    public  Notes(Integer ID,String date,String Person, String Place, String Task
    ){
        this.ID=ID;
        this.date=date;
        this.Person=Person;
        this.Place=Place;
        this.Task=Task;



    }
    public  Notes(){

    }


}

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();



    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " +TABLE_NAME+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,date TEXT,Person TEXT,Place TEXT,Task Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);
        onCreate(sqLiteDatabase);


    }


//    public String searchpass(String username){
//        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
//        String query="Select Name,Password from " +TABLE_NAME;
//        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
//        String a,b;
//        b="not found";
//        if(cursor.moveToFirst()){
//            do{
//                a=cursor.getString(0);
//                if (a.equals(username)){
//                    b=cursor.getString(1);
//                    break;
//                }
//            }
//        while(cursor.moveToNext());
//
//
//        }
//return b;
//    }

   public boolean insertData(String date, String Person, String Place, String Task){
       System.out.println("<chiryo chiryo");

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(COL_1,date);
        contentValues.put(COL_2,Person);
        contentValues.put(COL_3,Place);
        contentValues.put(COL_4,Task);

        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        if(result==-1){
            return false;
        }
 else
            return true;
    }

    public boolean removeData(Integer ID){
        System.out.println("<chiryo chiryo");
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

//        String Query ="DELETE FROM " + TABLE_NAME + " WHERE ID = " + ID  ; ;
//        System.out.println(Query);
        //Cursor cursor=database.rawQuery(Query,null);

        long result=sqLiteDatabase.delete(TABLE_NAME,COL_0 +"="+ID,null);

        if(result==-1){
            return false;
        }
        else
            return true;
    }

//    public boolean export(){
//
//        final String inFileName = "/data/data/<your.app.package>/databases/foo.db";
//        File dbFile = new File(inFileName);
//        FileInputStream fis = new FileInputStream(dbFile);
//
//        String outFileName = Environment.getExternalStorageDirectory()+"/database_copy.db";
//
//        // Open the empty db as the output stream
//        OutputStream output = new FileOutputStream(outFileName);
//
//        // Transfer bytes from the inputfile to the outputfile
//        byte[] buffer = new byte[1024];
//        int length;
//        while ((length = fis.read(buffer))>0){
//            output.write(buffer, 0, length);
//        }
//
//        // Close the streams
//        output.flush();
//        output.close();
//        fis.close();
//
//        return true;
//
//    }
    //    public List<String> getAllLabels(){
//        List<String> list = new ArrayList<String>();
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//
//        // Select All Query
//        String selectQuery = "Select * from " +TABLE_NAME;
//
//
//        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);//selectQuery,selectedArguments
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                String NAME = cursor.getString(1);
//                list.add(NAME);
//                //list.add(cursor.getString(1));//adding 2nd column data
//            } while (cursor.moveToNext());
//        }
//        // closing connection
//        cursor.close();
//        sqLiteDatabase.close();
//
//        // returning lables
//        return list;
//    }
    public ArrayList<Notes> getNotes(String getday){
        ArrayList<Notes> Noteslist=new ArrayList<>();
        Noteslist.clear();

        SQLiteDatabase database=this.getReadableDatabase();
        String Query ="SELECT * FROM "+TABLE_NAME+" WHERE date ='"+getday+"'" ; ;
        System.out.println(Query);
        Cursor cursor=database.rawQuery(Query,null);
        while(cursor.moveToNext()){
            Noteslist.add(
                    new Notes(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4)

                    )
            );
        }
        return Noteslist ;
    }

}
