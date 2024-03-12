package com.example.cfttest.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cfttest.R
import com.example.cfttest.domain.models.User
import com.example.cfttest.ui.theme.Gray

@Composable
fun UserCard(
    user: User,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Gray
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier.size(128.dp),
                model = user.picture,
                contentDescription = null
            )
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                InfoIconRow(
                    iconRes = R.drawable.person,
                    text = user.name
                )
                InfoIconRow(
                    iconRes = R.drawable.home,
                    text = user.location
                )
                InfoIconRow(
                    iconRes = R.drawable.phone,
                    text = user.phone
                )
            }
        }
    }
}


@Preview
@Composable
fun UserCardPreview() {
    UserCard(
        modifier = Modifier.fillMaxWidth(),
        user = User(
            gender = "male",
            location = "asfsaf",
            name = "asfsaf",
            email = "telefon@gmail.ru",
            login = "asfsaf",
            dob = "asfsaf",
            registered = "asfsaf",
            phone = "phone1337",
            cell = "124",
            id = "asfa",
            picture = "https://i.imgur.com/nbF7HqW.png",
            age = 5,
            uid = 2,
            registeredAge = 4,
            nat = "RU"
        )
    )
}
