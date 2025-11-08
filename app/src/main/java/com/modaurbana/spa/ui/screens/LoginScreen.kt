package com.modaurbana.spa.ui.screens


import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.*
import com.modaurbana.spa.utils.isValidEmail
import com.modaurbana.spa.utils.isValidPassword
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue









@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onGoRegister: () -> Unit,
    onLoginOk: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var pass by rememberSaveable { mutableStateOf("") }

    var emailError by rememberSaveable { mutableStateOf<String?>(null) }
    var passError by rememberSaveable { mutableStateOf<String?>(null) }

    var showPass by rememberSaveable { mutableStateOf(false) }
    var isLoading by rememberSaveable { mutableStateOf(false) }

    fun validate(): Boolean {
        emailError = when {
            email.isBlank() -> "El ingreso del correo electronico es obligatorio. Porfavor rellenar"
            !isValidEmail(email) -> "El correo que ingreso es invalido. Porfavor ver si incluyo @, ."
            else -> null
        }
        passError = when {
            pass.isBlank() -> "El ingreso de la contraseña es obligatiorio. Porfavor rellenar"
            !isValidPassword(pass) -> "La contraseña tiene que tener un mínimo de 6 caracteres. Porfavor escribir otra contraseña"
            else -> null
        }
        return emailError == null && passError == null
    }

    val isFormFilled = email.isNotBlank() && pass.isNotBlank()

    Scaffold (
        topBar = { CenterAlignedTopAppBar(title = {Text("Login")})}
    ) { padding ->
        Column (
            Modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            OutlinedTextField(
                value = email, onValueChange = { email = it},
                label = {Text("Correo")},
                singleLine = true,
                isError = emailError != null,
                supportingText = {emailError?.let {Text(it)}},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = pass, onValueChange = {pass = it},
                label = { Text("Contraseña")},
                singleLine = true,
                isError = passError != null,
                supportingText = {passError?.let {Text(it)}},
                visualTransformation = if (showPass) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    TextButton(onClick = {showPass = !showPass} ){
                        Text(if (showPass)"Ocultar" else "Mostrar")
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (!isLoading && validate()){
                        isLoading = true
                        onLoginOk()
                        isLoading = false
                    }
                },
                enabled = isFormFilled && !isLoading,
                modifier = Modifier.fillMaxWidth()
            ){
                if (isLoading) CircularProgressIndicator(strokeWidth = 2.dp)
                else Text("Entrar")
            }

            TextButton(
                onClick = onGoRegister,
                modifier = Modifier.fillMaxWidth()
            ) {Text("¿Aun no te creas tu cuenta?, ¡Crea tu cuenta ahora!")}
        }

    }
}