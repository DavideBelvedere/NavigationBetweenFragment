package com.example.davidebelvedere.navigationbetweenfragment.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.davidebelvedere.navigationbetweenfragment.R;
import com.example.davidebelvedere.navigationbetweenfragment.logic.SwitcherInterface;

/**
 * Created by davidebelvedere on 01/03/18.
 */

public class SecondFragment extends Fragment {
    private SwitcherInterface mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.second_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button forwardBtn = (Button) view.findViewById(R.id.forward_button2);
        Button backBtn = (Button) view.findViewById(R.id.back_button2);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.goBack();
            }
        });

        forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.goForward(2);
            }
        });


    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (SwitcherInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

}
