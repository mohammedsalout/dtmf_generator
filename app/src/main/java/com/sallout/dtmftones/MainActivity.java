package com.sallout.dtmftones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.sallout.dtmf_generator.GenerateDTMF;
import com.sallout.dtmftones.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = binding.txtText.getText()+"";
                GenerateDTMF rubDTMF = new GenerateDTMF(MainActivity.this ,number , 500 , 350,500 ,1000);
                rubDTMF.start();
            }
        });



    }
}