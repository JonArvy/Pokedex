package sz.sapphirex.pokedex.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import sz.sapphirex.pokedex.R

val PoppinsFontFamily = FontFamily(
    // Normal
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_black, FontWeight.Black),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold),
    Font(R.font.poppins_extralight, FontWeight.ExtraLight),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_thin, FontWeight.Thin),
    // Italics
    Font(R.font.poppins_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.poppins_blackitalic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.poppins_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.poppins_extrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.poppins_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.poppins_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.poppins_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.poppins_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.poppins_thinitalic, FontWeight.Thin, FontStyle.Italic),
)

val JosefinSansFontFamily = FontFamily(
    // Normal
    Font(R.font.josefinsans_regular, FontWeight.Normal),
    Font(R.font.josefinsans_bold, FontWeight.Bold),
    Font(R.font.josefinsans_extralight, FontWeight.ExtraLight),
    Font(R.font.josefinsans_light, FontWeight.Light),
    Font(R.font.josefinsans_medium, FontWeight.Medium),
    Font(R.font.josefinsans_semibold, FontWeight.SemiBold),
    Font(R.font.josefinsans_thin, FontWeight.Thin),
    // Italics
    Font(R.font.josefinsans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.josefinsans_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.josefinsans_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.josefinsans_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.josefinsans_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.josefinsans_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.josefinsans_thinitalic, FontWeight.Thin, FontStyle.Italic)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.0.sp,
        letterSpacing = 0.5.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.0.sp,
        letterSpacing = 0.2.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.0.sp,
        letterSpacing = 0.4.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    displayLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.0.sp,
        letterSpacing = (-0.2).sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.0.sp,
        letterSpacing = 0.0.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.0.sp,
        letterSpacing = 0.0.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.0.sp,
        letterSpacing = 0.0.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.0.sp,
        letterSpacing = 0.0.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.0.sp,
        letterSpacing = 0.0.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.0.sp,
        letterSpacing = 0.1.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.0.sp,
        letterSpacing = 0.5.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.0.sp,
        letterSpacing = 0.5.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Normal, // Not sure why this is Normal on material design
        fontSize = 22.sp,
        lineHeight = 28.0.sp,
        letterSpacing = 0.0.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.0.sp,
        letterSpacing = 0.2.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.0.sp,
        letterSpacing = 0.1.sp,
        fontFamily = PoppinsFontFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
)
