package com.example.custom_list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Repository_List> repository_list=new ArrayList<>();
    private Context context;

    public Adapter(Context context, ArrayList<Repository_List> repository_list){
        this.repository_list =repository_list;
        this.context=context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int i) {
    viewHolder.repo_name.setText(repository_list.get(i).getName());
    viewHolder.owner_name.setText(repository_list.get(i).getOwner().getLogin());
    }

    @Override
    public int getItemCount() {
        return repository_list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView repo_name, owner_name;
        public ViewHolder(@NonNull View view){
            super(view);

            repo_name=(TextView) view.findViewById(R.id.repo_name);
            owner_name=(TextView) view.findViewById(R.id.owner_name);
        }
    }
}
