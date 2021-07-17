package com.sdwtech.warnetflix.favorite.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.core.domain.model.TvShow
import com.sdwtech.warnetflix.databinding.ItemsMovieBinding

class FavTvShowAdapter: RecyclerView.Adapter<FavTvShowAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val listFavTvShow = ArrayList<TvShow>()

    fun setData(newListFavTvShow: List<TvShow>?) {
        if (newListFavTvShow == null) return
        listFavTvShow.clear()
        listFavTvShow.addAll(newListFavTvShow)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvShows = listFavTvShow[position]
            holder.bind(tvShows)
    }

    inner class ViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
        fun bind(tvShow: TvShow) {
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
        fun onItemClicked(tvShow: TvShow)
    }

    override fun getItemCount(): Int {
        return listFavTvShow.size
    }
}