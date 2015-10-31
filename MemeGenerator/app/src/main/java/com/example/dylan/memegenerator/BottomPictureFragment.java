package com.example.dylan.memegenerator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Dylan on 9/20/2015.
 */
public class BottomPictureFragment extends Fragment {

    private static TextView topMemeText;
    private static TextView bottomMemeText;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //says this is the viewer for this fragment
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);
        topMemeText = (TextView) view.findViewById(R.id.topMemeText);
        bottomMemeText = (TextView) view.findViewById(R.id.bottomMemeText);
        return view;
    }

    public void setTopMemeText(String top, String bottom) {
        //change text of both of these boxes
        topMemeText.setText(top);
        bottomMemeText.setText(bottom);
    }
}
