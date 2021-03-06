package com.sdwtech.warnetflix.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdwtech.warnetflix.R
import com.sdwtech.warnetflix.core.data.Resource
import com.sdwtech.warnetflix.core.domain.model.TvShow
import com.sdwtech.warnetflix.databinding.FragmentTvShowBinding
import com.sdwtech.warnetflix.ui.detail.DetailActivity
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.TV_SHOW
import org.koin.android.viewmodel.ext.android.viewModel


class TvShowFragment : Fragment(), TvShowAdapter.OnItemClickCallback {

    private val viewModel: TvShowViewModel by viewModel()
    private val binding: FragmentTvShowBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val tvShowAdapter = TvShowAdapter()

            viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
                if (tvShows != null) {
                    when (tvShows) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            tvShowAdapter.setOnItemClickCallback(this)
                            tvShowAdapter.setData(tvShows.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context,"Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(binding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onItemClicked(tvShow: TvShow) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, tvShow.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, TV_SHOW)

        context?.startActivity(intent)
    }
}