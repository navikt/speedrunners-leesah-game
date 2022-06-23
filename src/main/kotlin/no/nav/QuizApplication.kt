package no.nav

import no.nav.db.Database
import no.nav.quizrapid.*
import no.nav.rapid.Assessment
import no.nav.rapid.Config
import no.nav.rapid.Question
import java.util.*


/**
 * QuizApplication
 *
 * Her skal teamet bygge ut funksjonalitet for å løse oppgavene i leesah-game.
 */
class QuizApplication(private val teamName: String, database: Database? = null): QuizParticipant(teamName) {

    override fun handle(question: Question) {
        logger.log(question)
        if (question.category == "team-registration") handleRegisterTeam(question)
    }


    override fun handle(assessment: Assessment) {
        logger.log(assessment)
    }

    /**
     * Spørsmål handlers
     */

    private fun handleRegisterTeam(question: Question) {
       this.answer(question.category, question.messageId, "speedrunners-leesah-game")
    }

}