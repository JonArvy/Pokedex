package sz.sapphirex.pokedex.presentation.theme

import androidx.compose.material3.Typography
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

//val JosefinSansFontFamily = FontFamily(
//    // Normal
//    Font(R.font.josefinsans_regular, FontWeight.Normal),
//    Font(R.font.josefinsans_bold, FontWeight.Bold),
//    Font(R.font.josefinsans_extralight, FontWeight.ExtraLight),
//    Font(R.font.josefinsans_light, FontWeight.Light),
//    Font(R.font.josefinsans_medium, FontWeight.Medium),
//    Font(R.font.josefinsans_semibold, FontWeight.SemiBold),
//    Font(R.font.josefinsans_thin, FontWeight.Thin),
//    // Italics
//    Font(R.font.josefinsans_italic, FontWeight.Normal, FontStyle.Italic),
//    Font(R.font.josefinsans_bolditalic, FontWeight.Bold, FontStyle.Italic),
//    Font(R.font.josefinsans_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
//    Font(R.font.josefinsans_lightitalic, FontWeight.Light, FontStyle.Italic),
//    Font(R.font.josefinsans_mediumitalic, FontWeight.Medium, FontStyle.Italic),
//    Font(R.font.josefinsans_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),
//    Font(R.font.josefinsans_thinitalic, FontWeight.Thin, FontStyle.Italic)
//)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

