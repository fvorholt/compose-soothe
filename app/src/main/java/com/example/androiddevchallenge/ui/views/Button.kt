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
package com.example.androiddevchallenge.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun PrimaryButton(
    caption: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) = BaseButton(caption = caption, onClick = onClick, modifier = modifier)

@Composable
fun SecondaryButton(
    caption: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) = BaseButton(
    caption = caption,
    onClick = onClick,
    modifier = modifier,
    color = MaterialTheme.colors.secondary
)

@Composable
fun BaseButton(
    caption: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color? = null
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(72.dp)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color ?: MaterialTheme.colors.primary
        )
    ) {
        Text(caption.toUpperCase(Locale.getDefault()), style = MaterialTheme.typography.button)
    }
}
