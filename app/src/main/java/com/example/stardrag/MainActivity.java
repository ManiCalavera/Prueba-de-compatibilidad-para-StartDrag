package com.example.stardrag;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {
    public ImageView destino1, destino2, destino3, destino4;
    public ImageButton btn1, btn2, btn3, btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        destino1 = findViewById(R.id.destino1);
        destino2 = findViewById(R.id.destino2);
        destino3 = findViewById(R.id.destino3);
        destino4 = findViewById(R.id.destino4);



        btn1.setOnTouchListener(this);
        /*btn2.setOnTouchListener(this);
        btn3.setOnTouchListener(this);
        btn4.setOnTouchListener(this);*/

        destino1.setOnDragListener(this);
        /*destino2.setOnDragListener(this);
        destino3.setOnDragListener(this);
        destino4.setOnDragListener(this);*/

    }

    @Override
    public boolean onDrag(View v, DragEvent event) {

        switch (event.getAction()) {

            case DragEvent.ACTION_DRAG_STARTED:

                Toast.makeText(this, "Empezó", Toast.LENGTH_LONG).show();


            case DragEvent.ACTION_DRAG_ENTERED:
                Toast.makeText(MainActivity.this, "Salí wacho", Toast.LENGTH_LONG).show();


            case DragEvent.ACTION_DROP:


                Toast.makeText(this, "entró",Toast.LENGTH_SHORT).show();


                return true;

        }
        return false;
    }

        @Override
        public boolean onTouch (View v, MotionEvent event){

            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            switch (v.getId()) {
                case R.id.btn1:
                        v.startDrag(null, shadowBuilder, null, DragEvent.ACTION_DRAG_ENTERED);
                    break;
                /*case R.id.btn2:
                        v.startDrag(null, shadowBuilder, null, DragEvent.ACTION_DRAG_ENTERED);
                    break;*/
            }
            return false;
        }
    }


