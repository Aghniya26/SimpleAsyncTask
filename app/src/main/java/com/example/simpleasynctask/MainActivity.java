package com.example.simpleasynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextVIew;
    private static final String TEXT_STATE="currentText";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextVIew=findViewById(R.id.textView1);

        if(savedInstanceState!=null){
            mTextVIew.setText(savedInstanceState.getString(TEXT_STATE));
        }

    }

    public void startTask(View view){
        mTextVIew.setText(R.string.napping);
        new SimpleAsyncTask(mTextVIew).execute();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_STATE, mTextVIew.getText().toString());
    }
}