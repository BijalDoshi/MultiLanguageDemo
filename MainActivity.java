package com.tth.languagedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.tth.languagedemo.database.DBHelper;
import com.tth.languagedemo.model.ModelLanguage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;



public class MainActivity extends AppCompatActivity {


    private TextView mTxtLg;
    private TextView mTxtLg2;
    private static String sEndlish = "English";
    private static String sHindi = "Hindi";
    private DBHelper mDBHelper;
    private ArrayList<ModelLanguage> arraylistLg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        init();
        createDataBase();
        String strChoosed= Locale.getDefault().getDisplayLanguage();
        Toast.makeText(MainActivity.this, "Choosed : " + strChoosed, Toast.LENGTH_LONG).show();



        arraylistLg = mDBHelper.getData(strChoosed);


        if(arraylistLg.size() > 0) {
            mTxtLg.setText(arraylistLg.get(0).getName().toString());
            mTxtLg2.setText(arraylistLg.get(0).getAddress().toString());
        }
        /*mSpinLg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strSelected = mSpinLg.getSelectedItem().toString().trim();
                String strName, strAddress;



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/


    }

    public void init() {

        mTxtLg = (TextView) findViewById(R.id.txtLg);
        mTxtLg2 = (TextView) findViewById(R.id.txt2);
        mDBHelper = new DBHelper(MainActivity.this);
        arraylistLg = new ArrayList<ModelLanguage>();
    }

    public void createDataBase() {
        try {

            mDBHelper.createDataBase();

        } catch (IOException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
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
}

