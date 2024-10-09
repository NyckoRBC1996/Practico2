package com.example.practico2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.practico2.model.Usuario;
import java.util.List;
import com.example.practico2.R;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    private List<Usuario> usuarios;

    public UsuarioAdapter(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void updateUsuarios(List<Usuario> nuevosUsuarios) {
        this.usuarios.clear();
        this.usuarios.addAll(nuevosUsuarios);
        notifyDataSetChanged(); // Notifica al adapter que los datos han cambiado
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        holder.textViewNombre.setText(usuario.getNombre());
        holder.textViewApellido.setText(usuario.getApellido());
        holder.textViewEmail.setText(usuario.getEmail());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre;
        TextView textViewApellido;
        TextView textViewEmail;

        public UsuarioViewHolder(View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewApellido = itemView.findViewById(R.id.textViewApellido);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
        }
    }
}

