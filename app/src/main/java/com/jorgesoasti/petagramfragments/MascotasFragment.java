package com.jorgesoasti.petagramfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * Fragment para Lista de Mascotas
 */
public class MascotasFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas = v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();

        inicializarAdaptador();

        // Inflate the layout for this fragment
        return v;
    }

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.aisha,"Aisha", "40"));
        mascotas.add(new Mascota(R.drawable.amy,"Amy", "27"));
        mascotas.add(new Mascota(R.drawable.bernard,"Bernard", "5"));
        mascotas.add(new Mascota(R.drawable.bernie,"Bernie", "20"));
        mascotas.add(new Mascota(R.drawable.clara,"Clara", "15"));
        mascotas.add(new Mascota(R.drawable.coty,"Coty", "22"));
        mascotas.add(new Mascota(R.drawable.keyla,"Keyla", "35"));
        mascotas.add(new Mascota(R.drawable.tom,"Tom", "29"));
    }

}
