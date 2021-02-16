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
```
#### activity_demo.xml
```xml
```


## Скриншоты:
#### Часть 2:
![Часть 2](https://github.com/DevRedOWL/HSE-Android-Course/blob/main/Screenshots/0_2.png?raw=true)
