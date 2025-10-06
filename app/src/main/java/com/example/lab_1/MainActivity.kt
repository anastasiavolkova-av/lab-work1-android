package com.example.lab_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.lab_1.ui.theme.Lab_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DuplicateFinderScreen()
                }
            }
        }
    }
}

@Composable
fun DuplicateFinderScreen() {
    val originalList = remember { mutableStateOf(generateRandomList()) }
    val resultText = remember { mutableStateOf("Нажмите кнопку для обработки списка") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Лабораторная работа - Вариант 8",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Text(
            text = "Сгенерированный список:\n${originalList.value}",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Кнопка для поиска дубликатов
            Button(
                onClick = {
                    val duplicates = findDuplicateElements(originalList.value)
                    resultText.value = formatResult(originalList.value, duplicates)
                }
            ) {
                Text("Найти дубликаты")
            }

            // Кнопка для генерации нового списка
            Button(
                onClick = {
                    originalList.value = generateRandomList()
                    resultText.value = "Список обновлен! Нажмите 'Найти дубликаты'"
                }
            ) {
                Text("Новый список")
            }
        }

        Text(
            text = resultText.value,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
    }
}