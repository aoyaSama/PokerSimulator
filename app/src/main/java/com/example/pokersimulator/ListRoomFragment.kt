package com.example.pokersimulator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokersimulator.common.MyUserRecyclerViewAdapter
import com.example.pokersimulator.databinding.ListRoomFragmentBinding
import com.example.pokersimulator.databinding.RoomFragmentBinding

/**
 * A fragment that shows a list of nearby hosts to the user when he selects join existing room
 * on the index page.
 */
class ListRoomFragment : Fragment() {

    private var _binding: ListRoomFragmentBinding? = null
    private val activityViewModel: MainActivityViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListRoomFragmentBinding.inflate(inflater, container, false)
        binding.textViewListRoomHeader.text = getString(R.string.welcome_username, activityViewModel.username)
        with(binding.listOfHosts) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyUserRecyclerViewAdapter()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO define navigation to the room fragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}