package com.sam.bitsandpizzas;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PizzaFragment extends Fragment {

    public PizzaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView pizzaRecycler = (RecyclerView) inflater
                .inflate(R.layout.fragment_pizza, container, false);

        String[] pizzaNames = new String[Pizza.pizzas.length];
        int[] pizzaImages = new int[Pizza.pizzas.length];

        for (int i = 0; i < Pizza.pizzas.length; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        pizzaRecycler.setLayoutManager(layoutManager);

        return pizzaRecycler;
    }
}