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
        if (question.category == "make-ingress") this.answer(question.category, question.messageId, "https://speedrunners-leesah-game.dev.intern.nav.no")
        if (question.category == "arithmetic") handleAritmetic(question)
        if (question.category == "NAV") handleNAV(question)
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

    private fun handleAritmetic(question: Question) {
        val n1 = Integer.parseInt(question.question.substring(0,2).toString())
        val n2 = Integer.parseInt(question.question.substring(5).toString())
        val operator = question.question[2]
        var resultado = 0
        when (operator) {
            '+' ->  resultado = n1 + n2
            '-' ->  resultado = n1 - n2
            '*' ->  resultado = n1 * n2
            '/' ->  resultado = n1 / n2
        }
        this.answer(question.category, question.messageId, resultado.toString())
    }

    private fun handleNAV(question: Question){
        if (question.question == "På hvilken nettside finner man informasjon om rekruttering til NAV IT?") answer(question.category, question.messageId, "https://www.detsombetyrnoe.no")
        if (question.question == "Hva heter applikasjonsplattformen til NAV?") answer(question.category, question.messageId, "NAIS")
    }
}