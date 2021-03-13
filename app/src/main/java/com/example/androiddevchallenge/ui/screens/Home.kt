/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.DataProvider
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Topic
import com.example.androiddevchallenge.ui.views.FavoriteCard
import com.example.androiddevchallenge.ui.views.RoundedTopic
import com.example.androiddevchallenge.ui.views.TextInput

@Composable
fun Home(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            Icons.Filled.Spa,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = { Text("HOME", style = MaterialTheme.typography.caption) }
                )

                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_account_circle),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = { Text("PROFILE", style = MaterialTheme.typography.caption) }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        var favorites by remember { mutableStateOf(DataProvider.getFavoriteTopics()) }
        var bodyTopics by remember { mutableStateOf(DataProvider.getBodyTopics()) }
        var mindTopics by remember { mutableStateOf(DataProvider.getMindTopics()) }

        Column(
            modifier = modifier.scrollable(rememberScrollState(), Orientation.Vertical)
        ) {
            var searchValue by remember { mutableStateOf("") }
            TextInput(
                value = searchValue,
                onValueChange = {
                    searchValue = it
                    favorites = DataProvider.getFavoriteTopics(it)
                    bodyTopics = DataProvider.getBodyTopics(it)
                    mindTopics = DataProvider.getMindTopics(it)
                },
                placeholder = "Search",
                modifier = Modifier.padding(top = 56.dp, start = 16.dp, end = 16.dp),
                icon = Icons.Filled.Search
            )

            Text(
                text = "FAVORITE COLLECTIONS",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(start = 16.dp)
            ) {
                items(favorites.size / 2) { index ->
                    val upperTopic = favorites[index]
                    val lowerTopic = favorites[favorites.size / 2 + index]
                    Column(
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        FavoriteCard(title = upperTopic.title, imageRes = upperTopic.imageRes)
                        Spacer(Modifier.size(8.dp))
                        FavoriteCard(title = lowerTopic.title, imageRes = lowerTopic.imageRes)
                    }
                }
            }

            TopicRow("ALIGN YOUR BODY", bodyTopics)
            TopicRow("ALIGN YOUR MIND", mindTopics)
        }
    }
}

@Composable
fun TopicRow(headline: String, topics: List<Topic>) {
    Text(
        text = headline,
        style = MaterialTheme.typography.h2,
        modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
    )
    LazyRow(
        contentPadding = PaddingValues(start = 16.dp)
    ) {
        items(topics) { topic ->
            RoundedTopic(title = topic.title, imageRes = topic.imageRes)
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}
