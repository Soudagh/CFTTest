package com.example.cfttest.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cfttest.domain.models.UserInfoViewModel
import com.example.cfttest.ui.components.InfoRow
import com.example.cfttest.ui.utils.dial
import com.example.cfttest.ui.utils.map
import com.example.cfttest.ui.utils.sendMail

@Composable
fun UserDetailsScreen(userInfoViewModel: UserInfoViewModel) {
    val user = userInfoViewModel.userInfo!!
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(128.dp)
                    .clip(RoundedCornerShape(8.dp)),
                model = user.picture,
                contentDescription = null
            )
            InfoRow(title = "Full name", description = user.name)
        }
        InfoRow(title = "Gender", description = user.gender)
        InfoRow(
            modifier = Modifier.clickable { context.sendMail(to = user.email, subject = "") },
            title = "Email",
            description = user.email,
            textColor = Color.Blue
        )
        InfoRow(
            modifier = Modifier.clickable { context.dial(user.phone) },
            title = "Phone",
            description = user.phone,
            textColor = Color.Blue
        )
        InfoRow(
            modifier = Modifier.clickable { context.dial(user.cell) },
            title = "Cell",
            description = user.cell,
            textColor = Color.Blue
        )
        InfoRow(title = "Id", description = user.id)
        InfoRow(title = "Nationality", description = user.nat)
        InfoRow(title = "Date of Birth", description = user.dob)
        InfoRow(title = "Age", description = user.age.toString())
        InfoRow(title = "Registered", description = user.registered)
        InfoRow(title = "Registered Age", description = user.registeredAge.toString())
        InfoRow(title = "Login", description = user.login)
        InfoRow(modifier = Modifier.clickable {
            context.map(
                longitude = user.longitude,
                latitude = user.latitude
            )
        }, title = "Location", description = user.location, textColor = Color.Blue)
    }
}
