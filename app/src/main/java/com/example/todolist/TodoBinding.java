package com.example.todolist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;

import com.example.todolist.databinding.TodoItemViewBinding;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;

import java.util.List;

public class TodoBinding extends AbstractBindingItem<TodoItemViewBinding> {
    private Todo todo;
    public TodoBinding(Todo todo){
        this.todo=todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public Todo getTodo() {
        return todo;
    }
    @NonNull
    @Override
    public TodoItemViewBinding createBinding(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return TodoItemViewBinding.inflate(layoutInflater,viewGroup,false);
    }

    @Override
    public int getType() {
        return R.id.layout_item_view;
    }

    @Override
    public void bindView(@NonNull TodoItemViewBinding binding, @NonNull List<?> payloads) {
        super.bindView(binding, payloads);
        binding.setTodo(getTodo());
        binding.executePendingBindings();
    }
}
