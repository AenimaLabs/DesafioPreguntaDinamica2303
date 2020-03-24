package com.example.desafiopreguntadinamica2303;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.desafiopreguntadinamica2303.api.Api;
import com.example.desafiopreguntadinamica2303.api.RetrofitClient;
import com.example.desafiopreguntadinamica2303.fragment.Fragmento;
import com.example.desafiopreguntadinamica2303.pojo.RespuestaApi;
import com.example.desafiopreguntadinamica2303.pojo.Result;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   private String pCosa, sCosa, tCosa, cCosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.wtf("Error", "pasa");
        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getQuestion();

        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                pCosa = response.body().getResults().get(0).getQuestion();
                sCosa = response.body().getResults().get(0).getCategory();
                tCosa = response.body().getResults().get(0).getDifficulty();
                cCosa = response.body().getResults().get(0).getCorrectAnswer();
                initializeFragment(pCosa,sCosa,tCosa,cCosa);

            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                Log.e("ERRORES", t.toString());
                Toast.makeText(MainActivity.this, "Algo fallo, intentelo despues", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initializeFragment (String c1, String c2, String c3, String c4){
        Log.e("ERROR", "SI_PASA");
        Fragmento fragmento = Fragmento.newInstance(c1, c2, c3, c4);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, fragmento, "FRAGMENTO").commit();
    }

}
