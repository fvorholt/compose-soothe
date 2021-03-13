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

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.views.PrimaryButton
import com.example.androiddevchallenge.ui.views.SecondaryButton

@Composable
fun Welcome(
    onSignUpClick: () -> Unit,
    onLogInClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val logo = if (isSystemInDarkTheme()) {
        painterResource(id = R.drawable.ic_dark_logo)
    } else {
        painterResource(id = R.drawable.ic_light_logo)
    }

    val background = if (isSystemInDarkTheme()) {
        painterResource(id = R.drawable.welcome_background_dark)
    } else {
        painterResource(id = R.drawable.welcome_background_light)
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(painter = logo, contentDescription = "Welcome to my soothe")
            Spacer(Modifier.size(32.dp))
            PrimaryButton(caption = "Sign up", onClick = onSignUpClick)
            Spacer(Modifier.size(8.dp))
            SecondaryButton(caption = "log in", onClick = onLogInClick)
        }
    }
}
