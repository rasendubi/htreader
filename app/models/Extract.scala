package models

class Extract(val id: Long, val text: String, val article: Option[Long], val begin: Option[Long], val end: Option[Long])
