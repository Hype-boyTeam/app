package com.example.moviesearch;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;



public class MainActivity extends AppCompatActivity {

    //권한 허용 == 1
    final int PERMISSION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //어플리케이션 시작 할 때 권한 체크
        if (Build.VERSION.SDK_INT >= 23) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET,
                    Manifest.permission.RECORD_AUDIO}, PERMISSION);
        }

        SearchView searchView;
        searchView = findViewById(R.id.search_view);
        ExtendedFloatingActionButton efab = findViewById(R.id.Voice_Button);

        searchView.setSubmitButtonEnabled(true);





        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                TextView text1 = (TextView)findViewById(R.id.txtresult);

                intent.putExtra("대사", query);
                startActivity(intent);
                return true;
            }

            //텍스트가 바뀔때마다 호출
            @Override
            public boolean onQueryTextChange(String newText) {
                TextView text1 = (TextView)findViewById(R.id.txtsearch);
               
                return true;
            }


        });





//      보이스 버튼 누르면 보이스 xml로 넘어가는 코드
        efab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VoiceActivity.class);
                startActivity(intent);

            }
        });





    }


}
