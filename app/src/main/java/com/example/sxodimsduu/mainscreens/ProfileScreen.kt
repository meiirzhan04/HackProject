
import android.R.attr.tint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sxodimsduu.R
import com.example.sxodimsduu.login.CustomButton

@Preview
@Composable
fun ProfileScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF_1F1D2B))
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(52.dp))
            Text(
                text = "Profile",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(86.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .border(1.dp, color = Color(0xFF_252836))
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        modifier = Modifier
                            .size(42.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Manas",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "manas.esendikov@mail.ru",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF_B1B1B1)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(painter = painterResource(id = R.drawable.ic_edit), contentDescription = null)
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(16.dp))
                    .border(1.dp, color = Color(0xFF_252836))
                    .padding(24.dp)
            ) {
                Text(
                    text = "Account",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_avatar_profile), contentDescription = null, tint = Color(0xFF_12CDD9))
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Member",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next_profile),
                        contentDescription = null,
                        tint = Color(0xFF_12CDD9),
                        modifier = Modifier
                            .clickable(
                                onClick = {

                                }
                            )
                        )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_wallet),
                        contentDescription = null,
                        tint = Color(0xFF_12CDD9)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Cash",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next_profile),
                        contentDescription = null,
                        tint = Color(0xFF_12CDD9),
                        modifier = Modifier
                            .clickable(
                                onClick = {

                                }
                            )
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(16.dp))
                    .border(1.dp, color = Color(0xFF_252836))
                    .padding(24.dp)
            ) {
                Text(
                    text = "More",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_avatar_profile), contentDescription = null, tint = Color(0xFF_12CDD9))
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Legal and Policies",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next_profile),
                        contentDescription = null,
                        tint = Color(0xFF_12CDD9),
                        modifier = Modifier
                            .clickable(
                                onClick = {

                                }
                            )
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_shield), contentDescription = null, tint = Color(0xFF_12CDD9))
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Help & Feedback",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next_profile),
                        contentDescription = null,
                        tint = Color(0xFF_12CDD9),
                        modifier = Modifier
                            .clickable(
                                onClick = {

                                }
                            )
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_info), contentDescription = null, tint = Color(0xFF_12CDD9))
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "About us",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next_profile),
                        contentDescription = null,
                        tint = Color(0xFF_12CDD9),
                        modifier = Modifier
                            .clickable(
                                onClick = {

                                }
                            )
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            CustomButton(
                text = "Log Out",
                onClick = {

                }
            )
        }
    }
}