package com.example.spinbottle;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.Random;

public class SqlLiteDataBase extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final String DATABASE_NAME="APP_Info";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="Dare_List";
    public static final String KEY_ROWID="_id";
    public static final String KEY_DARE="Dare";
    public SqlLiteDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DARE_TABLE= "CREATE TABLE "+TABLE_NAME+ "("+KEY_ROWID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_DARE+ " TEXT);";
        db.execSQL(CREATE_DARE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public long insertDare(String dare) {
        db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(KEY_DARE,dare);
        db.close();
        return db.insert(TABLE_NAME, null, cv);
    }

    public String getDareData() {
      db=this.getReadableDatabase();
      String[] columns=new String[]{KEY_ROWID,KEY_DARE};
      Cursor c=db.query(TABLE_NAME,columns,null,null,null,null,null);
      String result="";
      int iRow=c.getColumnIndex(KEY_ROWID);
      int iDare=c.getColumnIndex(KEY_DARE);
      for (c.moveToFirst(); !c.isAfterLast();c.moveToNext())
      {
        result=result+ c.getString(iDare)+ "\n";
      }
      db.close();
      c.close();
      return result;
    }

    public String getOneDare() {
        db = this.getReadableDatabase();
        Random random = new Random();
        int i;
        int count = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        int  dID = random.nextInt(count+1);
        String[] columns=new String[]{KEY_ROWID,KEY_DARE};
        Cursor c=db.query(TABLE_NAME,columns,null,null,null,null,null);
        String result="";
        int iDare=c.getColumnIndex(KEY_DARE);
        c.moveToFirst();
        i=1;
        while(i<dID)
        {
            c.moveToNext();
            i=i+1;
        }
        result=result+ c.getString(iDare);
        db.close();
        c.close();
        return result;
    }
}
