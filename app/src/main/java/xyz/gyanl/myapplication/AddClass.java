package xyz.gyanl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddClass extends AppCompatActivity {
    private TextView name_view;
    private Button mButton1;
    private Button mButton2;
    //counter for button
    private int noun_count;
    private int adjec_count;
    //string array
    String[] nouns;// = getResources().getStringArray(R.array.nouns);
    //String[] nouns; = (String) findViewById(R.array.n)
    String[] adje; //= getResources().getStringArray(R.array.adjec);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        //adding string res to java
        nouns = getResources().getStringArray(R.array.nouns);
        adje = getResources().getStringArray(R.array.adjec);
        //initialise counters
        noun_count = adjec_count = 0;
        //adding text view
        name_view = (TextView) findViewById(R.id.name_gen);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_view.setText(nouns[noun_count%3]+adje[adjec_count%4]);
                noun_count++;

            }
        });

        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_view.setText(nouns[noun_count%3]+adje[adjec_count%4]);
                adjec_count++;
            }
        });




    }
}
