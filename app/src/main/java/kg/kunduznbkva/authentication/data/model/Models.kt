package kg.kunduznbkva.authentication.data.model
import com.google.gson.annotations.SerializedName
import okhttp3.Response
import java.util.Date

data class UserEmail ( val email: String)


data class TokenObtainPair(
    val email: String,
    val password: String
)

data class TokenRefresh(
    val access: String,
    val refresh: String
)

data class UserCreateRequest(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("birth_date")
    val birthDate: Date
)

data class UserSetPassword(
    @SerializedName("password")
    val password: String,
    @SerializedName("password2")
    val password2: String
)