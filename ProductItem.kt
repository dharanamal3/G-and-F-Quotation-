package com.grillsandflames.quotationgenerator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductItem(product: Product, isSelected: Boolean, onSelect: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onSelect() },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
            else MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(product.name, style = MaterialTheme.typography.titleMedium)
                Text(product.description, style = MaterialTheme.typography.bodySmall)
                Text("AED %.2f".format(product.price), style = MaterialTheme.typography.labelMedium)
            }
            Checkbox(
                checked = isSelected,
                onCheckedChange = { onSelect() }
            )
        }
    }
}