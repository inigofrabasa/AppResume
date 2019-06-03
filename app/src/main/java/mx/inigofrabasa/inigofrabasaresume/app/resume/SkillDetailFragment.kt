package mx.inigofrabasa.inigofrabasaresume.app.resume

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import mx.inigofrabasa.inigofrabasaresume.R
import mx.inigofrabasa.inigofrabasaresume.app.resume.utilities.InjectorUtils
import mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels.SkillDetailViewModel
import mx.inigofrabasa.inigofrabasaresume.databinding.FragmentSkillDetailBinding

class SkillDetailFragment : Fragment() {

    private val args: SkillDetailFragmentArgs by navArgs()
    private lateinit var shareText: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val factory = InjectorUtils.provideSkillDetailViewModelFactory(requireActivity(), args.skillId)
        val skillDetailViewModel = ViewModelProviders.of(this, factory)
            .get(SkillDetailViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentSkillDetailBinding>(
            inflater, R.layout.fragment_skill_detail, container, false).apply {
            viewModel = skillDetailViewModel
            setLifecycleOwner(this@SkillDetailFragment)
            fab.setOnClickListener { view ->
                skillDetailViewModel.addSkillToProfile()
                Snackbar.make(view, R.string.added_skill_to_profile, Snackbar.LENGTH_LONG).show()
            }
        }

        skillDetailViewModel.skill.observe(this, Observer { skill ->
            shareText = if (skill == null) {
                ""
            } else {
                getString(R.string.share_text_skill, skill.name)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_skill_detail, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @Suppress("DEPRECATION")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                val shareIntent = ShareCompat.IntentBuilder.from(activity)
                    .setText(shareText)
                    .setType("text/plain")
                    .createChooserIntent()
                    .apply {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
                        } else {
                            addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
                        }
                    }
                startActivity(shareIntent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}