package schedulers

import java.util.Date

import models.Extract

object ExtractScheduling {
  def schedule(e: Extract, dateReviewed: Date): Extract = {
    new Extract(
      id = e.id,
      text = e.text,
      article = e.article,
      begin = e.begin,
      end = e.end,
      repetition = e.repetition + 1,
      nextDate = addDays(dateReviewed, days(e.repetition + 1))
    )
  }

  private def days(n: Int): Long =
    if (n == 1) 1
    else if (n == 2) 6
    else Math.round(2.5 * days(n - 1))

  private def addDays(date: Date, days: Long): Date = {
    new Date(date.getTime + days * ExtractScheduling.MILLIS_IN_DAY)
  }

  private val MILLIS_IN_DAY = 24 * 60 * 60 * 1000
}
