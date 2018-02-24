private val all_countries = listOf(
        "BRAZIL",
        "CAMEROON",
        "CHILE",
        "GREECE",
        "URUGUAY",
        "ITALY",
        "FRANCE",
        "BOSNIA AND HERZEGOVINA",
        "GERMANY",
        "USA",
        "RUSSIA",
        "CROATIA",
        "SPAIN",
        "AUSTRALIA",
        "COTE D'LVOIRE",
        "COSTA RICA",
        "SWITZERLAND",
        "HONDURAS",
        "IRAN",
        "PORTUGAL",
        "BELGIUM",
        "KOREA REPUBLIC",
        "MEXICO",
        "NETHERLANDS",
        "COLOMBIA",
        "JAPAN",
        "ENGLAND",
        "ECUADOR",
        "ARGENTINA",
        "NIGERIA",
        "GHANA",
        "ALGERIA"
)

fun main(args: Array<String>) {
//    // expect: NETHERLANDS, NIGERIA
//    println(filterContinuableWord("JAPAN", mutableListOf()))
//    // expect: SPAIN, SWITZERLAND
//    println(filterContinuableWord("NETHERLANDS", mutableListOf()))
//    // expect: NIGERIA
//    println(filterContinuableWord("JAPAN", mutableListOf("NETHERLANDS")))
//    // expect: empty
//    println(filterContinuableWord("X", mutableListOf()))

    // expect: JAPAN -> NETHERLANDS -> SWITZERLAND
//    val results = mutableListOf<List<String>>()
//    wordGame(results, mutableListOf("JAPAN"))
//    println(results)

    val results = mutableListOf<List<String>>()
    for(startCountry in all_countries) {
        wordGame(results, listOf(startCountry))
    }
    val longestResult = results.maxBy { it -> it.size }
    println("longest word game results = $longestResult")
}

fun String.lastWord() : String = this[this.lastIndex].toString()

fun filterContinuableWord(prevWord: String, words: List<String>) : List<String> {
    return all_countries.filter {
        it.startsWith(prevWord.lastWord()) && !words.contains(it)
    }
}

fun wordGame(results: MutableList<List<String>>, words: List<String>) {
    val previousWord = words[words.lastIndex]
    val continuableWords = filterContinuableWord(previousWord, words)
    if(continuableWords.isNotEmpty()) {
        for (nextWord in continuableWords) {
            val tmp = mutableListOf<String>().apply {
                addAll(words)
                add(nextWord)
            }
            wordGame(results, tmp)
        }
    } else {
        // しりとりできなくなったら結果に追加
        results.add(words)
    }
}