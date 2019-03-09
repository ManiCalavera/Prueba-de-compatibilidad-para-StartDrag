package com.example.stardrag;


import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.View.DragShadowBuilder;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnTouchListener,OnDragListener{
    public Button btn_check;
    private int[] arrayDestinoA = new int[4];
    private int[] arrayDestinoO = new int[4];
    private int[] arrayIconosA = new int[4];
    private int[] arrayIconosO = new int[4];
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private LinearLayout linear9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linear1 = findViewById(R.id.linear1)
        //linear1.setOnDragListener(this);
        linear2 = findViewById(R.id.linear2);
        linear2.setOnDragListener(this);
        linear3 = findViewById(R.id.linear3);
        linear3.setOnDragListener(this);
        linear4 = findViewById(R.id.linear4);
        linear4.setOnDragListener(this);
        linear5 = findViewById(R.id.linear5);
        linear5.setOnDragListener(this);
        linear6 = findViewById(R.id.linear6);
        linear6.setOnDragListener(this);
        linear7 = findViewById(R.id.linear7);
        linear7.setOnDragListener(this);
        linear8 = findViewById(R.id.linear8);
        linear8.setOnDragListener(this);
        linear9 = findViewById(R.id.linear9);
        linear9.setOnDragListener(this);




        //btn_check=findViewById(R.id.btn_check)

        tv1= findViewById(R.id.tv1);
        tv1.setOnTouchListener(this);
        tv2= findViewById(R.id.tv2);
        tv2.setOnTouchListener(this);
        tv3= findViewById(R.id.tv3);
        tv3.setOnTouchListener(this);
        tv4= findViewById(R.id.tv4);
        tv4.setOnTouchListener(this);
        tv5= findViewById(R.id.tv5);
        tv5.setOnTouchListener(this);
        tv6= findViewById(R.id.tv6);
        tv6.setOnTouchListener(this);
        tv7= findViewById(R.id.tv7);
        tv7.setOnTouchListener(this);
        tv8= findViewById(R.id.tv8);
        tv8.setOnTouchListener(this);




/*
        arrayIconosA[0]=tv1.getId()
        arrayIconosA[1]=tv2.getId()
        arrayIconosA[2]=tv3.getId()
        arrayIconosA[3]=tv4.getId()
        arrayIconosA[4]=tv5.getId()
        arrayIconosA[5]=tv6.getId()
        arrayIconosA[6]=tv7.getId()
        arrayIconosA[7]=tv8.getId()



        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean gano = true;
                //recorro los 2 array y comparo el que arme con el arrastre contra el que yo tenia guardado.
                if (linear1.onViewAdded(view);==arrayIconosA[0])
                }
                if(gano){
                    Toast.makeText(MainActivity.this, "Gano", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Perdio", Toast.LENGTH_SHORT).show();
                }

            }
        });*/





    }
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(null, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                break;



        }

        return true;
    }
    public boolean onDrag(View layoutview, DragEvent event) {
        /*boolean usado;
        int e;
        e=0;
        usado=true;*/
        View view = (View) event.getLocalState();
        LinearLayout container = (LinearLayout) layoutview;
        switch (event.getAction()) {


            case DragEvent.ACTION_DROP:
                //Toast.makeText(this, "Se solto", Toast.LENGTH_SHORT).show();

                //f (!layoutview.dispatchDragEvent(event)){
                if (container.getChildCount() == 0) {

                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);

                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                }


            // }


                break;

            case DragEvent.ACTION_DRAG_ENDED:
                Toast.makeText(this,"f",Toast.LENGTH_SHORT).show();
                view.setVisibility(View.VISIBLE);
                break;

        }

                return true;

    }


}





