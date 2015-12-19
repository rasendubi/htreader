package models

import java.util.Date

class SchedulingInfo(val id: Long, val eFactor: Double, val repetition: Int, val interval: Long, val nextDate: Date) {

  def this(eFactor: Double, repetition: Int, interval: Long, nextDate: Date) = this(0, eFactor, repetition, interval, nextDate)
}
