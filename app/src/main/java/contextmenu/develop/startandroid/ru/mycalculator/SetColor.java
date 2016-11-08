package contextmenu.develop.startandroid.ru.mycalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/*

    Button btnRed;
    Button btnGreen;
    Button btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_color);

        btnRed = (Button) findViewById(R.id.btnRed);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnBlue = (Button) findViewById(R.id.btnBlue);

        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnRed:
                intent.putExtra("color", Color.RED);
                break;
            case R.id.btnGreen:
                intent.putExtra("color", Color.GREEN);
                break;
            case R.id.btnBlue:
                intent.putExtra("color", Color.BLUE);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
 */
public class SetColor extends AppCompatActivity implements View.OnClickListener {

    final int RED = Color.parseColor("#FF0033");
    final int GREEN = Color.parseColor("#33FF00");
    final int BLUE = Color.parseColor("#0033FF");
    final int VIOLET = Color.parseColor("#660066");
    final int INDIGO = Color.parseColor("#000066");
    final int YELLOW = Color.parseColor("#CCFF00");
    final int ORANGE = Color.parseColor("#FF6600");
    final int PURPLE= Color.parseColor("#990066");
    final int DEEP_PURPLE= Color.parseColor("#990099");
    final int PINK = Color.parseColor("#FF0099");
    final int VINOUS = Color.parseColor("#660000");
    final int GREY = Color.parseColor("#333333");
    final int BLACK = Color.parseColor("#000000");
    final int LIME = Color.parseColor("#99CC00");
    final int BOTTLE_GREEN = Color.parseColor("#003300");
    final int AZURE = Color.parseColor("#00CC99");

    Button buttonRed;
    Button buttonGreen;
    Button buttonBlue;
    Button buttonViolet;
    Button buttonIndigo;
    Button buttonYellow;
    Button buttonOrange;
    Button buttonPurple;
    Button buttonDeepPurple;
    Button buttonPink;
    Button buttonVinous;
    Button buttonGrey;
    Button buttonBlack;
    Button buttonLime;
    Button buttonBottleGreen;
    Button buttonAzure;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_color);

        buttonRed = (Button) findViewById(R.id.buttonRED);
        buttonGreen = (Button) findViewById(R.id.buttonGREEN);
        buttonBlue = (Button) findViewById(R.id.buttonBLUE);
        buttonViolet = (Button) findViewById(R.id.buttonVIOLET);
        buttonIndigo = (Button) findViewById(R.id.buttonINDIGO);
        buttonYellow = (Button) findViewById(R.id.buttonYELLOW);
        buttonOrange = (Button) findViewById(R.id.buttonORANGE);
        buttonPurple = (Button) findViewById(R.id.buttonPURPLE);
        buttonDeepPurple = (Button) findViewById(R.id.buttonDEEP_PURPLE);
        buttonPink = (Button) findViewById(R.id.buttonPINK);
        buttonVinous = (Button) findViewById(R.id.buttonVINOUS);
        buttonGrey = (Button) findViewById(R.id.buttonGREY);
        buttonBlack = (Button) findViewById(R.id.buttonBLACK);
        buttonLime = (Button) findViewById(R.id.buttonLIME);
        buttonBottleGreen = (Button) findViewById(R.id.buttonBOTTLE_GREEN);
        buttonAzure = (Button) findViewById(R.id.buttonAZURE);

        buttonRed.setBackgroundColor(RED);
        buttonGreen.setBackgroundColor(GREEN);
        buttonBlue.setBackgroundColor(BLUE);
        buttonViolet.setBackgroundColor(VIOLET);
        buttonIndigo.setBackgroundColor(INDIGO);
        buttonYellow.setBackgroundColor(YELLOW);
        buttonOrange.setBackgroundColor(ORANGE);
        buttonPurple.setBackgroundColor(PURPLE);
        buttonDeepPurple.setBackgroundColor(DEEP_PURPLE);
        buttonPink.setBackgroundColor(PINK);
        buttonVinous.setBackgroundColor(VINOUS);
        buttonGrey.setBackgroundColor(GREY);
        buttonBlack.setBackgroundColor(BLACK);
        buttonLime.setBackgroundColor(LIME);
        buttonBottleGreen.setBackgroundColor(BOTTLE_GREEN);
        buttonAzure.setBackgroundColor(AZURE);

        buttonRed.setOnClickListener(this);
        buttonGreen.setOnClickListener(this);
        buttonBlue.setOnClickListener(this);
        buttonViolet.setOnClickListener(this);
        buttonIndigo.setOnClickListener(this);
        buttonYellow.setOnClickListener(this);
        buttonOrange.setOnClickListener(this);
        buttonPurple.setOnClickListener(this);
        buttonDeepPurple.setOnClickListener(this);
        buttonPink.setOnClickListener(this);
        buttonVinous.setOnClickListener(this);
        buttonGrey.setOnClickListener(this);
        buttonBlack.setOnClickListener(this);
        buttonLime.setOnClickListener(this);
        buttonBottleGreen.setOnClickListener(this);
        buttonAzure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.buttonRED:
                intent.putExtra("color", RED);
                break;
            case R.id.buttonGREEN:
                intent.putExtra("color", GREEN);
                break;
            case R.id.buttonBLUE:
                intent.putExtra("color", BLUE);
                break;
            case R.id.buttonVIOLET:
                intent.putExtra("color", VIOLET);
                break;
            case R.id.buttonINDIGO:
                intent.putExtra("color", INDIGO);
                break;
            case R.id.buttonYELLOW:
                intent.putExtra("color", YELLOW);
                break;
            case R.id.buttonORANGE:
                intent.putExtra("color", ORANGE);
                break;
            case R.id.buttonPURPLE:
                intent.putExtra("color", PURPLE);
                break;
            case R.id.buttonDEEP_PURPLE:
                intent.putExtra("color", DEEP_PURPLE);
                break;
            case R.id.buttonPINK:
                intent.putExtra("color", PINK);
                break;
            case R.id.buttonVINOUS:
                intent.putExtra("color", VINOUS);
                break;
            case R.id.buttonGREY:
                intent.putExtra("color", GREY);
                break;
            case R.id.buttonBLACK:
                intent.putExtra("color", BLACK);
                break;
            case R.id.buttonLIME:
                intent.putExtra("color", LIME);
                break;
            case R.id.buttonBOTTLE_GREEN:
                intent.putExtra("color", BOTTLE_GREEN);
                break;
            case R.id.buttonAZURE:
                intent.putExtra("color", AZURE);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}