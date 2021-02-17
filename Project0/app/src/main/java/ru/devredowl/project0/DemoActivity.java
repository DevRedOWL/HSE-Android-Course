package ru.devredowl.project0;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends AppCompatActivity {

    // Объявляем свойства
    private EditText number;
    private TextView result;
    private int limit1 = 10000;
    private int limit2 = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        number = findViewById(R.id.number);
        result = findViewById(R.id.result);
    }

    // Метод, получающий длину необходимого массива из текстового поля
    public int validateLength() {
        String numberVal = number.getText().toString();
        numberVal = numberVal.isEmpty() ? "0" : numberVal;
        return Integer.parseInt(numberVal);
    }

    // Сложение всех элементов до данного числа
    public void onButton1Click(View view) {
        int len = validateLength();
        if(len > limit1)  {
            Toast toast = Toast.makeText(getApplicationContext(),  String.format(getString(R.string.NoMoreThan), limit1), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<len; i++){
            list.add(i+1);
        }

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        result.setText(String.format("Result1: %d", sum));
    }

    // Произведение всех четных чисел
    public void onButton2Click(View view) {
        int len = validateLength();
        if(len > limit2)  {
            Toast toast = Toast.makeText(getApplicationContext(),  String.format(getString(R.string.NoMoreThan), limit2), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        int mul = 0;
        for (int i = 0; i<len; i++){
            if(i == 1) mul = 2;
            else if (i % 2 != 0) mul *= (i+=1);
        }

        result.setText(String.format("Result2: %d", mul));
    }

}
