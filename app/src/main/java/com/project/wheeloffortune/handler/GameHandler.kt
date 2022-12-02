package com.project.wheeloffortune.handler

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.wheeloffortune.page.info.Info

class GameHandler: ViewModel() {
    var info: Info by mutableStateOf(value = Info())
    fun refresh(){
        Info().also { info = it }
    }

    private fun status(){
        when (info.livesInTotal) {
            0 -> {
                info.gameIsPlaying = false
                info.gameWinner = false
            }
        }
    }

    fun chooseAWord(): Any {
        return when {
            info.chooseAWord != "" -> when {
                info.chooseAWord.lowercase() == info.generatedWord.lowercase() -> {
                    info.gameWinner = true
                    info.gameIsPlaying = false
                }
                else -> {
                    buildString {
                        append("You got it wrong, and lost one live!")
                        info.livesInTotal--
                    }.also { info.popupMessage = it }
                    "".also { info.chooseAWord = it }
                    status()
                }
            }
            else -> "You have to insert something first!".also { info.popupMessage = it }
        }
    }


    fun refreshKeyboard(keyboard: String){
        info.keyBoard = keyboard
    }

    private fun chooseLetterConsonant(letter:String){
        var x = 0
        val lettersAmount = info.hiddenWord.toCharArray()
        info.generatedWord.withIndex().forEach { (index, letters) ->
            when {
                letter.lowercase() == letters.toString().lowercase() -> {
                    lettersAmount[index] = letters
                    x++
                    info.popupMessage = "Great you've got it right!"
                }
            }
        }
        info.livesInTotal--
        info.popupMessage = "Ah, you got it wrong!"
        info.hiddenWord = String(lettersAmount)
        status()
    }

    fun yourTurn(letter: String) = if (!getLetterPressed(letter)) {
        if (!info.gameStarted) {
            "You've to 'Spin' first!".also { info.popupMessage = it }
        } else {
            chooseLetterConsonant(letter)
            setLetterPressed(letter)
            info.gameStarted = false
            info.popupMessage = "You've choosen a letter."
        }
    } else {
        "You've to 'Spin' first!".also { info.popupMessage = it }
    }

    private fun setLetterPressed(letter: String){
        when (letter) {
            "A" -> true.also { info.buttonPressed[0] = it }
            "B" -> true.also { info.buttonPressed[1] = it }
            "C" -> true.also { info.buttonPressed[2] = it }
            "D" -> true.also { info.buttonPressed[3] = it }
            "E" -> true.also { info.buttonPressed[4] = it }
            "F" -> true.also { info.buttonPressed[5] = it }
            "G" -> true.also { info.buttonPressed[6] = it }
            "H" -> true.also { info.buttonPressed[7] = it }
            "I" -> true.also { info.buttonPressed[8] = it }
            "J" -> true.also { info.buttonPressed[9] = it }
            "K" -> true.also { info.buttonPressed[10] = it }
            "L" -> true.also { info.buttonPressed[11] = it }
            "M" -> true.also { info.buttonPressed[12] = it }
            "N" -> true.also { info.buttonPressed[13] = it }
            "O" -> true.also { info.buttonPressed[14] = it }
            "P" -> true.also { info.buttonPressed[15] = it }
            "Q" -> true.also { info.buttonPressed[16] = it }
            "R" -> true.also { info.buttonPressed[17] = it }
            "S" -> true.also { info.buttonPressed[18] = it }
            "T" -> true.also { info.buttonPressed[19] = it }
            "U" -> true.also { info.buttonPressed[20] = it }
            "V" -> true.also { info.buttonPressed[21] = it }
            "W" -> true.also { info.buttonPressed[22] = it }
            "X" -> true.also { info.buttonPressed[23] = it }
            "Y" -> true.also { info.buttonPressed[24] = it }
            "Z" -> true.also { info.buttonPressed[25] = it }
            "Æ" -> true.also { info.buttonPressed[26] = it }
            "Ø" -> true.also { info.buttonPressed[27] = it }
            "Å" -> true.also { info.buttonPressed[28] = it }
        }
    }
    fun getLetterPressed(letter: String): Boolean {
        when (letter) {
            "A" -> return info.buttonPressed[0]
            "B" -> return info.buttonPressed[1]
            "C" -> return info.buttonPressed[2]
            "D" -> return info.buttonPressed[3]
            "E" -> return info.buttonPressed[4]
            "F" -> return info.buttonPressed[5]
            "G" -> return info.buttonPressed[6]
            "H" -> return info.buttonPressed[7]
            "I" -> return info.buttonPressed[8]
            "J" -> return info.buttonPressed[9]
            "K" -> return info.buttonPressed[10]
            "L" -> return info.buttonPressed[11]
            "M" -> return info.buttonPressed[12]
            "N" -> return info.buttonPressed[13]
            "O" -> return info.buttonPressed[14]
            "P" -> return info.buttonPressed[15]
            "Q" -> return info.buttonPressed[16]
            "R" -> return info.buttonPressed[17]
            "S" -> return info.buttonPressed[18]
            "T" -> return info.buttonPressed[19]
            "U" -> return info.buttonPressed[20]
            "V" -> return info.buttonPressed[21]
            "W" -> return info.buttonPressed[22]
            "X" -> return info.buttonPressed[23]
            "Y" -> return info.buttonPressed[24]
            "Z" -> return info.buttonPressed[25]
            "Æ" -> return info.buttonPressed[26]
            "Ø" -> return info.buttonPressed[27]
            "Å" -> return info.buttonPressed[28]
            else ->
                return false
        }
    }

    fun pressButtonDesign() = if (!info.gameStarted) {
        info.gameStarted = true
        info.popupMessage = "Pick a consontant."

    }else{
        "Choose one of the consonants!".also { info.popupMessage = it }
    }
}
