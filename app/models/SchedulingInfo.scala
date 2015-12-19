package models

import java.util.Date

import play.api.libs.json.{Json, Writes}

class SchedulingInfo(val id: Long, val cardId: Long, val eFactor: Double, val repetition: Int, val interval: Long, val nextDate: Date) {

  def this(id: Long, info: SchedulingInfo) = this(id, info.cardId, info.eFactor, info.repetition, info.interval, info.nextDate)
  def this(cardId: Long, eFactor: Double, repetition: Int, interval: Long, nextDate: Date) = this(0, cardId, eFactor, repetition, interval, nextDate)
}
