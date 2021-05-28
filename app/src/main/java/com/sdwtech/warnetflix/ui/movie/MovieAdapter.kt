package com.sdwtech.warnetflix.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.data.source.remote.response.MovieResponse
import com.sdwtech.warnetflix.databinding.ItemsMovieBinding
import com.sdwtech.warnetflix.ui.detail.DetailActivity

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<MovieResponse>()

    fun setMovies(movies: List<MovieResponse>) {
        listMovies.clear()
        listMovies.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    class MovieViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
        private val imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
        fun bind(movie: MovieResponse){
            with(binding) {
                tvTitle.text = movie.title
                tvDate.text = movie.releaseDate
                tvRating.text = movie.voteAverage.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE,movie.id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(imageUrl + movie.posterPath)
                        .transform(RoundedCorners(12))
                        .into(imgPoster)
            }
        }
    }
}