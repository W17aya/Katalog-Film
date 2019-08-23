package com.example.katalogfilm;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.katalogfilm.Model.Film;
import java.util.ArrayList;

import static com.example.katalogfilm.DetailActivity.KEY_EXTRA;
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<Film>listMovie;

    public MovieAdapter(ArrayList<Film>list) {
        this.listMovie = list;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        final Film film = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(film.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvMovie.setText(film.getTitle());
        holder.tvYear.setText(film.getReleased());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                film.setPhoto(listMovie.get(holder.getAdapterPosition()).getPhoto());
                film.setTitle(listMovie.get(holder.getAdapterPosition()).getTitle());
                film.setReleased(listMovie.get(holder.getAdapterPosition()).getReleased());
                film.setSpoiler(listMovie.get(holder.getAdapterPosition()).getSpoiler());
                film.setGenre(listMovie.get(holder.getAdapterPosition()).getGenre());
                intent.putExtra(KEY_EXTRA,film);
                holder.itemView.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvMovie, tvYear;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.item_photo);
            tvMovie = itemView.findViewById(R.id.titlemovie);
            tvYear = itemView.findViewById(R.id.year_movie);

        }
    }
}
