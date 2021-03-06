package com.sdwtech.warnetflix.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.core.domain.model.TvShow
import com.sdwtech.warnetflix.databinding.ItemsMovieBinding

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val listTvShow = ArrayList<TvShow>()

    fun setData(newListTvShow: List<TvShow>?) {
        if (newListTvShow == null) return
        listTvShow.clear()
        listTvShow.addAll(newListTvShow)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemTvShowBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
            holder.bind(tvShow)
    }


    inner class TvShowViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
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
        return listTvShow.size
    }
}

