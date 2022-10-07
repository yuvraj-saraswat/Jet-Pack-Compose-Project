package com.example.affirmations.data
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.death_note, R.string.description1, R.string.synopsis1),
            Affirmation(R.string.affirmation2, R.drawable.attack_on_titan, R.string.description2, R.string.synopsis2),
            Affirmation(R.string.affirmation3, R.drawable.full, R.string.description3, R.string.synopsis3),
            Affirmation(R.string.affirmation4, R.drawable.psycho, R.string.description4, R.string.synopsis4),
            Affirmation(R.string.affirmation5, R.drawable.violet, R.string.description5, R.string.synopsis5),
            Affirmation(R.string.affirmation6, R.drawable.jujutsu, R.string.description6, R.string.synopsis6),
            Affirmation(R.string.affirmation7, R.drawable.demon, R.string.description7, R.string.synopsis7),
            Affirmation(R.string.affirmation8, R.drawable.haik, R.string.description8, R.string.synopsis8),
            Affirmation(R.string.affirmation9, R.drawable.vinland, R.string.description9, R.string.synopsis9),
            Affirmation(R.string.affirmation10, R.drawable.run, R.string.description10, R.string.synopsis10),
            Affirmation(R.string.affirmation11, R.drawable.black, R.string.description11, R.string.synopsis11),
            Affirmation(R.string.affirmation12, R.drawable.hero, R.string.description12, R.string.synopsis12),
            Affirmation(R.string.affirmation13, R.drawable.your, R.string.description13, R.string.synopsis13),
            Affirmation(R.string.affirmation14, R.drawable.tokyo, R.string.description14, R.string.synopsis14),
            Affirmation(R.string.affirmation15, R.drawable.naruto, R.string.description15, R.string.synopsis15),



            )
    }
}