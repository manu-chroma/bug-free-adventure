package xyz.gyanl.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manu on 25-12-2015.
 */



public class WordsDbHelper extends SQLiteOpenHelper {
    //check
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "nounsDB.db";
    private static final String TABLE = "words";

    //public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "noun_name";
    //public static final String COLUMN_QUANTITY = "quantity";

    public WordsDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //overriding sqlite helper functions
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE + "("
                //+ COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT," ;
        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public void addProduct(WordsDbSchema wordsDbSchema) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, wordsDbSchema.getNoun());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE, null, values);
        db.close();
    }

    //query handler method
    public WordsDbSchema findNoun (String productname) {
        String query = "Select * FROM " + TABLE + " WHERE " + COLUMN_NAME + " =  \"" + productname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        WordsDbSchema wordsDbSchema = new WordsDbSchema();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            //prod.setID(Integer.parseInt(cursor.getString(0)));
            wordsDbSchema.setNoun(cursor.getString(1));
            //product.setQuantity(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        } else {
            wordsDbSchema = null;
        }
        db.close();
        return wordsDbSchema;
    }


    //delete handler method
    public boolean deleteProduct (String productname) {

        boolean result = false;

        String query = "Select * FROM " + TABLE + " WHERE " + COLUMN_NAME + " =  \"" + productname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        WordsDbSchema wordsDbSchema = new WordsDbSchema();

        if (cursor.moveToFirst()) {
            //product.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE, COLUMN_NAME + " = ?",
                    new String[] { String.valueOf(wordsDbSchema.getNoun()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

}
/*public class WordsDbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "nouns.db";

    public WordsDbHelper(Context context) {
        super(context, DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
} */