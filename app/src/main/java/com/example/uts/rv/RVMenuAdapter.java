package com.example.uts.rv;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts.entity.Menu;
import com.example.uts.databinding.RvMenuBinding;

import java.util.ArrayList;

public class RVMenuAdapter extends RecyclerView.Adapter<RVMenuAdapter.viewHolder>{
    ArrayList<Menu> listMenu;

    public RVMenuAdapter(ArrayList<Menu> listMenu){
        this.listMenu = listMenu;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        RvMenuBinding binding;

        public viewHolder(@NonNull RvMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public RVMenuAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RvMenuBinding binding = RvMenuBinding.inflate(layoutInflater, parent, false);
        return new RVMenuAdapter.viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RVMenuAdapter.viewHolder holder, int position) {
        Menu menu = listMenu.get(position);
        holder.binding.setMenu(menu);
        holder.binding.executePendingBindings();

        holder.binding.tvHarga.setText("Rp. " + holder.binding.tvHarga.getText() + ",-");
    }

    @Override
    public int getItemCount() {
        //  Disini kita memberitahu jumlah dari item pada recycler view kita.
        return listMenu.size();
    }
}
