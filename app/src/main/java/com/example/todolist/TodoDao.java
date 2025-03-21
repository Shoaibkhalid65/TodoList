package com.example.todolist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoDao {
    @Insert
    void insertTodo(Todo todo);
    @Update
    void updateTodo(Todo todo);
    @Delete
    void deleteTodo(Todo todo);
    @Query("SELECT * FROM todo ORDER BY id DESC")
    LiveData<List<Todo>> getTodos();

}
