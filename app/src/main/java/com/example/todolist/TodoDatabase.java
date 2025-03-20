package com.example.todolist;

import android.content.Context;
import android.support.v4.app.INotificationSideChannel;

import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.google.android.material.tabs.TabLayout;

@Database(entities = {Todo.class},version = 1)
public abstract class TodoDatabase extends RoomDatabase {
    public abstract TodoDao getTodoDao();
    public static volatile TodoDatabase INSTANCE;

    public static TodoDatabase getINSTANCE(Context context) {
        if(INSTANCE==null){
            synchronized (TodoDatabase.class){
                if(INSTANCE==null){
                    INSTANCE=Room.databaseBuilder(context.getApplicationContext(), TodoDatabase.class,"todo_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
