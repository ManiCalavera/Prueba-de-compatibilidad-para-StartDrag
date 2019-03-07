package com.example.stardrag;


import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.View.DragShadowBuilder;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends Activity implements OnTouchListener,OnDragListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textView1).setOnTouchListener(this);
        findViewById(R.id.pinkLayout).setOnDragListener(this);
        findViewById(R.id.yellowLayout).setOnDragListener(this);
    }
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            //view.setVisibility(View.INVISIBLE);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean onDrag(View layoutview, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DROP:
                Toast.makeText(this, "Se solto", Toast.LENGTH_SHORT).show();
                View view = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                LinearLayout container = (LinearLayout) layoutview;
                container.addView(view);
                view.setVisibility(View.VISIBLE);
                break;
        }
        return true;
    }
}




