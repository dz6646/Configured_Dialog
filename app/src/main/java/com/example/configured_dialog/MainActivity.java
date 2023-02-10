package com.example.configured_dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The Adb.
     */
    AlertDialog.Builder adb;

    /**
     * The Adb 1.
     */
    AlertDialog.Builder adb1;

    /**
     * The Adb 2.
     */
    AlertDialog.Builder adb2;


    /**
     * The Ll.
     */
    LinearLayout LL;

    /**
     * The Si.
     */
    Intent si;

    /**
     * The Color.
     */
    int[] color;

    /**
     * The Colors.
     */
    final String[] colors = {"Red", "Green", "Blue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adb = new AlertDialog.Builder(this);
        adb1 = new AlertDialog.Builder(this);
        adb2 = new AlertDialog.Builder(this);
        LL = findViewById(R.id.mainLayout);
        si = new Intent(this, credits.class);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(si);
        return true;
    }

    /**
     * Albert 1.
     * the first button onClick
     * @param view the view
     */
    public void albert1(View view) {
        color = new int[]{0, 0, 0};

        adb.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i]=255;
                LL.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        AlertDialog window1 = adb.create();
        window1.show();
    }

    /**
     * Albert 2.
     * the second button onClick
     * @param view the view
     */
    public void albert2(View view) {
        color = new int[]{0, 0, 0};

        adb1.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb1.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b)
                {
                    color[i] = 255;
                }
                else if(color[i] == 255)
                {
                    color[i] = 0;
                }
            }
        });
        adb1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LL.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        AlertDialog window1 = adb1.create();
        window1.show();
    }

    /**
     * Albert 3.
     * the third button onClick
     * @param view the view
     */
    public void albert3(View view) {
        LL.setBackgroundColor(Color.WHITE);
    }

    /**
     * Albert 4.
     * the fourth button onClick
     * @param view the view
     */
    public void albert4(View view) {
        adb2.setTitle("EditText");
        final EditText input = new EditText(this);
        input.setHint("Input here");
        adb2.setView(input);
        adb2.setPositiveButton("read", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = input.getText().toString();
                Toast.makeText(MainActivity.this, "The input is: " + str, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog window1 = adb2.create();
        window1.show();
    }
}