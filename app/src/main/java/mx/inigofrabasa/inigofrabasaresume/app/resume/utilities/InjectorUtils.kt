package mx.inigofrabasa.inigofrabasaresume.app.resume.utilities

import android.content.Context
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.AppDatabase
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.ProfileSelectingRepository
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.SkillRepository
import mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels.ProfileSelectingListViewModelFactory
import mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels.SkillDetailViewModelFactory
import mx.inigofrabasa.inigofrabasaresume.app.resume.viewmodels.SkillListViewModelFactory

object InjectorUtils {

    private fun getSkillRepository(context: Context): SkillRepository {
        return SkillRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).skillDao())
    }

    private fun getProfileSelectingRepository(context: Context): ProfileSelectingRepository {
        return ProfileSelectingRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).profileSelectingDao())
    }

    fun provideProfileSelectingListViewModelFactory(
        context: Context
    ): ProfileSelectingListViewModelFactory {
        val repository = getProfileSelectingRepository(context)
        return ProfileSelectingListViewModelFactory(repository)
    }

    fun provideSkillListViewModelFactory(context: Context): SkillListViewModelFactory {
        val repository = getSkillRepository(context)
        return SkillListViewModelFactory(repository)
    }

    fun provideSkillDetailViewModelFactory(
        context: Context,
        skillId: String
    ): SkillDetailViewModelFactory {
        return SkillDetailViewModelFactory(getSkillRepository(context),
            getProfileSelectingRepository(context), skillId)
    }
}