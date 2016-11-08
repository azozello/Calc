package contextmenu.develop.startandroid.ru.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity implements View.OnClickListener{

    final int SAVE_REQUEST = 1;
    final int LOAD_REQUEST = 2;
    static TextView sign, first, second;
    static StringBuilder screenFirstNumber,screenSecondNumber;
    String screenSign;
    int toDo = 0;
    static boolean choose = false, flag = false;
    static double firstNumber = 0, secondNumber = 0;
    Button zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, multiply, div, result, backspace, point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        sign = (TextView) findViewById(R.id.sign);
        first = (TextView) findViewById(R.id.firstNumber);
        second = (TextView) findViewById(R.id.secondNumber);

        sign.setTextColor(MainActivity.textColor);
        first.setTextColor(MainActivity.textColor);
        second.setTextColor(MainActivity.textColor);

        screenFirstNumber = new StringBuilder();
        screenSecondNumber = new StringBuilder();
        screenSign = "";

        zero = (Button) findViewById(R.id.buttonZero);
        one = (Button) findViewById(R.id.buttonOne);
        two = (Button) findViewById(R.id.buttonTwo);
        three = (Button) findViewById(R.id.buttonThree);
        four = (Button) findViewById(R.id.buttonFour);
        five = (Button) findViewById(R.id.buttonFive);
        six = (Button) findViewById(R.id.buttonSix);
        seven = (Button) findViewById(R.id.buttonSeven);
        eight = (Button) findViewById(R.id.buttonEight);
        nine = (Button) findViewById(R.id.buttonNine);
        plus = (Button) findViewById(R.id.buttonPlus);
        minus = (Button) findViewById(R.id.buttonMinus);
        multiply = (Button) findViewById(R.id.buttonMultiply);
        div = (Button) findViewById(R.id.buttonDiv);
        result = (Button) findViewById(R.id.buttonResult);
        backspace = (Button) findViewById(R.id.buttonBackSpace);
        point = (Button) findViewById(R.id.buttonPoint);

        zero.setTextColor(MainActivity.textColor);
        one.setTextColor(MainActivity.textColor);
        two.setTextColor(MainActivity.textColor);
        three.setTextColor(MainActivity.textColor);
        four.setTextColor(MainActivity.textColor);
        five.setTextColor(MainActivity.textColor);
        six.setTextColor(MainActivity.textColor);
        seven.setTextColor(MainActivity.textColor);
        eight.setTextColor(MainActivity.textColor);
        nine.setTextColor(MainActivity.textColor);
        plus.setTextColor(MainActivity.textColor);
        minus.setTextColor(MainActivity.textColor);
        div.setTextColor(MainActivity.textColor);
        multiply.setTextColor(MainActivity.textColor);
        result.setTextColor(MainActivity.textColor);
        backspace.setTextColor(MainActivity.textColor);
        point.setTextColor(MainActivity.textColor);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        div.setOnClickListener(this);
        multiply.setOnClickListener(this);
        result.setOnClickListener(this);
        backspace.setOnClickListener(this);
        point.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id){
            case R.id.menu_reset:
                screenSign = "";
                screenFirstNumber = new StringBuilder();
                screenSecondNumber = new StringBuilder();
                firstNumber = 0;
                secondNumber = 0;
                toDo = 0;
                choose = false;
                sign.setText(screenSign);
                first.setText(screenFirstNumber);
                second.setText(screenSecondNumber);
                return true;
            case R.id.menu_save:
                intent = new Intent(this,SaveRecord.class);
                intent.putExtra("RESULT",screenFirstNumber.toString());
                intent.putExtra("todo",0);
                startActivityForResult(intent,SAVE_REQUEST);
                return true;
            case R.id.menu_load:
                intent = new Intent(this, ViewRecords.class);
                intent.putExtra("forResult",true);
                startActivityForResult(intent, LOAD_REQUEST);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            switch (requestCode){
                case SAVE_REQUEST:
                    Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
                    break;
                case LOAD_REQUEST:
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.buttonZero:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append("0");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append("0");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;
            case R.id.buttonOne:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append("1");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append("1");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;
            case R.id.buttonTwo:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append("2");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append("2");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;
            case R.id.buttonThree:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append("3");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append("3");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;
            case R.id.buttonFour:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append("4");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append("4");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;
            case R.id.buttonFive:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append("5");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append("5");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;
            case R.id.buttonSix:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append("6");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append("6");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;
            case R.id.buttonSeven:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append("7");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append("7");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;
            case R.id.buttonEight:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append("8");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append("8");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;
            case R.id.buttonNine:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append("9");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append("9");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;
            case R.id.buttonPoint:
                if (!choose){
                    if (screenFirstNumber.length()<10) screenFirstNumber.append(".");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    first.setText(screenFirstNumber);
                }else {
                    if (screenSecondNumber.length()<10) screenSecondNumber.append(".");
                    else Toast.makeText(this,"Your number is too long",Toast.LENGTH_SHORT).show();
                    second.setText(screenSecondNumber);
                }
                break;

            case R.id.buttonBackSpace:
                if (flag){
                    firstNumber = 0;
                    screenFirstNumber = new StringBuilder();
                    first.setText(screenFirstNumber);
                    flag = false;
                    choose = false;
                }
                else {
                    if (!choose){
                        if (screenFirstNumber.length()>0) {
                            screenFirstNumber.deleteCharAt(screenFirstNumber.length() - 1);
                            first.setText(screenFirstNumber);
                        }
                    }else {
                        if (screenSecondNumber.length()>0){
                            screenSecondNumber.deleteCharAt(screenSecondNumber.length()-1);
                            second.setText(screenSecondNumber);
                        }
                    }
                }

                break;
            case R.id.buttonPlus:
                screenSign = "+";
                sign.setText(screenSign);
                try{
                    firstNumber = Double.parseDouble(screenFirstNumber.toString());
                    toDo = 1;
                    choose = true;
                }catch (Exception e){Toast.makeText(this,"Enter firts number",Toast.LENGTH_SHORT).show();}
                break;

            case R.id.buttonMinus:
                screenSign = "-";
                sign.setText(screenSign);
                try{
                    firstNumber = Double.parseDouble(screenFirstNumber.toString());
                    toDo = 2;
                    choose = true;
                }catch (Exception e){Toast.makeText(this,"Enter firts number",Toast.LENGTH_SHORT).show();}
                break;

            case R.id.buttonMultiply:
                screenSign = "*";
                sign.setText(screenSign);
                try{
                    firstNumber = Double.parseDouble(screenFirstNumber.toString());
                    toDo = 3;
                    choose = true;
                }catch (Exception e){Toast.makeText(this,"Enter firts number",Toast.LENGTH_SHORT).show();}
                break;

            case R.id.buttonDiv:
                screenSign = "/";
                sign.setText(screenSign);
                try{
                    firstNumber = Double.parseDouble(screenFirstNumber.toString());
                    toDo = 4;
                    choose = true;
                }catch (Exception e){Toast.makeText(this,"Enter firts number",Toast.LENGTH_SHORT).show();}
                break;

            case R.id.buttonResult:
                try{
                    String toShow;
                    switch (toDo){
                        case 1:
                            secondNumber = Double.parseDouble(screenSecondNumber.toString());
                            screenSign = "";
                            screenFirstNumber = new StringBuilder();
                            screenSecondNumber = new StringBuilder();
                            firstNumber += secondNumber;
                            secondNumber = 0;
                            toDo = 0;
                            choose = true;
                            flag = true;
                            toShow = String.valueOf(firstNumber);
                            if (toShow.length()>10) screenFirstNumber.append(toShow.substring(0,10));
                            else screenFirstNumber.append(toShow);
                            sign.setText(screenSign);
                            first.setText(screenFirstNumber);
                            second.setText(screenSecondNumber);
                            break;
                        case 2:
                            secondNumber = Double.parseDouble(screenSecondNumber.toString());
                            screenSign = "";
                            screenFirstNumber = new StringBuilder();
                            screenSecondNumber = new StringBuilder();
                            firstNumber -= secondNumber;
                            secondNumber = 0;
                            toDo = 0;
                            choose = true;
                            flag = true;
                            toShow = String.valueOf(firstNumber);
                            if (toShow.length()>10) screenFirstNumber.append(toShow.substring(0,10));
                            else screenFirstNumber.append(toShow);
                            sign.setText(screenSign);
                            first.setText(screenFirstNumber);
                            second.setText(screenSecondNumber);
                            break;
                        case 3:
                            secondNumber = Double.parseDouble(screenSecondNumber.toString());
                            screenSign = "";
                            screenFirstNumber = new StringBuilder();
                            screenSecondNumber = new StringBuilder();
                            firstNumber *= secondNumber;
                            secondNumber = 0;
                            toDo = 0;
                            choose = true;
                            flag = true;
                            toShow = String.valueOf(firstNumber);
                            if (toShow.length()>10) screenFirstNumber.append(toShow.substring(0,10));
                            else screenFirstNumber.append(toShow);
                            sign.setText(screenSign);
                            first.setText(screenFirstNumber);
                            second.setText(screenSecondNumber);
                            break;
                        case 4:
                            secondNumber = Double.parseDouble(screenSecondNumber.toString());
                            screenSign = "";
                            screenFirstNumber = new StringBuilder();
                            screenSecondNumber = new StringBuilder();
                            firstNumber /= secondNumber;
                            secondNumber = 0;
                            toDo = 0;
                            choose = true;
                            flag = true;
                            toShow = String.valueOf(firstNumber);
                            if (toShow.length()>10) screenFirstNumber.append(toShow.substring(0,10));
                            else screenFirstNumber.append(toShow);
                            sign.setText(screenSign);
                            first.setText(screenFirstNumber);
                            second.setText(screenSecondNumber);
                            break;
                    }
                }catch (Exception e){
                    Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
