package models

import java.time.LocalDate

class SchedulingInfo(val id: Long, val eFactor: Double, val repetition: Int, val interval: Long, val nextDate: LocalDate)
