package com.example.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

@Database(entities = Post.class ,version = 2)
public abstract class PostDataBase extends RoomDatabase {
    private static  PostDataBase instance;
    public abstract PostDao postDao() ;

    public static  synchronized  PostDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context , PostDataBase.class , "post_data_base")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
