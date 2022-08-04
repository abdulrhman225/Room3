package com.example.room;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class mvp {
    ArrayList<Post> Posts = new ArrayList<>();

    public void getAll (Context context){
         PostDataBase.getInstance(context).postDao()
                .getAllPosts().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Post> posts) {
                        Posts = (ArrayList<Post>) posts;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void setPosts (Context context , Post post){
        PostDataBase.getInstance(context).postDao().insert(post)
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
}
