package com.sdwtech.warnetflix.ui.favorite.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.databinding.ItemsMovieBinding

class FavTvShowAdapter: PagedListAdapter<TvShowEntity, FavTvShowAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavTvShowAdapter.ViewHolder {
        return ViewHolder(ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FavTvShowAdapter.ViewHolder, position: Int) {
        val tvShows = getItem(position)
        if (tvShows != null) {
            holder.bind(tvShows)
        }
    }

    inner class ViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShow.name
                tvDate.text = tvShow.firstAirDate
                tvRating.text = tvShow.voteAverage.toString()
                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(tvShow)
                }
                Glide.with(itemView.context)
                    .load(imageUrl + tvShow.posterPath)
                    .transform(RoundedCorners(12))
                    .into(imgPoster)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(tvShow: TvShowEntity)
    }
}