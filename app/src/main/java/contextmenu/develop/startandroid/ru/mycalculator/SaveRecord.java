package contextmenu.develop.startandroid.ru.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SaveRecord extends AppCompatActivity implements View.OnClickListener{
    EditText note, tag;
    Button save, cancel, delete;
    int position, todo;
    TextView result, resultText, textNote, textTAG;
    Record startRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_record);

        note = (EditText) findViewById(R.id.editNote);
        tag = (EditText) findViewById(R.id.editTAG);
        save = (Button) findViewById(R.id.buttonAddNewRecord);
        cancel = (Button) findViewById(R.id.buttonCancel);
        delete = (Button) findViewById(R.id.buttonDelete);
        result = (TextView) findViewById(R.id.textResultFinal);
        resultText = (TextView) findViewById(R.id.textResultFina);
        textNote = (TextView) findViewById(R.id.testNote);
        textTAG = (TextView) findViewById(R.id.testTAG);

        Intent main = getIntent();
        todo = main.getIntExtra("todo",-1);
        switch (todo){
            case 0:
                result.setText(main.getStringExtra("RESULT"));
                break;
            case 1:
                position = main.getIntExtra("position",0);
                startRecord = MainActivity.allRecords.get(position);
                tag.setText(startRecord.getTAG());
                note.setText(startRecord.getNote());
                result.setText(startRecord.getResult());
        }

        note.setTextColor(MainActivity.textColor);
        tag.setTextColor(MainActivity.textColor);
        save.setTextColor(MainActivity.textColor);
        cancel.setTextColor(MainActivity.textColor);
        result.setTextColor(MainActivity.textColor);
        resultText.setTextColor(MainActivity.textColor);
        textTAG.setTextColor(MainActivity.textColor);
        textNote.setTextColor(MainActivity.textColor);
        delete.setTextColor(MainActivity.textColor);

        cancel.setOnClickListener(this);
        save.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.buttonAddNewRecord:
                switch (todo){
                    case 0:
                        String TAGtoAdd0 = tag.getText().toString();
                        String NoteToAdd0 = note.getText().toString();
                        String ResultToAdd0 = result.getText().toString();
                        startRecord = new Record(TAGtoAdd0,NoteToAdd0,ResultToAdd0);
                        MainActivity.AddRecord(startRecord);
                        break;
                    case 1:
                        startRecord.setTAG(tag.getText().toString());
                        startRecord.setNote(note.getText().toString());
                        MainActivity.SetRecord(startRecord,position);
                        break;
                }
                setResult(RESULT_OK);
                break;
            case R.id.buttonCancel:
                setResult(RESULT_CANCELED);
                break;
            case R.id.buttonDelete:
                if (todo==1){
                    MainActivity.DeleteRecord(position);
                }else {
                    Toast.makeText(this,"Nothing to delete",Toast.LENGTH_LONG).show();
                }
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
