package com.example.adi.scissor_paper_rock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public void sendName(View view){
        EditText Name=(EditText) findViewById(R.id.name);
        String name=Name.getText().toString();
        if(name.isEmpty())
            return;
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE,name);
        startActivity(intent);
    }
}
