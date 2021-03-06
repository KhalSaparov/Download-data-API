package com.example.server;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Fragment_Data extends Fragment {
    ImageView myImage;
    RecyclerAdapter adapter;
    News states;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Parser();
    }

    private void Parser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Pixel pixel = retrofit.create(Pixel.class);

        Call<News> call = pixel.getData("apple","37c3af62212a40d2a1ac2a0bccbccfea");

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.code() != 200) {
                    System.out.println("401 error");
                    return;
                }
                states = response.body();
                RecyclerView recyclerView = getView().findViewById(R.id.list);

                adapter = new RecyclerAdapter(getActivity().getApplicationContext(), states, onItem);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }

    onClickerAdapter onItem = new onClickerAdapter() {
    @Override
    public void onClick(Post article) {
        ((MainActivity) getActivity()).post = article;
        ((MainActivity) getActivity()).fragmentChange(2);
    }
};

}
