package models

import play.api.libs.json.{Json, Writes}

class Extract(val id: Long, val text: String, val article: Option[Long], val begin: Option[Long], val end: Option[Long])

object Extract {
  implicit val writes = new Writes[Extract] {
    def writes(e: Extract) =
      Json.obj(
        "id" -> e.id,
        "text" -> e.text,
        "article" -> e.article,
        "begin" -> e.begin,
        "end" -> e.end
      )
  }
}
