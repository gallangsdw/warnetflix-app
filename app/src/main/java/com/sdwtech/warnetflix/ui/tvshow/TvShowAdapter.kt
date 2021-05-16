package com.sdwtech.warnetflix.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.data.source.local.entity.Entity
import com.sdwtech.warnetflix.databinding.ItemsMovieBinding
import com.sdwtech.warnetflix.ui.detail.DetailActivity

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvShows = ArrayList<Entity>()

    fun setTvShows(tvShows: List<Entity>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.TvShowViewHolder {
        val itemTvShowBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowAdapter.TvShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size

    class TvShowViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
        private val imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
        fun bind(tvShow: Entity) {
            with(binding) {
                tvTitle.text = tvShow.title
                tvDate.text = tvShow.showDate
                tvRating.text = tvShow.rating.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TVSHOW, tvShow.Id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                        .load(imageUrl + tvShow.imgPhoto)
                        .transform(RoundedCorners(12))
                        .into(imgPoster)
            }
        }
    }
}

