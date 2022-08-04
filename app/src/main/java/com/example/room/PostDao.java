package com.example.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface PostDao {
    @Insert
    Completable insert(Post post);

    @Query("Select * From post_table ")
    Observable<List<Post>> getAllPosts();
}
