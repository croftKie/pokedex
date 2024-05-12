package com.croftk.pokedex.presentation.onboarding.comps

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.croftk.pokedex.R
import com.croftk.pokedex.presentation.onboarding.data.Page
import com.croftk.pokedex.presentation.onboarding.data.Pages

@Composable
fun OnboardingUpper(modifier: Modifier = Modifier, page: Page) {
	Column(
		modifier = modifier
	) {
		Image(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.6f),
			painter = painterResource(id = page.image),
			contentDescription = null,
			contentScale = ContentScale.Crop
		)
		Spacer(modifier = Modifier.height(24.dp))
		Text(
			text = page.title,
			modifier = Modifier.padding(horizontal = 32.dp),
			style = MaterialTheme.typography.displayMedium,
			color = colorResource(id = R.color.text_medium)
		)
		Text(
			text = page.desc,
			modifier = Modifier.padding(horizontal = 32.dp),
			style = MaterialTheme.typography.bodyMedium,
			color = colorResource(id = R.color.text_medium)
		)
	}
}

@Preview(showBackground = true)
@Composable
private fun OnboardUpperPreview() {
	OnboardingUpper(page = Pages[0])
}