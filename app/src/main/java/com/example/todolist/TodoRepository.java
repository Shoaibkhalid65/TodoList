package com.example.todolist;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoRepository {
    private final TodoDao todoDao;
    private final LiveData<List<Todo>> allTodos;
    public TodoRepository (Application application){
        TodoDatabase todoDatabase=TodoDatabase.getINSTANCE(application.getApplicationContext());
        todoDao=todoDatabase.getTodoDao();
        allTodos=todoDao.getTodos();
    }

    public LiveData<List<Todo>> getAllTodos() {
        return allTodos;
    }
    public void insert(Todo todo){
        new InsertTodoAsyncTask(todoDao);
    }
    public void update(Todo todo){
        new UpdateTodoAsyncTask(todoDao);
    }
    public void delete(Todo todo){
        new DeleteTodoAsyncTask(todoDao);
    }
    private static class InsertTodoAsyncTask extends AsyncTask<Todo,Void,Void>{
        private final TodoDao todoDao;
        public InsertTodoAsyncTask(TodoDao todoDao){
            this.todoDao=todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDao.insertTodo(todos[0]);
            return null;
        }
    }
    private static class UpdateTodoAsyncTask extends AsyncTask<Todo,Void,Void>{
        private final TodoDao todoDao;
        public UpdateTodoAsyncTask(TodoDao todoDao){
            this.todoDao=todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDao.updateTodo(todos[0]);
            return null;
        }
    }
    private static class DeleteTodoAsyncTask extends AsyncTask<Todo,Void,Void>{
        private final TodoDao todoDao;
        public DeleteTodoAsyncTask(TodoDao todoDao){
            this.todoDao=todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDao.deleteTodo(todos[0]);
            return null;
        }
    }
}
