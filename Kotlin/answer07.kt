import java.text.SimpleDateFormat
import java.util.*

fun searchReverseDate(startDate : Calendar, endDate : Calendar) : List<String> {
    val result = mutableListOf<String>()
    while(true) {
        if(startDate.compareTo(endDate) >= 0) {
            break
        }

        val dateString = yyyyMMdd(startDate)
        if(dateString.equals(toReversedDateString(startDate))) {
            result.add(dateString)
        }

        startDate.add(Calendar.DAY_OF_MONTH, 1)
    }
    return result
}

fun convertToCalendar(year : Int, month : Int, date : Int) : Calendar {
    val cal = Calendar.getInstance()
    cal.set(year, month-1, date)
    return cal
}

fun yyyyMMdd(calendar : Calendar) : String {
    val dateFormat = SimpleDateFormat("yyyyMMdd")
    return dateFormat.format(calendar.time)
}

fun toYyyyMMddBinaryString(calendar : Calendar) : String {
    val yyyyMMddString = yyyyMMdd(calendar)
    val yyyyMMddBin = Integer.toBinaryString(yyyyMMddString.toInt())
    return yyyyMMddBin
}

fun toReversedDateString(calendar : Calendar) : String {
    val yyyyMmDdBin = toYyyyMMddBinaryString(calendar)
    val reversedDateString = yyyyMmDdBin.reversed()
    val reversedDateInt = Integer.parseInt(reversedDateString, 2)
    return reversedDateInt.toString()
}

println(searchReverseDate(convertToCalendar(1964, 10, 10), convertToCalendar(2020, 7, 24)))
