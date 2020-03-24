package com.example.desafiopreguntadinamica2303.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desafiopreguntadinamica2303.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PREG = "param1";
    private static final String ARG_CAT = "param2";
    private static final String ARG_DIF = "param3";
    private static final String ARG_RESPCORRECTA = "param4";


    // TODO: Rename and change types of parameters
    private TextView pregunta, categoria, dificultad;
    private RadioGroup grupoRespuestasView;
    private RadioButton respuestaUno, respuestaDos;

    int valorBoton = 0;

    private String mParam1;
    private String mParam2;

    private String mParam3;
    private String mParam4;

    private Button boton;

    public Fragmento() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Fragmento newInstance(String param1, String param2, String param3, String param4) {
        Fragmento fragment = new Fragmento();
        Bundle args = new Bundle();


        args.putString(ARG_PREG, param1);
        args.putString(ARG_CAT, param2);
        args.putString(ARG_DIF, param3);
        args.putString(ARG_RESPCORRECTA, param4);
        fragment.setArguments(args);
        Log.wtf("ERROR", "PASA EN EL CONSTRUCTOR");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


            mParam1 = getArguments().getString(ARG_PREG);
            mParam2 = getArguments().getString(ARG_CAT);
            mParam3 = getArguments().getString(ARG_DIF);
            mParam4 = getArguments().getString(ARG_RESPCORRECTA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_fragmento, container, false);
        initializeViews(view);

        pregunta.setText(mParam1);
        categoria.setText(mParam2);
        dificultad.setText(mParam3);

        grupoRespuestasView.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (respuestaUno.isChecked()){
                    valorBoton = 1;

                }else if (respuestaDos.isChecked()){
                    valorBoton = 0;
                }
            }
        });
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (respuestaUno.isChecked() && mParam4.equals("True")){
                        Toast.makeText(getContext(), "Pero qué persona más intelectual eres", Toast.LENGTH_SHORT).show();
                    }else if (respuestaDos.isChecked() && mParam4.equals("False")){
                        Toast.makeText(getContext(), "Pero qué persona más intelectual eres", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getContext(), "Eso no sabe, pero para andar carreteando es mandado a hacer", Toast.LENGTH_SHORT).show();
                    }

                }
                });

        return view;

        }

    private void initializeViews(View view) {
        pregunta = view.findViewById(R.id.pregunta_fretro);
        categoria = view.findViewById(R.id.categoria_fretro);
        dificultad = view.findViewById(R.id.dificultad_fretro);
       boton = view.findViewById(R.id.boton_frag);
        grupoRespuestasView = view.findViewById(R.id.radiogrupo_frag);
        respuestaUno = view.findViewById(R.id.radioButton1_frag);
        respuestaDos = view.findViewById(R.id.radioButton2_frag);
    }


}
