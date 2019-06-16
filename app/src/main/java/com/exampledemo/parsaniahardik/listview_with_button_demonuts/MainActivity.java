package com.exampledemo.parsaniahardik.listview_with_button_demonuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    public static ArrayList<Model> modelArrayList;
    private CustomAdapter customAdapter;
    private Button btnnext;
    private String[] fruitlist = new String[]{"Apples", "Oranges", "Potatoes", "Tomatoes","Grapes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        btnnext = (Button) findViewById(R.id.next);

        modelArrayList = getModel();
        customAdapter = new CustomAdapter(this);
        lv.setAdapter(customAdapter);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Model> getModel(){
        ArrayList<Model> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){

            Model model = new Model();
            model.setNumber(0);
            model.setFruit(fruitlist[i]);
            list.add(model);
        }
        return list;
    }
}
