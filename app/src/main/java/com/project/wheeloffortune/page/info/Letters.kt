package com.project.wheeloffortune.page.info

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.wheeloffortune.handler.GameHandler
import com.project.wheeloffortune.page.PickLetter

/*Letters.kt - Includes our letters, there are 3 rows.*/
class Letters {
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun LetterCons(handler: GameHandler){
        Spacer(modifier = Modifier.size(110.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp)){
            PickLetter("B", handler)
            PickLetter("C", handler)
            PickLetter("D", handler)
            PickLetter("F", handler)
            PickLetter("G", handler)
            PickLetter("H", handler)
            PickLetter("J", handler)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp)){
            PickLetter("K", handler)
            PickLetter("L", handler)
            PickLetter("M", handler)
            PickLetter("N", handler)
            PickLetter("P", handler)
            PickLetter("Q", handler)
            PickLetter("R", handler)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp)) {
            PickLetter("S", handler)
            PickLetter("T", handler)
            PickLetter("V", handler)
            PickLetter("W", handler)
            PickLetter("X", handler)
            PickLetter("Z", handler)
        }
    }
}