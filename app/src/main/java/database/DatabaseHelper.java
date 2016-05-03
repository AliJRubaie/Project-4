package database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableRow;

import com.example.android.e.R;

/**
 * Created by Admin on 4/10/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    DatabaseHelper mOpenHelper;


    private static final String DBNAME = "EVENTS";
    private static final int DBVERSION = 1;
    private static final String EVENTS = "Events";

    private static final String SQL_CREATE_EVENTS = "CREATE TABLE " + EVENTS + "(Id INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT, Description TEXT, Category TEXT)";
    private static final String SQL_DROP_EVENTS = "DROP TABLE IF EXIST " + EVENTS;

    public DatabaseHelper(Context context) {

        super(context, DBNAME, null, DBVERSION);

    }




    public void removeSingleContact(int id) {
        //Open the database
        SQLiteDatabase database = this.getWritableDatabase();

        //Execute sql query to remove from database
        //NOTE: When removing by String in SQL, value must be enclosed with ''
        database.execSQL("DELETE FROM " + EVENTS + " WHERE Id" + "= '" + id + "'");

        //Close the database
        database.close();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_EVENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_EVENTS);
        onCreate(db);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    public Object getAllContacts() {
        return EVENTS;
    }
}
