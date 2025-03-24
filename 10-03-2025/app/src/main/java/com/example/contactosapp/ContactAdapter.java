package com.example.contactosapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txvName;
        TextView txvPhone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txvName = itemView.findViewById(R.id.txvName);
            this.txvPhone = itemView.findViewById(R.id.txvPhone);
        }

        public void setName(TextView txvName){
            this.txvName = txvName;
        }

        public void getPhone(TextView txvPhone){
            this.txvPhone = txvPhone;
        }
    }
    List<Contact> listContacts;

    public ContactAdapter(List<Contact> listContacts){
        this.listContacts = listContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.id.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.listContacts.size();
    }
}
