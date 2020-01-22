package com.example.android.basicweather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private ArrayList<String> mTodoList;

    public TodoAdapter() {
        mTodoList = new ArrayList<>();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.todo_list_item, parent, false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        String todo = mTodoList.get(position);
        holder.bind(todo);
    }

    public void addTodo(String todo) {
        mTodoList.add(0, todo);
        // tell the recycler view that there are data change
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mTodoList.size();
    }


    class TodoViewHolder extends RecyclerView.ViewHolder {
        private TextView mTodoTV;

        public TodoViewHolder(View itemView) {
            super(itemView);
            mTodoTV = itemView.findViewById(R.id.tv_todo_text);
        }

        void bind(String newTodoText) {
            mTodoTV.setText(newTodoText);
        }
    }
}
