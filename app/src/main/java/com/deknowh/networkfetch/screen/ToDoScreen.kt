package com.deknowh.networkfetch.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.deknowh.networkfetch.R
import com.deknowh.networkfetch.viewModel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTodo(viewModel: MainViewModel) {
    val myTodo by viewModel.todo.collectAsState()
    // scaffold
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Network Fetch",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                }
            )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            if (myTodo.isEmpty()) {
                LoadingBar()
            } else {
                LazyColumn {
                    items(myTodo) {myDo->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .height(150.dp)

                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(
                                    text = "My Todo-list",
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Cyan
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Title: ${myDo.title}")
                                Spacer(modifier = Modifier.padding(4.dp))
                                Text(text = "Description: ${myDo.description}")
                                Spacer(modifier = Modifier.padding(4.dp))
                                Text(text = "ID: ${myDo.id}")
                                Spacer(modifier = Modifier.padding(4.dp))
                                Text(text = "IsCompleted: ${myDo.isCompleted}")
                            }

                        }
                    }
                }
            }
            DisposableEffect(key1 = Unit) {
                viewModel.getToDoList()
                onDispose {  }
            }
        }

    }

}

@Composable
fun LoadingBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            CircularProgressIndicator(
                color = Color.Red,
                modifier = Modifier
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = stringResource(id = R.string.load_text),
                color = Color.Blue,
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic
            )
        }
    }

}