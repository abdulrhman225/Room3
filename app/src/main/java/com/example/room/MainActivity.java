package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    Button btn_show, btn_insert;
    RecyclerView rv;
    Recycler r;
    EditText et_title, et_body;
    public static final String TAG = "mainActivity";
    final mvp mvp = new mvp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_show = findViewById(R.id.main_btn_show);
        btn_insert = findViewById(R.id.main_btn_insert);
        rv = findViewById(R.id.recycler);
        et_title = findViewById(R.id.main_et_title);
        et_body = findViewById(R.id.main_et_body);
        final PostDataBase dataBase = PostDataBase.getInstance(MainActivity.this);


        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtn_insert();
            }
        });


        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAll();
            }
        });
    }

    public void setBtn_insert() {
        String title = et_title.getText().toString();
        String body = et_body.getText().toString();
        Post post = new Post(title, body);
        mvp.setPosts(MainActivity.this, post);
    }

    public void getAll() {
        mvp.getAll(MainActivity.this);
        r = new Recycler(mvp.Posts);
        rv.setAdapter(r);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv.setHasFixedSize(true);
    }

}