/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme
import kotlin.system.measureNanoTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            AffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    FrontScreen()
                }
            }
            //AffirmationApp()
        }
    }
}

@Composable
fun AffirmationApp() {
    AffirmationsTheme {
        AffirmationList(affirmationList = Datasource().loadAffirmations())
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        appTopBar()
    }
    )
    {
        LazyColumn {

            items(affirmationList) { affirmation ->
                AffirmationCard(affirmation)
            }
        }
    }
}

@Composable
fun Synopsis(@StringRes synopsis: Int,
            modifier: Modifier = Modifier){
    var booked by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 10.dp,
            bottom = 10.dp,
            end =16.dp
        )
    ){
        Text(
            text = "Synopsis :",
            style = MaterialTheme.typography.h5,
            color = Color.Black
        )
        Text(
            text = stringResource(id= synopsis),
            style = MaterialTheme.typography.body2,
            color = Color.Black
        )
        Row {
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF89CFF0)),
            modifier= Modifier.padding(top= 10.dp)) {
                Text(
                    text = "Play",
                    color = Color.Black
                )

            }
            Spacer(Modifier.weight(1f))
            BookmarkButton(
                booked = booked,
                onClick = { booked = !booked })

        }
        }
    }




@Composable
private fun InfoButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(onClick = onClick){
        Icon(
            imageVector = if(expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(id = R.string.expand_description)
        )
    }

}

@Composable
private fun BookmarkButton(
    booked: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick){
        Icon(
            imageVector = if(booked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(id = R.string.expand_description)
        )
    }

}

@SuppressLint("SuspiciousIndentation")
@Composable
private fun EnterButton(
    tapped: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier

){
    val image = painterResource(R.drawable.wind)
        Button(
            onClick = onClick,
           // modifier = Modifier.padding(top = 310.dp, bottom = 440.dp, end = 100.dp, start = 100.dp)
        ) {


            Text(
                text = "Tap to continue...",
                color = Color.White,
                modifier= Modifier.padding(top = 700.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
                //modifier = Modifier.size(20.dp)
            )
        }


}

@Composable
fun appTopBar(modifier: Modifier = Modifier) {
    val shuri = painterResource(R.drawable.shuriken_removebg_preview)
    Surface(color = Color(0xFFB6D0E2)) {

    Row() {


        Image(
            painter = shuri,
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )
        Text(
            text = "      AnimeFlix",
            fontSize = 36.sp,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black

            )
    }
}

}
@Composable
fun FrontScreen(){
    var tapped by remember {
        mutableStateOf(false)
    }

    val image = painterResource(R.drawable.wind)
    //val title = painterResource(R.drawable.title)
    if(!tapped) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Text(
            text="\uD835\uDC00\uD835\uDC27\uD835\uDC22\uD835\uDC26\uD835\uDC1E\uD835\uDC05\uD835\uDC25\uD835\uDC22\uD835\uDC31",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 60.sp,
            color= Color(0xFFFFFFFF),
            textAlign = TextAlign.Center,
            modifier= Modifier.padding(top=80.dp),
        )


        EnterButton(
            tapped = tapped,
            onClick = { tapped = !tapped })

    }
    if(tapped){
        AffirmationApp()
    }


}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
   var expanded by remember {
        mutableStateOf(false)
    }
    Surface(color = Color(0xFFB0E0E6)) {
        Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
            Surface(color = Color(0xFFD3D3D3)) {
                Column(modifier = Modifier.animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )) {


                    Row {
                        Image(
                            painter = painterResource(affirmation.imageResourceId),
                            contentDescription = stringResource(affirmation.stringResourceId),
                            modifier = Modifier
                                .size(150.dp),
                            contentScale = ContentScale.Crop
                        )

                        Column {

                            Surface(
                                color = Color(0xFF89CFF0),
                                modifier = Modifier.fillMaxWidth()
                            ) {

                                Row {
                                    Text(
                                        text = LocalContext.current.getString(affirmation.stringResourceId),
                                        modifier = Modifier
                                            .padding(top=16.dp, start= 16.dp, bottom = 16.dp),
                                        style = MaterialTheme.typography.h6,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.Black

                                    )
                                    Spacer(Modifier.weight(2f))
                                    InfoButton(
                                        expanded = expanded,
                                        onClick = { expanded = !expanded })


                                }
                            }

                            Text(
                                text = LocalContext.current.getString(affirmation.stringResourceIdDes),
                                modifier = Modifier.padding(18.dp),
                                fontSize = 16.sp,
                                color = Color.Black
                                // style = MaterialTheme.typography.h6
                            )
                        }
                    }
                    Surface(color = Color(0xFFC0C0C0), modifier = Modifier.fillMaxWidth()) {


                        if (expanded) {
                            Synopsis(affirmation.synopsisDes)
                        }
                    }
                }
            }
        }
    }

}


@Preview
@Composable
private fun AffirmationCardPreview() {
    AffirmationCard (Affirmation(R.string.affirmation1, R.drawable.death_note, R.string.description1, R.string.synopsis1))
}