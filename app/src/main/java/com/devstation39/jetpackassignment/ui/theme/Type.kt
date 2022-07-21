package com.devstation39.jetpackassignment.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.devstation39.jetpackassignment.R

val OpenSensFont = FontFamily(
    listOf(
        Font(R.font.open_sans_bold, FontWeight.Bold),
        Font(R.font.open_sans_regular, FontWeight.Normal),
    )
)

val MyTypoGraphic = Typography(
    defaultFontFamily = OpenSensFont,
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)


