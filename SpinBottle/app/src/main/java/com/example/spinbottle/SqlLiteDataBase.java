package com.example.spinbottle;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

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

    public long insert(String dare) {
        db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(KEY_DARE,dare);
        return db.insert(TABLE_NAME, null, cv);
    }
}
