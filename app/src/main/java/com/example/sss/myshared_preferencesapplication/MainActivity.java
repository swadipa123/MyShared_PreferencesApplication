package com.example.sss.myshared_preferencesapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1;

    public static final String MyPreferences="Myprefs";
    public static final String Name ="namekey";
    public static final String Email="emailkey";

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.edittext);
        ed2=(EditText)findViewById(R.id.edittext2);

        b1=(Button)findViewById(R.id.button);
        sharedpreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=ed1.getText().toString();
                String e=ed2.getText().toString();

                SharedPreferences.Editor editor =sharedpreferences.edit();

                editor.putString(Name,n);
                editor.putString(Email,e);
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
            }
        });
    }
}
