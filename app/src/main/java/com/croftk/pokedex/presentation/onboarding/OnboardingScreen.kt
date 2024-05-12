package com.croftk.pokedex.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.croftk.pokedex.presentation.common.Button
import com.croftk.pokedex.presentation.common.TextButton
import com.croftk.pokedex.presentation.onboarding.comps.OnboardingUpper
import com.croftk.pokedex.presentation.onboarding.comps.PageIndicator
import com.croftk.pokedex.presentation.onboarding.data.Pages
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
	Column(
		modifier = Modifier.fillMaxSize()
	) {
		val pagerState = rememberPagerState(initialPage = 0){
			Pages.size
		}

		val buttonState = remember {
			derivedStateOf {
				when (pagerState.currentPage){
					0 -> listOf("", "Next")
					1 -> listOf("Back", "Next")
					2 -> listOf("Back", "Get Started")
					else -> listOf("", "")
				}
			}
		}

		HorizontalPager(state = pagerState) {
			OnboardingUpper(page = Pages[it])
		}

		Spacer(modifier = Modifier.height(16.dp))

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 32.dp)
				.navigationBarsPadding(),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
			PageIndicator(numPages = Pages.size, selectedPage = pagerState.currentPage)
			Row(
				verticalAlignment = Alignment.CenterVertically
			) {
				val scope = rememberCoroutineScope()
				if(buttonState.value[0].isNotEmpty()){
					TextButton(text = buttonState.value[0]) {
						scope.launch {
							pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
						}
					}
				}
				Button(text = buttonState.value[1]) {
					scope.launch {
						if(pagerState.currentPage == 3){
							//nav to home
						} else{
							pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
						}
					}
				}
			}
		}
	}
}


@Preview(showBackground = true)
@Composable
private fun onboardPrev() {
	OnboardingScreen()
}