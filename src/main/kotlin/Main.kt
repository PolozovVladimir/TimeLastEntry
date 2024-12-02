enum class Time(val value: Int) {
    MINUTE(60), HOUR(60 * 60), DAY(60 * 60 * 24)
}
fun agoToText(time: Int) {
    when (time) {
        in 0..Time.MINUTE.value ->
            print("Был(а) только что")
        in 61..Time.HOUR.value -> {
            val tempTime = time / Time.MINUTE.value
            print("Был(а)  $tempTime ${timeToText(tempTime.toString(), Time.MINUTE)} минут назад")
        }
        in (Time.HOUR.value + 1)..(Time.DAY.value) -> {
            val tempTime = time / Time.HOUR.value
            print("Был(а) $tempTime ${timeToText(tempTime.toString(), Time.HOUR)} часов назад")
        }
        in (Time.DAY.value + 1)..(Time.DAY.value * 2) ->
            print("Был(а) вчера")
        in (Time.DAY.value * 2 + 1)..(Time.DAY.value * 3) ->
            print("Был(а) позавчера")
        in (Time.DAY.value * 3 + 1)..Int.MAX_VALUE ->
            print("Был(а) давно")
    }
}
fun timeToText(time: String, type: Time): String {
    val lastSymbol = time[time.length - 1]
    when (type) {
        Time.MINUTE ->
            when (lastSymbol) {
                '1' -> return "минуту"
                in '2'..'4' -> return "минуты"
                in '5'..'9', '0' -> return "минут"
            }
        Time.HOUR ->
            when (lastSymbol) {
                '1' -> return "час"
                in '2'..'4' -> return "часа"
                in '5'..'9', '0' -> return "часов"
            }
        else -> return "Error"
    }
    return "Error"
}