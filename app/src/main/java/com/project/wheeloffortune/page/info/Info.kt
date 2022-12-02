package com.project.wheeloffortune.page.info

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.project.wheeloffortune.page.word.WordGenerator

/*Here's our data.kt with out variables, that is going to be used.*/

/*MutableStateOf will be used, which will convert the value
to the state that Jetpack Compose will handle. That's because Jetpack Compose
doesn't recompose our function with a new value because
it can't know that the state is changing.*/
@SuppressLint("MutableCollectionMutableState")
class Info {
    /*var of our WordGenerator.*/
    var wof: WordGenerator by mutableStateOf(WordGenerator())

    /*The wheel has been turned.*/
    var gameStarted: Boolean by mutableStateOf(value = false)
    /*Game is running.*/
    var gameIsPlaying: Boolean by mutableStateOf(value = true)
    /*Game winner..*/
    var gameWinner: Boolean by mutableStateOf(value = false)
    /*The click list of the button.*/
    var buttonPressed: SnapshotStateList<Boolean> by mutableStateOf(value = mutableStateListOf(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false))
    /*New button once the previous one is pressed.*/
    var newButtonWheel: String by mutableStateOf(value = "")
    /*The text of the button wheel.*/
    var buttonText: String by mutableStateOf(value = "")
    /*Here's the info-messages that will pop up.*/
    var popupMessage: String by mutableStateOf(value = "")
    /*Live left of the game*/
    var livesInTotal: Int by mutableStateOf(value = 5)
    /*Keyboard for the game.*/
    var keyBoard: String by mutableStateOf(value = "letter")
    /*Here's the random generated word.*/
    var generatedWord = wof.randomWord
    /*Choose a word..*/
    var chooseAWord: String by mutableStateOf(value = "")
    /*The hidden letters.*/
    var hiddenWord: String by mutableStateOf(wof.hiddenLetters(wordSentence = generatedWord))


}