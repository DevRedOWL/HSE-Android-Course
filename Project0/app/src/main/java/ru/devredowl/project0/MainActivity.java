package ru.devredowl.project0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPrepodScheduleClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.prep_schedule, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onStudentScheduleClick(View view) {

        Toast toast = Toast.makeText(getApplicationContext(), R.string.stud_schedule, Toast.LENGTH_SHORT);
        toast.show();
    }
}
