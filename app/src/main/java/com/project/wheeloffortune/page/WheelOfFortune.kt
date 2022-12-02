package com.project.wheeloffortune.page

import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import com.project.wheeloffortune.page.info.*
import com.project.wheeloffortune.handler.GameHandler

var letters: Letters by mutableStateOf(Letters())
var info: Info by mutableStateOf(value = Info())

/*WheelOfFortune.kt - Includes the layout and design..*/
@Composable
fun WheelOfFortune(handler: GameHandler) {
    Layout {
        ->
        ChooseLetters(handler.info.hiddenWord)
        LiveLeftShown(livesLeft = handler.info.livesInTotal)
        when {
            handler.info.gameIsPlaying -> {
                MessageWarning(handler)
                ButtonGame(handler)
                GiveAWord(handler)
            }
            else -> MessageTypes(handler)
        }
    }
}

@Composable
fun ButtonGame(handler: GameHandler) {
    Text(text = handler.info.buttonText)
    Box {
        Button(
            onClick = fun() {
                "You've spinned!".also { info.popupMessage = it }
                handler.pressButtonDesign()
            },
        )
        {
            Text(
                text = buildString { append("Spin") }
            )
        }
    }
}

@Composable
fun LiveLeftShown(livesLeft:Int) = Row(modifier = Modifier
    .fillMaxHeight(0.05f)
    .fillMaxWidth(5f)) {
    LivesLeft(livesLeft = livesLeft)
}

@Composable
fun MessageWarning(handler: GameHandler) = Row(modifier = Modifier.fillMaxHeight(0.1f)){
    Text(text = handler.info.popupMessage, color = Color.Black )
}

@ExperimentalMaterialApi
@Composable
fun PickLetter(letter:String, handler: GameHandler, modifier:Modifier = Modifier) {
    var abc by remember { mutableStateOf(5f) }
    if (handler.getLetterPressed(letter)) {
        abc = 0f
    }
    Box {
        Card(
            modifier = modifier.alpha(abc),
            onClick = {
                handler.yourTurn(letter)
            }) {
            Text(
                text = letter,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Layout(content: @Composable () -> Unit) {
    Box() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            content()
        }
    }
}
@Composable
fun ChooseLetters(word:String, modifier:Modifier = Modifier) = Row(modifier = modifier
    .fillMaxHeight(0.06f)
    .border(0.01.dp, Color.White)){
    Text(
        text = word,
        fontSize = 30.sp,
    )
}

@Composable
fun GiveAWord(handler: GameHandler) = Row(modifier = Modifier
    .fillMaxHeight(1f)) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(0.1f)) {
        Button(onClick = {
            handler.refreshKeyboard(
                "giveAWord"
            )
        }) {
            Text(
                text = buildString {
        append("Guess Word")
    }
            )
        }
    }
    Box {
        Column(
            modifier = Modifier
                .border(10.dp, Color.White)
        ) {
            when (handler.info.keyBoard) {
                buildString {
        append("letter") } -> {
                    letters.LetterCons(handler)
                }
                buildString {
        append("giveAWord") } -> {
                    PickAWord(handler)
                }
            }
        }
    }
}

@Composable
fun PickAWord(handler: GameHandler){
    OutlinedTextField(value = handler.info.chooseAWord,
        onValueChange = { handler.info.chooseAWord = it })
    Button(onClick = { handler.chooseAWord() }) {
        Text(text = buildString {
        append("Submit")
    })
    }
}

@Composable
fun MessageTypes(handler: GameHandler){
    if(handler.info.gameWinner) {
        Row() {
            Text(
                text = buildString {
        append("You've won the game!")
            },
                fontSize = 20.sp
            )
        }
    }else{
        Row(){
            Text(
                text = buildString {
        append("GameOver! The given word was ")
        append(handler.info.generatedWord)
        },
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }
    Button(onClick = {handler.refresh()}) {
        Text(text = buildString {
        append("Play Again")
    })
    }
}
@Composable
fun LivesLeft(livesLeft:Int){
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = buildString {
        append("Lives Left: ")
        append(livesLeft)
    },
            fontSize = 30.sp,
        )
    }
}