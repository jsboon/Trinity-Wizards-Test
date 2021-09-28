package com.example.trinitywizardstest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Contact_Adapter extends RecyclerView.Adapter<Contact_Adapter.ViewHolder> {

    Context context;
    ArrayList<Contact_Model> contactsModalArrayList;

    public Contact_Adapter(Context context, ArrayList<Contact_Model> contactsModalArrayList) {
        this.context = context;
        this.contactsModalArrayList = contactsModalArrayList;
    }

    @NonNull
    @Override
    public Contact_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Contact_Adapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Contact_Adapter.ViewHolder holder, int position) {
        Contact_Model modal = contactsModalArrayList.get(position);
        holder.name.setText(modal.getFirst_name());
        holder.image.setImageResource(R.drawable.circle);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, information.class);
                i.putExtra("first_name", modal.getFirst_name());
                i.putExtra("last_name", modal.getLast_name());
                i.putExtra("email", modal.getEmail());
                i.putExtra("phone_num", modal.getPhone_num());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.contact_pic);
            name = itemView.findViewById(R.id.contact_name);
        }
    }
}
