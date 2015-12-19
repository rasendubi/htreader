package models

import play.api.libs.json.{Json, Writes}

class Card(val id: Long, val question: String, val answer: String, val article: Option[Long], val extract: Option[Long]) {

  def this(id: Long, card: Card) = this(id, card.question, card.answer, card.article, card.extract)
  def this(question: String, answer: String, article: Option[Long], extract: Option[Long]) = this(0, question, answer, article, extract)
}

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
