package com.grillsandflames.quotationgenerator

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomerForm(customerInfo: MutableMap<String, String>) {
    val name = remember { mutableStateOf(customerInfo["name"] ?: "") }
    val phone = remember { mutableStateOf(customerInfo["phone"] ?: "") }
    val email = remember { mutableStateOf(customerInfo["email"] ?: "") }
    val address = remember { mutableStateOf(customerInfo["address"] ?: "") }

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
                customerInfo["name"] = it
            },
            label = { Text("Customer Name") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        )
        OutlinedTextField(
            value = phone.value,
            onValueChange = {
                phone.value = it
                customerInfo["phone"] = it
            },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        )
        OutlinedTextField(
            value = email.value,
            onValueChange = {
                email.value = it
                customerInfo["email"] = it
            },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        )
        OutlinedTextField(
            value = address.value,
            onValueChange = {
                address.value = it
                customerInfo["address"] = it
            },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        )
    }
}