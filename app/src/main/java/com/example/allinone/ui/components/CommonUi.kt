package com.example.allinone.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.allinone.R
import com.example.allinone.ui.theme.AllInOneTheme

@Composable
fun IconWithTitle (
    @StringRes title: Int,
    @DrawableRes iconRes: Int,
    onClickListener: () -> Unit
) {
    /** To Do **/
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 80.dp)
            .padding(8.dp),
        onClick = onClickListener
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
            Text(
                text = stringResource(title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun IconWithTitlePreview(){
    AllInOneTheme {
        IconWithTitle(
            title = R.string.home,
            iconRes = R.drawable.home,
            onClickListener = {}
        )
    }
}