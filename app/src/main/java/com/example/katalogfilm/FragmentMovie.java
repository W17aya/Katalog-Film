package com.example.katalogfilm;


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


import com.example.katalogfilm.Model.Film;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMovie extends Fragment {
    private RecyclerView rvMovie;
    private ArrayList<Film> list = new ArrayList<>();
    private String[] title, released, desc, genre;
    private TypedArray cover;
    private MovieAdapter adapter;




    public FragmentMovie() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);


        prepare();
        showRecyclerListMovie();
    }

    private void prepare() {
        cover = getResources().obtainTypedArray(R.array.data_foto);
        title = getResources().getStringArray(R.array.data_titlemovie);
        released = getResources().getStringArray(R.array.data_released);
        desc = getResources().getStringArray(R.array.data_spoiler);
        genre = getResources().getStringArray(R.array.data_genre);
        list.addAll(getListData());
    }

    public ArrayList<Film>getListData(){
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
          Film film = new Film();
          film.setPhoto(cover.getResourceId(i,-1));
          film.setTitle(title[i]);
          film.setReleased(released[i]);
          film.setSpoiler(desc[i]);
          film.setGenre(genre[i]);
          list.add(film);
      }
       return list;

    }

    private void showRecyclerListMovie() {
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter movieAdapter = new MovieAdapter(list);
        rvMovie.setAdapter(movieAdapter);

    }
}

