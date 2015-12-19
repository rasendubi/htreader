package controllers

import java.text.DateFormat
import java.util.Date

import dtos._
import models._
import play.api.libs.json._
import play.api.mvc._
import schedulers.SM2

object Application extends Controller {
  val OkEmpty = Ok(Json.obj("result" -> "ok"))

  def getCardsForToday() = Action { request =>
    val cards = CardDto.getDueTo(new Date())
    Ok(Json.toJson(cards))
  }

  def getCards() = Action { request =>
    Ok(Json.toJson(CardDto.getAll))
  }

  def getCard(id: Long) = Action { request =>
    Ok(Json.toJson(CardDto.get(id)))
  }

  def addCard(question: String, answer: String, article: Option[Long], extract: Option[Long]) = Action { request =>
    val card = new Card(0, question, answer, article, extract)
    val card_saved = CardDto.save(card)
    val schedulingInfo = SM2.init(card_saved.id, new Date())
    SchedulingInfoDto.save(schedulingInfo)
    OkEmpty
  }

  def answerCard(id: Long, quality: Int, date: Option[String]) = Action {
    val dateAnswered = date.map(x => DateFormat.getDateInstance.parse(x)).getOrElse(new Date())
    val schedulingInfo = SchedulingInfoDto.get(id)
    val newSchedulingInfo = SM2.schedule(schedulingInfo, dateAnswered, quality)
    SchedulingInfoDto.update(newSchedulingInfo)
    OkEmpty
  }

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

  def notFound(path: String) = controllers.Assets.at(path="/public", file="index.html")
}