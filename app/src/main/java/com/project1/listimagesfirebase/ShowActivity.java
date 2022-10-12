package com.project1.listimagesfirebase;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project1.listimagesfirebase.databinding.ActivityShowBinding;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {
    ActivityShowBinding binding;
    private ArrayList<Model> mlist;
    private MyAdapter myAdapter;
    private DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Images");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mlist = new ArrayList<>();
        myAdapter=new MyAdapter(this,mlist);
        binding.recyclerview.setAdapter(myAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                Model model=dataSnapshot.getValue(Model.class);
                mlist.add(model);
            }
            myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ShowActivity.this, "Errorr", Toast.LENGTH_SHORT).show();

            }
        });
    }
}