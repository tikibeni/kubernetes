import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Timer
import kotlin.concurrent.schedule

fun getRandomString() : String {
    return java.util.UUID.randomUUID().toString()
}

fun printWithSchedule(printable: String) {
    Timer("generate", false).schedule(5000) {
        println(DateTimeFormatter.ISO_INSTANT
            .withZone(ZoneId.of("Europe/Helsinki"))
            .format(Instant.now())
                + ": $printable")
        printWithSchedule(printable)
    }
}

fun main() {
    val printable = getRandomString()
    printWithSchedule(printable)
}

