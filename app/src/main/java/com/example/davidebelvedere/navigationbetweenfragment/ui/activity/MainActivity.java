package com.example.davidebelvedere.navigationbetweenfragment.ui.activity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.davidebelvedere.navigationbetweenfragment.R;
import com.example.davidebelvedere.navigationbetweenfragment.logic.SwitcherInterface;
import com.example.davidebelvedere.navigationbetweenfragment.ui.fragment.FirstFragment;
import com.example.davidebelvedere.navigationbetweenfragment.ui.fragment.SecondFragment;
import com.example.davidebelvedere.navigationbetweenfragment.ui.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity implements SwitcherInterface {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        FirstFragment firstFragment = new FirstFragment();


        fragmentTransaction.add(R.id.fragmentContainer, firstFragment, "First Fragment");
        fragmentTransaction.addToBackStack("First Fragment");
        fragmentTransaction.commit();
    }

    @Override
    public void goBack() {

            getFragmentManager().popBackStack();

    }

    @Override
    public void goForward(int numFrag) {
        FragmentManager manager=getFragmentManager();
        switch (numFrag){
            case 1:
                SecondFragment secondFragment = new SecondFragment();
                manager.beginTransaction().
                        replace(R.id.fragmentContainer, secondFragment, "Second Fragment")
                        .addToBackStack("Second Fragment")
                        .commit();
                break;
            case 2:
                ThirdFragment thirdFragment=new ThirdFragment();
                manager.beginTransaction().
                        replace(R.id.fragmentContainer, thirdFragment, "Third Fragment")
                        .addToBackStack("Third Fragment")
                        .commit();
                break;
            case 3:

                manager.popBackStack("First Fragment",0);
                break;
        }

    }
}
