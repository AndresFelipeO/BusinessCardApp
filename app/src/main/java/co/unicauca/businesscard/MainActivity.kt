package co.unicauca.businesscard

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.unicauca.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color =   Color(222, 255, 238)
            ) {
                // Llama a tu composable personalizado aquí
                body(
                    author = Author(
                        "Andres Felipe Ocampo",
                        R.drawable.authorphoto,
                        "+57  3114235725",
                        "@AndroidDev",
                        "ocampoandres@gmail.com"
                    )
                )
            }
        }

        }
    }


data class  Author(val name:String,val photo:Int,val phone:String,val title:String,val email:String)

@Preview
@Composable
fun view(){
    body(author = Author("Andres Felipe Ocampo", R.drawable.authorphoto,
        "3114235725", "AndroidDev","ocampoandres@gmail.com"))
}

@Composable
fun body(author:Author){

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,) {

            pictureAuthor(id = author.photo)
            Text(text = author.name, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text(text = "Android Developer Extraordinaire", fontWeight = FontWeight.Bold,fontSize = 20.sp, color =  Color(63, 108, 85))

        }
        Column(horizontalAlignment = Alignment.Start) {

            info(icon = Icons.Rounded.Phone, label =author.phone )
            info(icon = Icons.Rounded.Share, label =author.title )
            info(icon = Icons.Rounded.Email, label =author.email )
        }

    }

}
@Composable
fun pictureAuthor(id:Int){
    val imageModifier = Modifier
        .size(150.dp)
        .border(BorderStroke(1.dp, Color.Black))
        .background(Color.Yellow)
    Image(
        alignment = Alignment.Center,
        modifier = imageModifier,
        painter = painterResource(id),
        contentDescription = "Contact profile picture",
    )
}
@Composable
fun info (icon:ImageVector,label:String) {
    Row {
        Icon(icon,contentDescription="icon" ,Modifier.size(18.dp), tint = Color(63, 108, 85))
        Spacer(modifier = Modifier.width(20.dp))
        Text(text =label,fontSize = 18.sp)
    }
}
