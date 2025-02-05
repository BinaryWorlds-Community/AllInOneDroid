package com.example.allinone.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.allinone.data.AllInOneUiState

@Composable
fun AllInOneSettingsScreen(
    modifier: Modifier = Modifier,
    uiState: AllInOneUiState,
    selectDarkMode: (Boolean) -> Unit,
) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Use Dark Mode",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Switch(
            checked = uiState.isDarkMode,
            onCheckedChange = {
                selectDarkMode(!uiState.isDarkMode)
            },
            modifier = Modifier.padding(16.dp)
        )
    }
}