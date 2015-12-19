package models

import java.util.Date

class SchedulingInfo(val id: Long, val eFactor: Double, val repetition: Int, val nextDate: Date)
