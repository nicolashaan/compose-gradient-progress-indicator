package tech.bam.progressindicator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import tech.bam.progressindicator.ui.theme.CustomProgressIndicatorTheme
import tech.bam.progressindicator.ui.theme.LightGrey

enum class ProgressBarColor(val gradientStart: Color, val gradientEnd: Color) {
    Red(Color(254, 222, 224), Color(255, 31, 43)),
    Green(Color(168, 242, 205), Color(38, 222, 129)),
    Blue(Color(219, 229, 251), Color(75, 123, 236)),
    Purple(Color(224, 204, 255), Color(98, 0, 254, 255));

    operator fun invoke(): Color {
        return gradientEnd
    }
}

val trackColor = White

@Composable
fun App() {
    CustomProgressIndicatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var progress: Float by remember { mutableStateOf(0.75f) }
            val indicatorSize = 144.dp
            val trackWidth: Dp = (indicatorSize * .1f)
            val commonModifier = Modifier.size(indicatorSize)

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(LightGrey)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    GradientProgressIndicator(
                        progress = progress,
                        modifier = commonModifier,
                        strokeWidth = trackWidth,
                        gradientStart = ProgressBarColor.Blue.gradientStart,
                        gradientEnd = ProgressBarColor.Blue.gradientEnd,
                        trackColor = trackColor,
                    )
                    GradientProgressIndicator(
                        progress = progress,
                        modifier = commonModifier,
                        strokeWidth = trackWidth,
                        gradientStart = ProgressBarColor.Red.gradientStart,
                        gradientEnd = ProgressBarColor.Red.gradientEnd,
                        trackColor = trackColor,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    GradientProgressIndicator(
                        progress = progress,
                        modifier = commonModifier,
                        strokeWidth = trackWidth,
                        gradientStart = ProgressBarColor.Green.gradientStart,
                        gradientEnd = ProgressBarColor.Green.gradientEnd,
                        trackColor = trackColor,
                    )
                    GradientProgressIndicator(
                        progress = progress,
                        modifier = commonModifier,
                        strokeWidth = trackWidth,
                        gradientStart = ProgressBarColor.Purple.gradientStart,
                        gradientEnd = ProgressBarColor.Purple.gradientEnd,
                        trackColor = trackColor,
                    )
                }
                Slider(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    value = progress,
                    onValueChange = { progress = it }
                )
            }
        }
    }
}

@Preview
@Composable
fun App_Preview() {
    App()
}
