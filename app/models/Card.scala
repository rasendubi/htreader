package models

import play.api.libs.json.{Json, Writes}

class Card(val id: Long, val question: String, val answer: String, val article: Option[Long], val extract: Option[Long])

object Card {
  implicit val writes = new Writes[Card] {
    def writes(c: Card) =
      Json.obj(
        "id" -> c.id,
        "question" -> c.question,
        "answer" -> c.answer,
        "article" -> c.article,
        "extract" -> c.extract
      )
  }
}
