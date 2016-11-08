package contextmenu.develop.startandroid.ru.mycalculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewRecords extends AppCompatActivity implements View.OnClickListener{

    final int EDIT_REQUEST = 2;

    Button find;
    TextView listItem;
    EditText finder;
    ListView recordsList;
    ArrayAdapter<String> startAdapter;
    ArrayList<String> TAGs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);

        for (int i=0;i<MainActivity.allRecords.size();i++){
            TAGs.add(MainActivity.allRecords.get(i).getTAG());
        }

        find = (Button) findViewById(R.id.buttonFindRecord);
        finder = (EditText) findViewById(R.id.finderET);
        listItem = (TextView) findViewById(R.id.textItem);
        recordsList = (ListView) findViewById(R.id.recordsList);

        find.setTextColor(MainActivity.textColor);
        finder.setTextColor(MainActivity.textColor);
        find.setOnClickListener(this);

        startAdapter = new ArrayAdapter<String>(this, R.layout.listitem,  TAGs){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(R.id.textItem);
                textView.setTextColor(MainActivity.textColor);
                return view;
            }
        };
        recordsList.setAdapter(startAdapter);

        final Intent intent = new Intent(this, SaveRecord.class);
        recordsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("position",position);
                intent.putExtra("todo",1);
                startActivityForResult(intent,EDIT_REQUEST);
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonFindRecord:
                ArrayAdapter<String> secondAdapter;
                if (!finder.getText().toString().equals("")) {
                    ArrayList<String> newfin = new ArrayList<>();
                    char[] finderChars = finder.getText().toString().toCharArray();
                    for (int k = 0; k < TAGs.size(); k++) {
                        boolean ad = false;
                        char[] t = TAGs.get(k).toCharArray();
                        ArrayList<String> sfc = new ArrayList<>();
                        for (int j=0;j<t.length;j++){
                            sfc.add(String.valueOf(t[j]).toLowerCase());
                        }
                        for (int i=0;i<finderChars.length;i++){
                            if (sfc.contains(String.valueOf(finderChars[i]).toLowerCase())) ad = true;
                            else ad = false;
                        }
                        if (ad) newfin.add(TAGs.get(k));
                    }
                    secondAdapter = new ArrayAdapter<String>(this, R.layout.listitem, newfin){
                        @NonNull
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);
                            TextView textView = (TextView) view.findViewById(R.id.textItem);
                            textView.setTextColor(MainActivity.textColor);
                            return view;
                        }
                    };
                    recordsList.setAdapter(secondAdapter);
                }
                else {
                    secondAdapter = new ArrayAdapter<String>(this, R.layout.listitem, TAGs){
                        @NonNull
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);
                            TextView textView = (TextView) view.findViewById(R.id.textItem);
                            textView.setTextColor(MainActivity.textColor);
                            return view;
                        }
                    };
                    recordsList.setAdapter(secondAdapter);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ArrayAdapter<String> finishAdapter;
        if (resultCode==RESULT_OK){
            try{
                for (int i=0;i<MainActivity.allRecords.size();i++){
                    if (i<TAGs.size()) {
                        TAGs.set(i, MainActivity.allRecords.get(i).getTAG());
                    }else {
                        TAGs.add(MainActivity.allRecords.get(i).getTAG());
                    }
                }
            }catch (Exception e){
                Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
            }
            finishAdapter = new ArrayAdapter<String>(this, R.layout.listitem,  TAGs){
                @NonNull
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView textView = (TextView) view.findViewById(R.id.textItem);
                    textView.setTextColor(MainActivity.textColor);
                    return view;
                }
            };
            recordsList.setAdapter(finishAdapter);
        }
    }
}
