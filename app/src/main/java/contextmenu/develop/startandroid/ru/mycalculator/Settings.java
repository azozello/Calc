package contextmenu.develop.startandroid.ru.mycalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static contextmenu.develop.startandroid.ru.mycalculator.MainActivity.textColor;

public class Settings extends AppCompatActivity implements View.OnClickListener{

    Button setColor, setTextSize;
    final int REQUEST_COLOR = 1;
    final int REQUEST_SIZE = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setColor = (Button) findViewById(R.id.buttonSetColor);
        setColor.setTextColor(MainActivity.textColor);
        setColor.setOnClickListener(this);

        setTextSize = (Button) findViewById(R.id.buttonSetTextSize);
        setTextSize.setTextColor(MainActivity.textColor);
        setTextSize.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.buttonSetColor:
                intent = new Intent(this, SetColor.class);
                startActivityForResult(intent, REQUEST_COLOR);
                break;
            case R.id.buttonSetTextSize:
                intent = new Intent(this, SetSize.class);
                startActivityForResult(intent, REQUEST_SIZE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case REQUEST_COLOR:
                    MainActivity.textColor = data.getIntExtra("color", Color.BLACK);
                    setColor.setTextColor(MainActivity.textColor);
                    setTextSize.setTextColor(MainActivity.textColor);
                    break;
                case REQUEST_SIZE:

                    break;
            }
        }
    }
}