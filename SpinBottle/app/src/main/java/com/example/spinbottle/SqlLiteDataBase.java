package com.example.spinbottle;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SqlLiteDataBase extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final String DATABASE_NAME="APP_Info";
    private static final int DATABASE_VERSION=2;
    private static final String TABLE_NAME="Dare_List";
    public static final String KEY_ROWID="_id";
    public static final String KEY_DARE="Dare";
    private static final String TABLE_NAME2="Truth_List";
    public static final String KEY_ROWID2="_id1";
    public static final String KEY_TRUTH="Truth";
    public SqlLiteDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DARE_TABLE= "CREATE TABLE "+TABLE_NAME+ "("+KEY_ROWID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_DARE+ " TEXT);";
        String CREATE_TRUTH_TABLE= "CREATE TABLE "+TABLE_NAME2+ "("+KEY_ROWID2+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_TRUTH+ " TEXT);";
        db.execSQL(CREATE_DARE_TABLE);
        db.execSQL(CREATE_TRUTH_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }

    /* FUNCTIONS FOR DARE TABLE;TABLE_NAME*/
    public long insertDare(String dare) {
        db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(KEY_DARE,dare);
        return db.insert(TABLE_NAME, null, cv);
    }

    public List<String> getDareData() {
      db=this.getReadableDatabase();
      String[] columns=new String[]{KEY_ROWID,KEY_DARE};
      Cursor c=db.query(TABLE_NAME,columns,null,null,null,null,null);
      List<String> result=new ArrayList<String>();
      int iRow=c.getColumnIndex(KEY_ROWID);
      int iDare=c.getColumnIndex(KEY_DARE);
      for (c.moveToFirst(); !c.isAfterLast();c.moveToNext())
      {
          result.add(c.getString((iDare)));
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
        if (count>0) {
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
        return "No entries";
    }
    public void deleteDare(String dare)
    {
        db=this.getWritableDatabase();
        db.delete(TABLE_NAME,KEY_DARE+" LIKE'%"+dare+"%' ",null);
        db.close();
    }

/* FUNCTIONS FOR TRUTH TABLE;TABLE_NAME2*/
    public long insertTruth(String truth) {
        db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(KEY_TRUTH,truth);
        return db.insert(TABLE_NAME2, null, cv);
    }
    public String getOneTruth()
    {
        db = this.getReadableDatabase();
        Random random = new Random();
        int count = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME2);
        if (count>0)
        {
            int  dID2 = random.nextInt(count+1);
            String[] columns=new String[]{KEY_ROWID2,KEY_TRUTH};
            Cursor c=db.query(TABLE_NAME2,columns,null,null,null,null,null);
            String result="";
            int iTruth=c.getColumnIndex(KEY_TRUTH);
            c.moveToFirst();
            int i = 1;
            while(i<dID2)
            {
                c.moveToNext();
                i=i+1;
            }
            result=result+ c.getString(iTruth);
            db.close();
            c.close();
            return result;
        }
       return "No entries";
    }
    public List<String> getTruthData() {
        db=this.getReadableDatabase();
        String[] columns=new String[]{KEY_ROWID2,KEY_TRUTH};
        Cursor c=db.query(TABLE_NAME2,columns,null,null,null,null,null);
        List<String> result=new ArrayList<String>();
        int iRow=c.getColumnIndex(KEY_ROWID2);
        int iTruth=c.getColumnIndex(KEY_TRUTH);
        for (c.moveToFirst(); !c.isAfterLast();c.moveToNext())
        {
            result.add(c.getString((iTruth)));
        }
        db.close();
        c.close();
        return result;
    }
    public void deleteTruth(String truth)
    {
        db=this.getWritableDatabase();
        db.delete(TABLE_NAME2,KEY_TRUTH+" LIKE'%"+truth+"%' ",null);
        db.close();
    }

}
