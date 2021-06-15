package com.sdwtech.warnetflix.ui.favorite.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.databinding.ItemsMovieBinding

class FavMovieAdapter: PagedListAdapter<MovieEntity, FavMovieAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    private lateinit var onItemClickCallBack: OnItemClickCallBack

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
      this.onItemClickCallBack = onItemClickCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMovieAdapter.ViewHolder {
        return ViewHolder(ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FavMovieAdapter.ViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }

    inner class ViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
        fun bind(movie: MovieEntity) {
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
     fun onItemClicked(movieEntity: MovieEntity)
   }
}