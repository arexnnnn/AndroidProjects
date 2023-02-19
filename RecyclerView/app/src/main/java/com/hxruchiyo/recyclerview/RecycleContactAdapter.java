package com.hxruchiyo.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleContactAdapter extends RecyclerView.Adapter<RecycleContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrContacts;

    private int lastPosition = -1;

    RecycleContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.context=context;
        this.arrContacts=arrContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                TextView txtTitle = dialog.findViewById(R.id.txtTitle);

                txtTitle.setText("Update Contact");

                btnAction.setText("Update");

                edtName.setText(arrContacts.get(position).name);
                edtNumber.setText(arrContacts.get(position).number);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = "", number = "";

                        if (!edtName.getText().toString().equals("")){
                            name = edtName.getText().toString();
                        } else {
                            Toast.makeText(context, "Please enter contact name", Toast.LENGTH_SHORT).show();
                        }

                        if (!edtNumber.getText().toString().equals("")){
                            number = edtNumber.getText().toString();
                        } else {
                            Toast.makeText(context, "Please enter contact number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.set(position, new ContactModel(name, number));

                        notifyItemChanged(position);

                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to delete")
                        .setIcon(R.drawable.ic_launcher_background)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrContacts.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.show();

                return true;

            }
        });

        // lecture 3 stuff

        setAnimation(holder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtNumber;
        ImageView imgContact;
        LinearLayout llRow;

        public ViewHolder(View v){

            super(v);

            txtName = v.findViewById(R.id.txtName);
            txtNumber = v.findViewById(R.id.txtNumber);
            imgContact = v.findViewById(R.id.imgContact);
            llRow = v.findViewById(R.id.llRow);
        }
    }

    private void setAnimation(View viewToAnimate, int position){

        if (position > lastPosition){

            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(slideIn);
            lastPosition = position;

        }

    }

}
