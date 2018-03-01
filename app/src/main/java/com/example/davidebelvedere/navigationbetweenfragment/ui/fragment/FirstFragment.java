package com.example.davidebelvedere.navigationbetweenfragment.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.davidebelvedere.navigationbetweenfragment.R;
import com.example.davidebelvedere.navigationbetweenfragment.logic.SwitcherInterface;

/**
 * Created by davidebelvedere on 01/03/18.
 */

public class FirstFragment extends Fragment {
    private SwitcherInterface mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.first_layout, container, false);
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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button forwardBtn = (Button) view.findViewById(R.id.forward_button1);

        forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.goForward(1);
            }
        });


    }
}
