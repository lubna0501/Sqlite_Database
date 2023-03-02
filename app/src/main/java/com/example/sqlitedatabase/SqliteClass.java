package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="student_table";
    public static final String  NAME="name";
    public static final String SURNAME="surname";
    public static final String MARKS="marks";
    public static final String ID="id";

    public SqliteClass(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("create table " + TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
    public boolean insertvalue(String name,String surname,String marks)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contextvalues=new ContentValues();
        contextvalues.put(NAME,name);
        contextvalues.put(SURNAME,surname);
        contextvalues.put(MARKS,marks);

        long result=db.insert(TABLE_NAME,null,contextvalues);
        if(result > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Cursor getalldata()
    {
        SQLiteDatabase sql= this.getWritableDatabase();
        Cursor cursor=sql.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }

    public Cursor showdata() {
        SQLiteDatabase sql= this.getWritableDatabase();
        Cursor cursor=sql.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }
    public boolean updatevalue(String name,String surname,String marks,String id)
    {
        SQLiteDatabase sql= this.getWritableDatabase();
        ContentValues contextvalues=new ContentValues();
        contextvalues.put(NAME,name);
        contextvalues.put(SURNAME,surname);
        contextvalues.put(MARKS,marks);
        contextvalues.put(ID,id);
        int res= sql.update(TABLE_NAME,contextvalues,"ID=?", new String[] {id});
        if(res>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

public int delete(String id)
{
    SQLiteDatabase sql= this.getWritableDatabase();

    int res= sql.delete(TABLE_NAME, "ID=?", new String[] {id});
    return res;
}
}
