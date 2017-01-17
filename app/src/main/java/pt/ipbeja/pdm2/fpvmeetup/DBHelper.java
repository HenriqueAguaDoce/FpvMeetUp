package pt.ipbeja.pdm2.fpvmeetup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pt.ipbeja.pdm2.fpvmeetup.Model.Users;

/**
 * Created by HenriqueAD on 09/01/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_FILENAME = "MyDB.db";
    private static final int DB_VERSION = 1;
    private static final SQLiteDatabase.CursorFactory factory = null;

    private static final int IDX_USERS = 0;

    //Array com todos os nomes das tabelas
    private static final String [] TableNames = {
            "users"
    };

    //Colunas da tabela users
    private static final String T_USERS_ID = "_id_user";
    private static final String T_USERS_NAME = "name";
    private static final String T_USERS_PASSWORD = "password";
    private static final String T_USERS_EMAIL = "email";

    //String sql para criar tabela utilizadores
    private static final String T_CREATE_USERS = "CREATE TABLE " +TableNames[IDX_USERS] +
            "(" + T_USERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
            ", " + T_USERS_NAME + " TEXT" +
            ", " + T_USERS_PASSWORD + " TEXT" +
            ", " + T_USERS_EMAIL + " TEXT)" ;

    //todos os comandos sql de criação de tabelas
    private static final String [] T_CREATE = {
            T_CREATE_USERS
    };

    public DBHelper(Context context) {
        super(context, DB_FILENAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // criar todas as tabelas
        for (int i = 0; i < T_CREATE.length; i++) {
            db.execSQL(T_CREATE[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int i = 0; i < TableNames.length; i++) {
            db.execSQL("DROP TABLE IF EXISTS " + TableNames[i]);
        }
        onCreate(db);
    }

    public void insertUsers(Users users)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(T_USERS_NAME, users.getName());
        contentValues.put(T_USERS_PASSWORD, users.getPassword());
        contentValues.put(T_USERS_EMAIL, users.getEmail());

        db.insert(TableNames[IDX_USERS], null, contentValues);
    }

    public boolean getUserAndPass(String login, String pass)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT "  + T_USERS_NAME + "," +T_USERS_PASSWORD +
                " FROM " + TableNames[IDX_USERS] + " WHERE " + T_USERS_NAME + " = " +
                "'" + login + "' " + "AND " + T_USERS_PASSWORD + " = " +
                "'" + pass + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor != null && cursor.getCount() == 1;
    }

    public int getIDfromUser(String login, String pass)
    {
        int res = -1;
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT "  + T_USERS_ID +
                " FROM " + TableNames[IDX_USERS] + " WHERE " + T_USERS_NAME + " = " +
                "'" + login + "' " + "AND " + T_USERS_PASSWORD + " = " +
                "'" + pass + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            res = cursor.getInt(cursor.getColumnIndex(T_USERS_ID));
        }
        cursor.close();
        return res;

    }

    public String getEmail(String login, String pass)
    {
        String res = "";
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT "  + T_USERS_EMAIL +
                " FROM " + TableNames[IDX_USERS] + " WHERE " + T_USERS_NAME + " = " +
                "'" + login + "' " + "AND " + T_USERS_PASSWORD + " = " +
                "'" + pass + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            res = cursor.getString(cursor.getColumnIndex(T_USERS_EMAIL));
        }
        cursor.close();
        return res;
    }

    public List<String> getAllUserNames() {
        List<String> res = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + T_USERS_NAME + " FROM " + TableNames[IDX_USERS];

        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(T_USERS_NAME));
                res.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return res;
    }
}
