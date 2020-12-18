package com.example.custom_list_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<Repository_List> repoModels=new ArrayList<>();
    private Adapter repoAdapter;
    private RecyclerView repository_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository_recyclerview=findViewById(R.id.list_recyclerview);
        repository_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        getRepositoryResponse();
    }

    private void getRepositoryResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ConnectionInterface requestInteface=retrofit.create(ConnectionInterface.class);
        Call<List<Repository_List>> call=requestInteface.getRepository_list_JSON();
        call.enqueue(new Callback<List<Repository_List>>() {
            @Override
            public void onResponse(Call<List<Repository_List>> call, Response<List<Repository_List>> response) {
                repoModels=new ArrayList<>(response.body());
                repoAdapter=new Adapter(MainActivity.this,repoModels);
                repository_recyclerview.setAdapter(repoAdapter);
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Repository_List>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}