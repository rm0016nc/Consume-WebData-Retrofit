package com.example.rm0016nc.a6_consumewebdataretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiservice= retrofit.create(ApiService.class);

        Call<List<Movies>> call = apiservice.getmNames();

        call.enqueue(new Callback<List<Movies>>() {
            @Override
            public void onResponse(Call<List<Movies>> call, Response<List<Movies>> response) {
                List<Movies> mNames = response.body();

                for(Movies m: mNames) {
                    Log.d("title", m.getTitle());
                    Log.d("description", m.getDescription());
                    Log.d("director", m.getDescription());
                }

                String[] movieNames = new String[mNames.size()];

                for(int i = 0; i < mNames.size(); i++) {
                    movieNames[i] = mNames.get(i).getTitle() +  "\n" + "\n" + mNames.get(i).getDirector() + "\n" + "\n" + mNames.get(i).getDescription();
                }

                listView.setAdapter(
                        new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                movieNames
                        )
                );
            }

            @Override
            public void onFailure(Call<List<Movies>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
