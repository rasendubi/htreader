package schedulers

import java.time.LocalDate

import models.SchedulingInfo

class SM2 {
  def init(id: Long, dateAdded: LocalDate) =
    new SchedulingInfo(
      id = id,
      eFactor = 2.5,
      repetition = 1,
      interval = 1,
      nextDate = dateAdded.plusDays(1)
    )

  def schedule(item: SchedulingInfo, date: LocalDate, quality: Int): SchedulingInfo = {
    if (quality < 3) {
      new SchedulingInfo(
        id = item.id,
        eFactor = item.eFactor,
        repetition = 1,
        interval = 1,
        nextDate = date.plusDays(1)
      )
    } else {
      val eFactor = easiness(item.eFactor, quality)
      val nextInterval = interval(item.interval, eFactor, item.repetition + 1)
      new SchedulingInfo(
        id = item.id,
        eFactor = eFactor,
        repetition = item.repetition + 1,
        interval = nextInterval,
        nextDate = date.plusDays(nextInterval)
      )
    }
  }

  private def easiness(ef: Double, q: Int) = Math.max(1.3, ef + (0.1 - (5-q)*(0.08 + (5-q)*0.02)))

  private def interval(interval: Long, eFactor: Double, n: Int): Long =
    if (n == 1) 1
    else if (n == 2) 6
    else Math.round(interval * eFactor)

}
