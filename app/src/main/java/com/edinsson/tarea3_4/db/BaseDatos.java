package com.edinsson.tarea3_4.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import com.edinsson.tarea3_4.modelo.CardViewMain;
import com.sun.mail.util.BASE64DecoderStream;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    private ArrayList<CardViewMain> fiveFavorite;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaContecto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_PUBLISHER + "(" +
                                        ConstantesBaseDatos.TABLE_PUBLISHER_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_PUBLISHER_NAME    + " TEXT" +
                                        ")";

        String queryCrearTablaContactoLike = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKE_NUMBER + "(" +
                                         ConstantesBaseDatos.TABLE_LIKE_NUMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         ConstantesBaseDatos.TABLE_LIKE_NUMBER_ID_PUBLISHER + " INTEGER, " +
                                         ConstantesBaseDatos.TABLE_LIKE_NUMBER_NUMBER + " INTEGER, " +
                                         "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKE_NUMBER_ID_PUBLISHER + ") " +
                                         "REFERENCES " + ConstantesBaseDatos.TABLE_PUBLISHER + "(" + ConstantesBaseDatos.TABLE_PUBLISHER_ID + ") " +
                                            ")";

        String queryCrearTablaFiveFavorite = "CREATE TABLE " + ConstantesBaseDatos.TABLE_FIVE_FAVORITE + "(" +
                                        ConstantesBaseDatos.TABLE_PUBLISHER_ID      + " INTEGER PRIMARY KEY, " +
                                        ConstantesBaseDatos.TABLE_PUBLISHER_PICTURE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_PUBLISHER_NAME    + " TEXT" +
                                        ")";

        sqLiteDatabase.execSQL(queryCrearTablaContecto);
        sqLiteDatabase.execSQL(queryCrearTablaContactoLike);
        sqLiteDatabase.execSQL(queryCrearTablaFiveFavorite);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_PUBLISHER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKE_NUMBER);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<CardViewMain> obtenerPublishers(){
        ArrayList<CardViewMain> cardViewMains = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PUBLISHER;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        while(registros.moveToNext()){
            CardViewMain cardViewMain = new CardViewMain();
            cardViewMain.setId(registros.getInt(0));
            cardViewMain.setPicture(registros.getString(1));
            cardViewMain.setName(registros.getString(2));

            cardViewMains.add(cardViewMain);
        }

        sqLiteDatabase.close();

        return cardViewMains;
    }

    public void insertarPublishers(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBaseDatos.TABLE_PUBLISHER, null, contentValues);
        sqLiteDatabase.close();
    }

    public void insertarLikePublisher(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBaseDatos.TABLE_LIKE_NUMBER, null, contentValues);
        sqLiteDatabase.close();
    }

    public int obtenerLikePublisher(CardViewMain cardViewMain){
        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKE_NUMBER_NUMBER + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKE_NUMBER +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKE_NUMBER_ID_PUBLISHER + "=" + cardViewMain.getId();

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor requistros = sqLiteDatabase.rawQuery(query, null);

        while (requistros.moveToNext()){
            likes = requistros.getInt(0);
        }

        sqLiteDatabase.close();

        return likes;
    }

    public void insertarFiveFavorite(CardViewMain cardViewMain, ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        String query = "DELETE FROM " + ConstantesBaseDatos.TABLE_FIVE_FAVORITE +
                " WHERE " + ConstantesBaseDatos.TABLE_PUBLISHER_ID + "=" + cardViewMain.getId();

        sqLiteDatabase.execSQL(query);

        sqLiteDatabase.insert(ConstantesBaseDatos.TABLE_FIVE_FAVORITE, null, contentValues);

        sqLiteDatabase.close();
    }

    public ArrayList<CardViewMain> getFiveFavorite(){
        ArrayList<CardViewMain> cardViewMains = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_FIVE_FAVORITE;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        while(cursor.moveToNext()){
            CardViewMain cardViewMain = new CardViewMain();
            cardViewMain.setId(cursor.getInt(0));
            cardViewMain.setPicture(cursor.getString(1));
            cardViewMain.setName(cursor.getString(2));

            cardViewMains.add(cardViewMain);
        }

        sqLiteDatabase.close();

        return cardViewMains;
    }

}
