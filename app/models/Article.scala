package models

import play.api.libs.json.{Json, Writes}

class Article(val id: Long, val title: String, val text: String, val source: String, val offset: Long) {

  def this(id: Long, article: Article) = this(id, article.title, article.text, article.source, article.offset)
  def this(title: String, text: String, source: String, offset: Long) = this(0, title, text, source, offset)
}

object Article {
  implicit val writes = new Writes[Article] {
    def writes(a: Article) =
      Json.obj(
        "id" -> a.id,
        "title" -> a.title,
        "text" -> a.text,
        "source" -> a.source,
        "offset" -> a.offset
      )
  }
}
