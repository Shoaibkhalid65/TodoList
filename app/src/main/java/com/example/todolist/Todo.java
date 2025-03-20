package com.example.todolist;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "todo")
public class Todo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String time;
    private int imageResourceId;

    public Todo(String title, String time, int imageResourceId) {
        this.title = title;
        this.time = time;
        this.imageResourceId = imageResourceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id && imageResourceId == todo.imageResourceId && Objects.equals(title, todo.title) && Objects.equals(time, todo.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, time, imageResourceId);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", imageResourceId=" + imageResourceId +
                '}';
    }
}
