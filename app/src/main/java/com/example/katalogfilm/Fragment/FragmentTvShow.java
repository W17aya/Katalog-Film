package com.example.katalogfilm.Fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.katalogfilm.MovieAdapter;
import com.example.katalogfilm.Model.Film;
import com.example.katalogfilm.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTvShow extends Fragment {
private RecyclerView rvTV;
private ArrayList<Film> list = new ArrayList<>();
private String [] title, released, desc, genre;
private TypedArray cover;
private MovieAdapter adapter;

    public FragmentTvShow() {
        // Requi red empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTV = view.findViewById(R.id.rv_tv);
        rvTV.setHasFixedSize(true);

        ready();
        showRecyclerListTv();


    }

    private void showRecyclerListTv() {
        rvTV.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter tvShowAdapter = new MovieAdapter(list);
        rvTV.setAdapter(tvShowAdapter);
    }

    private void ready() {
        cover = getResources().obtainTypedArray(R.array.data_fototv);
        title = getResources().getStringArray(R.array.data_titletv);
        released = getResources().getStringArray(R.array.data_released);
        desc = getResources().getStringArray(R.array.data_spoilertv);
        genre = getResources().getStringArray(R.array.data_genretv);
        list.addAll(getListData());
    }
    public ArrayList<Film>getListData(){
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++){
            Film film = new Film();
            film.setPhoto(cover.getResourceId(i,-1));
            film.setTitle(title[i]);
            film.setSpoiler(desc[i]);
            film.setGenre(genre[i]);
            film.setReleased(released[i]);
            list.add(film);
        }
        return list;
    }
}
