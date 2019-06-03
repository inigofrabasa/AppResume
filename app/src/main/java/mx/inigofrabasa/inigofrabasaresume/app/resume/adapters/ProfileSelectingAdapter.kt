package mx.inigofrabasa.inigofrabasaresume.app.resume.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mx.inigofrabasa.inigofrabasaresume.R
import mx.inigofrabasa.inigofrabasaresume.app.resume.ProfileFragmentDirections
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.SkillAndProfileSelectings
import mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels.SkillAndProfileSelectingsViewModel
import mx.inigofrabasa.inigofrabasaresume.databinding.ListItemProfileSelectingBinding

class ProfileSelectingAdapter :
    ListAdapter<SkillAndProfileSelectings, ProfileSelectingAdapter.ViewHolder>(ProfileSelectDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_profile_selecting, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { selectings ->
            with(holder) {
                itemView.tag = selectings
                bind(createOnClickListener(selectings.skill.skillId), selectings)
            }
        }
    }

    private fun createOnClickListener(skillId: String): View.OnClickListener {
        return View.OnClickListener {
            val direction =
                ProfileFragmentDirections.actionProfileFragmentToSkillDetailFragment(skillId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ListItemProfileSelectingBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, selectings: SkillAndProfileSelectings) {
            with(binding) {
                clickListener = listener
                viewModel = SkillAndProfileSelectingsViewModel(selectings)
                executePendingBindings()
            }
        }
    }
}

private class ProfileSelectDiffCallback : DiffUtil.ItemCallback<SkillAndProfileSelectings>() {

    override fun areItemsTheSame(
        oldItem: SkillAndProfileSelectings,
        newItem: SkillAndProfileSelectings
    ): Boolean {
        return oldItem.skill.skillId == newItem.skill.skillId
    }

    override fun areContentsTheSame(
        oldItem: SkillAndProfileSelectings,
        newItem: SkillAndProfileSelectings
    ): Boolean {
        return oldItem.skill == newItem.skill
    }
}