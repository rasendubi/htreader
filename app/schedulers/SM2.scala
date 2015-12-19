package schedulers

import java.util.Date

import models.SchedulingInfo

object SM2 {
  def init(id: Long, dateAdded: Date) =
    new SchedulingInfo(
      id = id,
      eFactor = 2.5,
      repetition = 1,
      interval = 1,
      nextDate = addDays(dateAdded, 1)
    )

  def schedule(item: SchedulingInfo, date: Date, quality: Int): SchedulingInfo = {
    if (quality < 3) {
      new SchedulingInfo(
        id = item.id,
        eFactor = item.eFactor,
        repetition = 1,
        interval = 1,
        nextDate = addDays(date, 1)
      )
    } else {
      val eFactor = easiness(item.eFactor, quality)
      val nextInterval = interval(item.interval, eFactor, item.repetition + 1)
      new SchedulingInfo(
        id = item.id,
        eFactor = eFactor,
        repetition = item.repetition + 1,
        interval = nextInterval,
        nextDate = addDays(date, nextInterval)
      )
    }
  }

  private def easiness(ef: Double, q: Int) = Math.max(1.3, ef + (0.1 - (5-q)*(0.08 + (5-q)*0.02)))

  private def interval(interval: Long, eFactor: Double, n: Int): Long =
    if (n == 1) 1
    else if (n == 2) 6
    else Math.round(interval * eFactor)

  private def addDays(date: Date, days: Long): Date = {
    new Date(date.getTime + days * SM2.MILLIS_IN_DAY)
  }

  private val MILLIS_IN_DAY = 24 * 60 * 60 * 1000
}
