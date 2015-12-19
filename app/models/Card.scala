package models

class Card(val question: String, val answer: String, val article: Option[Long], val extract: Option[Long])
