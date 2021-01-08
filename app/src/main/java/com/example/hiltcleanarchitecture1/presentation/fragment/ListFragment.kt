package com.example.hiltcleanarchitecture1.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltcleanarchitecture1.R
import com.example.hiltcleanarchitecture1.databinding.ListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class ListFragment : Fragment(), CharactersAdapter.CharacterItemListener  {

    companion object {
        fun newInstance() = ListFragment()
    }

//    private lateinit var viewModel: ListViewModel
    private val viewModel: ListViewModel by viewModels()

    lateinit var binding: ListFragmentBinding
    private lateinit var adapter: CharactersAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

//        return inflater.inflate(R.layout.list_fragment, container, false)
        binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = CharactersAdapter(this)
        binding.charactersRv.layoutManager = LinearLayoutManager(requireContext())
        binding.charactersRv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.listenNotesResult().observe(this.viewLifecycleOwner, Observer {
            it?.let {
                adapter.setItems(ArrayList(it))
            }
        })
    }

    override fun onClickedCharacter(characterId: Int) {

    }

}