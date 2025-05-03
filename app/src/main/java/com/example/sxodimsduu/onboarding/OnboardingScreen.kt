package com.example.sxodimsduu.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sxodimsduu.data.OnboardingData
import com.example.sxodimsduu.data.onboardingPages
import com.example.sxodimsduu.viewmodel.OnboardingPreferences
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val preferences = remember { OnboardingPreferences(context) }
    val pagerState = rememberPagerState { onboardingPages.size }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF111827))
            .padding(bottom = 100.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
        ) { index ->
            OnBoardingPage(
                onboardingPages[index],
                navController = navController,
                pagerState = pagerState,
                onCLick = {
                    navController.navigate(Screen)
                }
            )
        }
        Indicator(
            currentPage = pagerState.currentPage,
            pageCount = onboardingPages.size,
            modifier = Modifier
                .padding(bottom = 32.dp)
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
        )
        AnimatedVisibility(
            visible = pagerState.currentPage == onboardingPages.size - 1
        ) {
            Button(
                onClick = {
                    scope.launch {
                        preferences.setOnboardingCompleted()
                        navController.navigate(Screen)
                    }
                },
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF_12CDD9)
                )
            ) {
                Text(
                    text = "Әрі қарай",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W600,
                    letterSpacing = 0.5.sp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
        }
    }
}

@Composable
fun OnBoardingPage(
    data: OnboardingData,
    navController: NavController,
    pagerState: PagerState,
    onCLick: () -> Unit,
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                painter = painterResource(id = data.image),
                contentDescription = null,
                modifier = Modifier.size(538.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(top = 370.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF111827).copy(alpha = 0f),
                                Color(0xFF111827).copy(alpha = 0.98f),
                                Color(0xFF111827).copy(alpha = 1f)
                            ),
                            startY = 150f,
                            endY = 500f
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(100.dp))
                    Text(
                        text = "ÖZINŞE-ге қош келдің!",
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.5.sp
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 32.dp),
                        lineHeight = 22.sp,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp,
                        color = Color(0xFF9CA3AF),
                        text = data.description
                    )
                }
            }
        }
    }
}

@Composable
fun Indicator(
    modifier: Modifier = Modifier,
    currentPage: Int,
    pageCount: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .size(
                        width = if (index == currentPage) 24.dp else 8.dp,
                        height = 8.dp
                    )
                    .background(
                        color = if (index == currentPage) Color(0xFF_12CDD9) else Color.Gray,
                        shape = RoundedCornerShape(50)
                    )
            )
        }
    }
}