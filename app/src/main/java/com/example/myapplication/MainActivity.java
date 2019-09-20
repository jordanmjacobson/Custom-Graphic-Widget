package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
//import android.view.SurfaceView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity {
    private SeekBar adjustM = null;
    private SeekBar adjustB = null;
    private CustomGraph graph = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        LinearLayout layout = (LinearLayout) findViewById(R.id.customViewLayout);
        adjustM = (SeekBar) findViewById(R.id.adjustM);
        adjustB = (SeekBar) findViewById(R.id.adjustB);


        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        adjustM.setOnSeekBarChangeListener(new onSeekBarChangeListener (){
            @Override
            public void onStopTrackingTouch(SeekBar adjustM){
                //default method
            }
            @Override
            public void onStartTrackingTouch(SeekBar adjustM){
                //default method
            }
            @Override
            public void onProgressChanged(SeekBar adjustM, int progress, boolean fromUser){
                graph.setM(progress);
                graph.draw();
            }
        });
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
