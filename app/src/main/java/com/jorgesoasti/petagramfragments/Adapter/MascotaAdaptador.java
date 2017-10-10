package com.jorgesoasti.petagramfragments.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jorgesoasti.petagramfragments.Pojo.Mascota;
import com.jorgesoasti.petagramfragments.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false); //Indica cual es el Layout que estará reciclando el RecyclerView
        return new MascotaViewHolder(v); //Pasar el View al constructor
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.imgMascota.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvLikes.setText(mascota.getLikes());

        holder.btnLikeBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Te gustó " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvLikes;
        private ImageButton btnLikeBlanco;
        private ImageButton btnLikeAmarillo;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota = itemView.findViewById(R.id.imgFotoMacota);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvLikes = itemView.findViewById(R.id.tvLikes);
            btnLikeBlanco = itemView.findViewById(R.id.btnLikeBlanco);
            btnLikeAmarillo = itemView.findViewById(R.id.btnLikeAmarillo);
        }
    }

}
