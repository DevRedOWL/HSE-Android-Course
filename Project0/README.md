## Постановка задачи: 
#### Первая часть работы (Demo Activity):
1. Ограничить ввод в поле для ввода только числовыми значениями.
2. Добавить логику для нажатия на кнопку Button2. Считать произведение всех четных чисел и вывести результат на экран по аналогии с кнопкой Button1.
3. Добавить валидацию на диапазон вводимого значения, диапазон придумать самостоятельно. В случае выхода за диапазон выводить Toast с текстом о выходе за диапазон.

#### Вторая часть работы (Main Activity):
1. Файл с логотипом скачать по ссылке https://www.hse.ru/data/2012/01/19/1263884289/logo_%D1%81_hse_cmyk_e.png
2. Поместить скачанный файл в папку drawable-xxxhdpi
3. Сделать верстку экрана как на картинке справа. Создать новую activity и файл с версткой для нее `activity_main.xml`. Запускать по умолчанию данную activity
4. Основные цвета приложения указать в файле стилей `themes.xml`
```md
colorPrimary #003399
colorPrimaryVariant #011F5A
colorSecondary #4080ff
colorSecondaryVariant #0C5DFD
```
5. Тексты для кнопок вынести в файл `strings.xml`
6. Добавить показ Toast при нажатии на кнопки с информацией о нажатой кнопке

## Комментарии
- Для установки ограничения на ввод только чисел в поле был использован атрибут `inputType` со значением `number`, т.к. в массиве количество элементов всегда положительное - `numberSigned` (число со знаком) нам не подходит
- В целях ускорения разработки, события клика задаются через xml а не в java коде
- Для обоих подзадач первой части заданы разные лимиты, т.к. для работы варианта с умножением необходимы числа значительно меньше
- Вместо файла `themes.xml` было удобнее использовать `colors.xml`, к тому же не имеет смысл плодить файлы, выполняющую задачу, тем более при их текущем объеме.
- Опять же для удобства, изображение было помещено в `drawable-v24`, среда разработки предложила поступить аналогично.
- При выводе информации о нажатой кнопке используются данные из ресурсов.

## Листинг:
#### MainActivity.java
```java 
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
```
#### activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="313dp"
        android:layout_height="536dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/logo_hse" />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        android:paddingHorizontal="20dp"
        android:text="@string/stud_schedule"
        android:textColor="#fff"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        android:onClick="onStudentScheduleClick"
        app:layout_constraintTop_toBottomOf="@+id/imageView2" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        android:paddingHorizontal="20dp"
        android:text="@string/prep_schedule"
        android:textColor="#fff"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button1"
        android:onClick="onPrepodScheduleClick"
        app:layout_constraintVertical_bias="0.200" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

#### DemoActivity.java
```java
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
```
#### activity_demo.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".DemoActivity">

    <EditText
        android:id="@+id/number"
        android:layout_width="fill_parent"
        android:layout_height="65dp"
        android:hint="@string/NumberPlaceholder"
        android:ems="10"
        android:inputType="number"
        android:text=""
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="Button 1"
        app:layout_constraintEnd_toEndOf="parent"
        android:onClick="onButton1Click"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/number" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="12dp"
        android:text="Button 2"
        app:layout_constraintEnd_toEndOf="parent"
        android:onClick="onButton2Click"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button" />

    <TextView
        android:id="@+id/result"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="28dp"
        android:text="Результат"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button3" />


</androidx.constraintlayout.widget.ConstraintLayout>
```


## Скриншоты:
#### Часть 1:
![Часть 1](https://github.com/DevRedOWL/HSE-Android-Course/blob/main/Screenshots/0_1.png?raw=true)
#### Часть 2:
![Часть 2](https://github.com/DevRedOWL/HSE-Android-Course/blob/main/Screenshots/0_2.png?raw=true)
