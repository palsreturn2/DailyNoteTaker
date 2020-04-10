package com.example.dailynotetaker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView displayBox;
    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager layoutM;
    ArrayList<String> myDataset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            displayBox = (RecyclerView)findViewById(R.id.displayBox);
            displayBox.setHasFixedSize(true);
            layoutM = new LinearLayoutManager(this);
            displayBox.setLayoutManager(layoutM);
            myDataset = new ArrayList<String>();
            madapter = new MyAdapter(myDataset);
            displayBox.setAdapter(madapter);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG);
        }

    }

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
    public void showTextBoxMessage(View view)
    {
        Context context = getApplicationContext();
        EditText textinput = (EditText)findViewById(R.id.textInput);
        String txtin = textinput.getText().toString();
        myDataset.add(txtin);
        Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show();

    }
}
