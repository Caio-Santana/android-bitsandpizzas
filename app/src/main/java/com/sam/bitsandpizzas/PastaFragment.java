package com.sam.bitsandpizzas;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PastaFragment extends Fragment {

    public PastaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] pastaNames = new String[Pasta.pastas.length];
        int[] pastaImages = new int[Pasta.pastas.length];

        for (int i = 0; i < Pasta.pastas.length; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames, pastaImages);

        RecyclerView pastaRecycler = (RecyclerView) inflater
                .inflate(R.layout.fragment_pasta, container,false);

        pastaRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        pastaRecycler.setLayoutManager(layoutManager);

        return pastaRecycler;
    }
}