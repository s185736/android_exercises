//source: https://developer.android.com/codelabs/basic-android-kotlin-training-lists#0
package com.project.wheeloffortune.page.word

import kotlin.random.Random

class WordGenerator {

    private val availableWords: List<String> = listOf("Android Studio", "IntelliJ Ultimate", "Machine Code", "Compiler Construction", "Innovation Pilot")

    val randWordGenerating: String
        get() {
            val selectedWord: List<String> = availableWords
            println("Word is generated.")
            val randIn: Int = Random.nextInt(selectedWord.size)
            return selectedWord[randIn]
        }

    fun hiddenLetters(wordSentence: String): String {
        var letters = buildString { }
        wordSentence.run {
            forEach(
                action = fun(char: Char) {
                    letters += when (char) {
                        ' ' -> " "
                        else -> {
                            "?"
                        }
                    }
                },
            )
        }
        return letters
    }
}