package com.example.moviesearch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import retrofit2.Call;
import retrofit2.Response;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MainActivity2 extends AppCompatActivity {

    TextView textView_get;
    Call<data_model> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView_get = findViewById(R.id.textView_get);

        String text;
        Intent intent = getIntent();
        text = intent.getStringExtra("대사");

        textView_get.setText("입력 받은 대사 :" + " " + text);
        System.out.println("입력 받은 대사 :" + " " + text);


        call = retrofit_client.getApiService().test_api_get(text);
        call.enqueue(new Callback<data_model>(){
            //콜백 받는 부분
            @Override
            public void onResponse(Call<data_model> call, Response<data_model> response) {
                data_model result = response.body();
                String str;
                str =
                        result.getName()+"\n";

                textView_get.setText(str);
            }

            @Override
            public void onFailure(Call<data_model> call, Throwable t) {

            }
        });




    }

}