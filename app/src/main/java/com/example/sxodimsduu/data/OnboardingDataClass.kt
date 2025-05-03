package com.example.sxodimsduu.data

import com.example.sxodimsduu.R

data class OnboardingData(
    val image: Int,
    val description: String,
)

val onboardingPages = listOf(
    OnboardingData(
        R.drawable.ic_onboardingv1,
        "Фильмдер, телехикаялар, ситкомдар, анимациялық жобалар, телебағдарламалар мен реалити-шоулар, аниме және тағы басқалары"
    ),
    OnboardingData(
        R.drawable.ic_onboardingv1, "Кез келген құрылғыдан қара \n" +
                "Сүйікті фильміңді  қосымша төлемсіз телефоннан, планшеттен, ноутбуктан қара"
    ),
    OnboardingData(
        R.drawable.ic_onboardingv1, "Тіркелу оңай. Қазір тіркел де қалаған фильміңе қол жеткіз"
    ),

    )