package mx.inigofrabasa.inigofrabasaresume.app.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import mx.inigofrabasa.inigofrabasaresume.app.resume.adapters.ProfileSelectingAdapter
import mx.inigofrabasa.inigofrabasaresume.app.resume.utilities.InjectorUtils
import mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels.ProfileSelectingListViewModel
import mx.inigofrabasa.inigofrabasaresume.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        val adapter = ProfileSelectingAdapter()
        binding.profileList.adapter = adapter
        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: ProfileSelectingAdapter, binding: FragmentProfileBinding) {
        val factory = InjectorUtils.provideProfileSelectingListViewModelFactory(requireContext())
        val viewModel = ViewModelProviders.of(this, factory)
            .get(ProfileSelectingListViewModel::class.java)

        viewModel.profileSelecting.observe(viewLifecycleOwner, Observer { skills ->
            binding.hasSkills = !skills.isNullOrEmpty()
        })

        viewModel.skillAndProfileSelectings.observe(viewLifecycleOwner, Observer { result ->
            if (!result.isNullOrEmpty())
                adapter.submitList(result)
        })
    }
}