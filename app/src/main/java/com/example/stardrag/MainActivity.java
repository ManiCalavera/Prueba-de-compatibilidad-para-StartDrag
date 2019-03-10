package com.example.stardrag;


import android.Manifest;
import android.annotation.SuppressLint;
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
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private LinearLayout [] linears= new LinearLayout[4];
    private int[] tvs= new int [4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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




        tvs [0]= (R.id.tv5);
        tvs [1]= (R.id.tv6);
        tvs [2]= (R.id.tv7);
        tvs [3]= (R.id.tv8);

        linears [0]= (LinearLayout) linear2;
        linears [1]= (LinearLayout) linear3;
        linears [2]= (LinearLayout) linear4;
        linears [3]= (LinearLayout) linear5;



        btn_check=findViewById(R.id.btn_check);
        btn_check.setOnTouchListener(this);

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










    }

    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (view.getId() != btn_check.getId()) {
                    DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(null, shadowBuilder, view, 0);
                    view.setVisibility(View.INVISIBLE);
                }
                else {
                    if ((linear9.getChildCount()==0)|(linear2.getChildCount()==0)|(linear3.getChildCount()==0)|(linear4.getChildCount()==0)|(linear5.getChildCount()==0)|(linear6.getChildCount()==0)|(linear7.getChildCount()==0)|(linear8.getChildCount()==0)) {
                        Toast.makeText(MainActivity.this, "UPs! te faltó ubicar todas las imágenes!", Toast.LENGTH_SHORT).show();
                        //btn_check.setText(R.string.txt_view_estado);
                    }
                    else{
                        //int u=0;
                        boolean gano;
                        gano = true;
                        for (Integer i = 0; i<4; i++) {
                            if ((linears[i].getChildAt(0).getId() == tvs[0]) || (linears[i].getChildAt(0).getId() == tvs[1]) || (linears[i].getChildAt(0).getId() == tvs[2]) || (linears[i].getChildAt(0).getId() == tvs[3])) {
                                Toast.makeText(MainActivity.this, "UPs! Te equivocaste! inténtalo de nuevo", Toast.LENGTH_SHORT).show();
                                gano= false;
                                //i = i + 1;
                            }
                        }

                        /*while ((u<4)&&(gano)) {
                            if ((linears[i].getChildAt(0).getId() == tvs[0]) || (linears[i].getChildAt(0).getId() == tvs[1]) || (linears[i].getChildAt(0).getId() == tvs[2]) || (linears[i].getChildAt(0).getId() == tvs[3])) {
                                Toast.makeText(MainActivity.this, "UPs! Te equivocaste! inténtalo de nuevo", Toast.LENGTH_SHORT).show();
                                gano= false;
                                u++;
                            }
                        }*/
                        if (gano){
                            Toast.makeText(MainActivity.this,"Ganaste!!!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            break;
        }
    return true;
    }
    public boolean onDrag(View layoutview, DragEvent event) {
        View view = (View) event.getLocalState();
        LinearLayout container = (LinearLayout) layoutview;
        switch (event.getAction()) {


            case DragEvent.ACTION_DROP:

                if (container.getChildCount() == 0) {

                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);

                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                }
                break;

            case DragEvent.ACTION_DRAG_ENDED:
                view.setVisibility(View.VISIBLE);
                break;
        }
    return true;
    }
}





