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

        textView_get.setText("입력 받은 대사 :" + " " + text +"\n");
        System.out.println("입력 받은 대사 :" + " " + text);


        Call <List<data_model>> call = retrofit_client.getApiService().test_api_get(text);
        call.enqueue(new Callback<List<data_model>>(){
            //콜백 받는 부분
            @Override
            public void onResponse(Call<List<data_model>>call, Response<List<data_model>> response) {
                List<data_model> result = response.body();
                for(data_model data_model : result) {
                    String content = "";

                    content += "제목 : " +  data_model.getName() + "\n";
                    content += "개봉 일자 : " +  data_model.getReleased_at() + "\n";
                    content += "감독 : " +  data_model.getDirector() + "\n";
                    content += "넷플릭스 바로가기 : " +  data_model.getDetails_url()  +"\n";
                    content += "사진 : " +  data_model.getPoster_url() + "\n";


                    textView_get.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<data_model>> call, Throwable t) {

            }
        });




    }
}
