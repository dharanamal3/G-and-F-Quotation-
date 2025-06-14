package com.grillsandflames.quotationgenerator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuotationGenerator() {
    val customerInfo = remember { mutableStateMapOf<String, String>() }
    val selectedProducts = remember { mutableStateListOf<Product>() }
    val taxRate = 0.05

    val grills = listOf(
        Product("Premium Gas Grill", "3-burner stainless steel gas grill with side burner", 299.99),
        Product("Charcoal Grill", "Classic kettle design with temperature control", 199.99),
        Product("Pellet Smoker Grill", "Digital control with wood pellet flavor options", 499.99),
        Product("Portable Grill", "Compact design perfect for camping and picnics", 149.99)
    )

    val accessories = listOf(
        Product("Grill Tool Set", "Premium stainless steel 5-piece set", 39.99),
        Product("Grill Cover", "Weather-resistant protective cover", 24.99),
        Product("Cooking Thermometer", "Digital instant-read meat thermometer", 19.99),
        Product("Grill Mat Set", "Non-stick reusable BBQ grill mats (set of 3)", 29.99)
    )

    val services = listOf(
        Product("Assembly Service", "Professional assembly of your new grill", 79.99),
        Product("Delivery", "Home delivery and placement", 49.99),
        Product("Extended Warranty", "3-year extended protection plan", 129.99)
    )

    var subtotal by remember { mutableStateOf(0.0) }
    val tax = subtotal * taxRate
    val total = subtotal + tax

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            Text("Quotation Generator", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(8.dp))
        }
        item {
            CustomerForm(customerInfo)
        }
        item {
            Text("Select Products", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(8.dp))
        }
        items(grills + accessories + services) { product ->
            ProductItem(product = product, isSelected = selectedProducts.contains(product)) {
                if (selectedProducts.contains(product)) {
                    selectedProducts.remove(product)
                    subtotal -= product.price
                } else {
                    selectedProducts.add(product)
                    subtotal += product.price
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Subtotal: AED %.2f".format(subtotal))
            Text("Tax (5%): AED %.2f".format(tax))
            Text("Total: AED %.2f".format(total))
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Grills and Flames LLC, Dubai, UAE", style = MaterialTheme.typography.labelLarge)
        }
    }
}