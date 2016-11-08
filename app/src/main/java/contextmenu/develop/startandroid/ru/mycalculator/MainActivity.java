package contextmenu.develop.startandroid.ru.mycalculator;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static ArrayList<Record> allRecords = new ArrayList<>();

    final static String TABLE_ID = "id";
    final static String TABLE_NAME = "MyMathResults";
    final static String STRING_TAG = "tag";
    final static String STRING_NOTE = "note";
    final static String STRING_RESULT = "result";

    public static final String TAG_COLOR = "color";
    public static int textColor = Color.BLACK;
    static int startSize;

    DBHepler dbHepler;
    SQLiteDatabase database;
    SharedPreferences savedSettings;
    Button results, matrix, settings, calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            load();

            dbHepler = new DBHepler(this);
            database = dbHepler.getWritableDatabase();
            if (allRecords.size()<1){
                Cursor cursor = database.query(TABLE_NAME,null,null,null,null,null,null);
                if (cursor.moveToFirst()){
                    int rowTAGIndex = cursor.getColumnIndex(STRING_TAG);
                    int rowNoteIndex = cursor.getColumnIndex(STRING_NOTE);
                    int rowResultIndex = cursor.getColumnIndex(STRING_RESULT);
                    do {
                        String tempTAG = cursor.getString(rowTAGIndex);
                        String tempNote = cursor.getString(rowNoteIndex);
                        String tempResult = cursor.getString(rowResultIndex);
                        Record tempRecord = new Record(tempTAG,tempNote,tempResult);
                        allRecords.add(tempRecord);
                    }while (cursor.moveToNext());
                }
                cursor.close();
            }
            startSize = allRecords.size();

            results = (Button) findViewById(R.id.resultButton);
            matrix = (Button) findViewById(R.id.matrixButton);
            settings = (Button) findViewById(R.id.settingsButton);
            calculator = (Button) findViewById(R.id.calculatorButton);

            setTextColors();

            results.setOnClickListener(this);
            matrix.setOnClickListener(this);
            settings.setOnClickListener(this);
            calculator.setOnClickListener(this);
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        setTextColors();
    }

    void save(){
        try {
            savedSettings = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor saver = savedSettings.edit();
            saver.putInt(TAG_COLOR, textColor);
            saver.commit();
        } catch(Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }
    void load(){
        try {
            savedSettings = getPreferences(MODE_PRIVATE);
            textColor = savedSettings.getInt(TAG_COLOR, Color.BLACK);
        } catch(Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ArrayList<Long> ID = new ArrayList<>();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = database.query(TABLE_NAME,null,null,null,null,null,null);
        try {
            if (cursor.moveToFirst()){
                do {
                    ID.add(cursor.getLong(cursor.getColumnIndex(TABLE_ID)));
                }while (cursor.moveToNext());
            }
        }catch (Exception e){}
        try {
            for (int i=0;i<allRecords.size();i++){
                if (i<startSize) {
                    contentValues.put(STRING_TAG, allRecords.get(i).getTAG());
                    contentValues.put(STRING_NOTE, allRecords.get(i).getNote());
                    contentValues.put(STRING_RESULT, allRecords.get(i).getResult());
                    database.update(TABLE_NAME, contentValues,TABLE_ID+" = "+ID.get(i), null);
                }else {
                    contentValues.put(STRING_TAG, allRecords.get(i).getTAG());
                    contentValues.put(STRING_NOTE, allRecords.get(i).getNote());
                    contentValues.put(STRING_RESULT, allRecords.get(i).getResult());
                    database.insert(TABLE_NAME, null, contentValues);
                }
            }
        }catch (Exception e){}
        save();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.calculatorButton:
                intent = new Intent(this, Calculator.class);
                startActivity(intent);
                break;
            case R.id.matrixButton:
                intent = new Intent(this, Matrix.class);
                startActivity(intent);
                break;
            case R.id.resultButton:
                intent = new Intent(this, ViewRecords.class);
                startActivity(intent);
                break;
            case R.id.settingsButton:
                intent = new Intent(this, Settings.class);
                startActivity(intent);
                break;
        }
    }
    void setTextColors(){
        results.setTextColor(textColor);
        matrix.setTextColor(textColor);
        settings.setTextColor(textColor);
        calculator.setTextColor(textColor);
    }

    class DBHepler extends SQLiteOpenHelper{
        public DBHepler(Context context){
            super(context,"MyMathBase",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+TABLE_NAME+"( "
            +TABLE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +STRING_TAG+" TEXT, "+STRING_NOTE+" TEXT, "+STRING_RESULT+" TEXT);");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
    public static void AddRecord(Record record){
        allRecords.add(record);
    }
    public static void SetRecord(Record record, int index){
        if (allRecords.size()>index){
            allRecords.set(index,record);
        }
    }
    public static void DeleteRecord(int index){
        allRecords.remove(index);
    }
}
