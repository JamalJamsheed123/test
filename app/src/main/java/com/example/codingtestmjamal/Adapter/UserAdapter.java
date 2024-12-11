package com.example.codingtestmjamal.Adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codingtestmjamal.Model.Users;
import com.example.codingtestmjamal.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private final List<Users> userList;
    private final Context context;

    public UserAdapter(List<Users> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = LayoutInflater.from(context).inflate(R.layout.item_users, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        // Bind data to the view holder
        Users user = userList.get(position);
        holder.useridTextView.setText("" + user.getId());
        holder.firstNameTextView.setText(user.getFirstName());
        holder.lastNameTextView.setText(user.getLastName());
        holder.emailIdTextView.setText(user.getEmailId());
        holder.passwordTextView.setText(user.getPassword());
        holder.roleidTextView.setText("" + user.getRoleid());
        holder.isActiveTextView.setText(user.getActive().toString());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    // ViewHolder class
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView useridTextView, firstNameTextView, lastNameTextView, emailIdTextView, passwordTextView, roleidTextView,isActiveTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            useridTextView = itemView.findViewById(R.id.id);
            firstNameTextView = itemView.findViewById(R.id.firstName);

            lastNameTextView = itemView.findViewById(R.id.lastName);
            emailIdTextView = itemView.findViewById(R.id.emailId);

            passwordTextView = itemView.findViewById(R.id.password);
            roleidTextView = itemView.findViewById(R.id.roleid);
            isActiveTextView = itemView.findViewById(R.id.isActive);
        }
    }
}
