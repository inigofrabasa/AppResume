package mx.inigofrabasa.inigofrabasaresume.app.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import mx.inigofrabasa.inigofrabasaresume.R
import mx.inigofrabasa.inigofrabasaresume.app.resume.adapters.SkillAdapter
import mx.inigofrabasa.inigofrabasaresume.app.resume.utilities.InjectorUtils
import mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels.SkillListViewModel
import mx.inigofrabasa.inigofrabasaresume.databinding.FragmentSkillListBinding

class SkillListFragment : Fragment() {

    private lateinit var viewModel: SkillListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSkillListBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root

        val factory = InjectorUtils.provideSkillListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(SkillListViewModel::class.java)

        val adapter = SkillAdapter()
        binding.skillList.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_skill_list, menu)
    }

    private fun subscribeUi(adapter: SkillAdapter) {
        viewModel.skills.observe(viewLifecycleOwner, Observer { skills ->
            if (skills != null) adapter.submitList(skills)
        })
    }
}