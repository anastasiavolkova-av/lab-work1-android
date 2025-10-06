package com.example.lab_1

// Функция для генерации случайного списка чисел
fun generateRandomList(size: Int = 15, range: IntRange = 1..10): List<Int> {
    return List(size) { range.random() }
}

// Основная функция - найти элементы встречающиеся более одного раза (без повторения)
fun findDuplicateElements(list: List<Int>): List<Int> {
    val seen = mutableSetOf<Int>()
    val duplicates = mutableSetOf<Int>()

    for (item in list) {
        if (item in seen) {
            duplicates.add(item)
        } else {
            seen.add(item)
        }
    }
    return duplicates.toList().sorted()
}

// Функция для вывода
fun formatResult(originalList: List<Int>, duplicates: List<Int>): String {
    return if (duplicates.isEmpty()) {
        "Элементы, встречающиеся более одного раза, не найдены"
    } else {
        "Исходный список: $originalList\n" +
                "Элементы > 1 раза: $duplicates\n" +
                "Количество дубликатов: ${duplicates.size}"
    }
}