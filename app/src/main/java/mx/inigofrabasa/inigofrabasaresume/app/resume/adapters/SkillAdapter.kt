package mx.inigofrabasa.inigofrabasaresume.app.resume.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mx.inigofrabasa.inigofrabasaresume.app.resume.SkillListFragmentDirections
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.Skill
import mx.inigofrabasa.inigofrabasaresume.databinding.ListItemSkillBinding

class SkillAdapter : ListAdapter<Skill, SkillAdapter.ViewHolder>(SkillDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skill = getItem(position)
        holder.apply {
            bind(createOnClickListener(skill.skillId), skill)
            itemView.tag = skill
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemSkillBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(skillId: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = SkillListFragmentDirections.actionSkillListFragmentToSkillDetailFragment(skillId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ListItemSkillBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Skill) {
            binding.apply {
                clickListener = listener
                skill = item
                executePendingBindings()
            }
        }
    }
}

private class SkillDiffCallback : DiffUtil.ItemCallback<Skill>() {

    override fun areItemsTheSame(oldItem: Skill, newItem: Skill): Boolean {
        return oldItem.skillId == newItem.skillId
    }

    override fun areContentsTheSame(oldItem: Skill, newItem: Skill): Boolean {
        return oldItem == newItem
    }
}