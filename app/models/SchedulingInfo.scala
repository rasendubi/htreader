package models

import java.util.Date

import play.api.libs.json.{Json, Writes}

class SchedulingInfo(val id: Long, val eFactor: Double, val repetition: Int, val interval: Long, val nextDate: Date) {

  def this(id: Long, info: SchedulingInfo) = this(id, info.eFactor, info.repetition, info.interval, info.nextDate)
  def this(eFactor: Double, repetition: Int, interval: Long, nextDate: Date) = this(0, eFactor, repetition, interval, nextDate)
}

object SchedulingInfo {
  implicit val writes = new Writes[SchedulingInfo] {
    def writes(i: SchedulingInfo) =
      Json.obj(
        "id" -> i.id,
        "e_factor" -> i.eFactor,
        "repetition" -> i.repetition,
        "interval" -> i.interval,
        "next_date" -> i.nextDate
      )
  }
}

