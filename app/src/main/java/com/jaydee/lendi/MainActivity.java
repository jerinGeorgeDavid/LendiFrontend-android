package com.jaydee.lendi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaydee.lendi.fragments.AddOrUpdateFragment;
import com.jaydee.lendi.fragments.ToGiveFragment;
import com.jaydee.lendi.fragments.TogetFragment;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.frameLayout);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        replaceFragment(new AddOrUpdateFragment());
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.toGetHome:
                    replaceFragment(new TogetFragment());

                    break;

                case R.id.toAddOrUpdateHome:replaceFragment(new AddOrUpdateFragment());
                    break;

                case R.id.toGiveHome:replaceFragment(new ToGiveFragment());
                    break;

            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}