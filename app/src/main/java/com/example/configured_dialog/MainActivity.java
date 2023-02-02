package com.example.configured_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder adb;

    AlertDialog window1;

    LinearLayout LL;

    int[] color;

    final String[] colors = {"Red", "Green", "Blue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adb = new AlertDialog.Builder(this);
        LL = findViewById(R.id.mainLayout);

    }

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
        window1 = adb.create();
        window1.show();
    }

    public void albert2(View view) {
        color = new int[]{0, 0, 0};

        adb.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
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
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LL.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        window1 = adb.create();
        window1.show();
    }

    public void albert3(View view) {
    }

    public void albert4(View view) {
    }
}