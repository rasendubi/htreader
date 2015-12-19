package controllers

import dtos.{CardDto, ExtractDto, ArticleDto}
import models.{Card, Extract, Article}
import play.api.libs.json._
import play.api.mvc._

object Application extends Controller {
  val OkEmpty = Ok(Json.obj("result" -> "ok"))

  def getCards() = Action { request =>
    Ok(Json.toJson(CardDto.getAll))
  }

  def getCard(id: Long) = Action { request =>
    Ok(Json.toJson(CardDto.get(id)))
  }

  def addCard(question: String, answer: String, article: Option[Long], extract: Option[Long]) = Action { request =>
    val card = new Card(0, question, answer, article, extract)
    CardDto.save(card)
    OkEmpty
  }

  def answerCard(id: Long, quality: Int, date: Option[String]) = TODO

  def getArticle(id: Long) = Action { request =>
    Ok(Json.toJson(ArticleDto.get(id)))
  }

  def getArticles() = Action { request =>
    Ok(Json.toJson(ArticleDto.getAll))
  }

  def addArticle(title: String, text: String, source: Option[String]) = Action { request =>
    val article = new Article(0, title, text, source.getOrElse(""))
    ArticleDto.save(article)
    OkEmpty
  }

  def getExtracts() = Action { request =>
    Ok(Json.toJson(ExtractDto.getAll))
  }

  def getExtract(id: Long) = Action { request =>
    Ok(Json.toJson(ExtractDto.get(id)))
  }

  def addExtract(text: String, article: Option[Long], begin: Option[Long], end: Option[Long]) = Action { request =>
    val extract = new Extract(0, text, article, begin, end)
    ExtractDto.save(extract)
    OkEmpty
  }
}