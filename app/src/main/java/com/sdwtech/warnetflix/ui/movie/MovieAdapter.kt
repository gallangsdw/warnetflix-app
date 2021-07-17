package com.sdwtech.warnetflix.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.databinding.ItemsMovieBinding

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallback

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallback) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    private val listMovie = ArrayList<Movie>()

    fun setData(newListMovie: List<Movie>?) {
        if (newListMovie == null) return
        listMovie.clear()
        listMovie.addAll(newListMovie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
            holder.bind(movie)
    }

    inner class MovieViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
        private val imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
        fun bind(movie: Movie){
            with(binding) {
                tvTitle.text = movie.title
                tvDate.text = movie.releaseDate
                tvRating.text = movie.voteAverage.toString()
                itemView.setOnClickListener {
                    onItemClickCallBack.onItemClicked(movie)
                }
                Glide.with(itemView.context)
                        .load(imageUrl + movie.posterPath)
                        .transform(RoundedCorners(12))
                        .into(imgPoster)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(movie: Movie)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }
}