package com.sdwtech.warnetflix.favorite.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.databinding.ItemsMovieBinding

class FavMovieAdapter: RecyclerView.Adapter<FavMovieAdapter.ViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallBack

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
      this.onItemClickCallBack = onItemClickCallBack
    }

    private val listFavMovie = ArrayList<Movie>()

    fun setData(newListFavMovie: List<Movie>?) {
        if (newListFavMovie == null) return
        listFavMovie.clear()
        listFavMovie.addAll(newListFavMovie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movies = listFavMovie[position]
            holder.bind(movies)
    }

    inner class ViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
        fun bind(movie: Movie) {
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

    interface OnItemClickCallBack {
     fun onItemClicked(movie: Movie)
   }

    override fun getItemCount(): Int {
        return listFavMovie.size
    }
}