package models

class Extract(val text: String, val article: Option[Long], val begin: Option[Long], val end: Option[Long])
