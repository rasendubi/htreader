package controllers

import dtos.ArticleDto
import play.api.libs.json._
import play.api.mvc._

import models.Article._

object Application extends Controller {

  def getCards() = TODO

  def getCard(id: Long) = TODO

  def addCard(question: String, answer: String, article: Option[Long], extract: Option[Long]) = TODO

  def answerCard(id: Long, quality: Int, date: Option[String]) = TODO

  def getArticle(id: Long) = Action { request =>
    Ok(Json.toJson(ArticleDto.get(id)))
  }

  def getArticles() = TODO

  def addArticle(title: String, text: String, source: Option[String]) = TODO

  def getExtracts() = TODO

  def getExtract(id: Long) = TODO

  def addExtract(text: String, article: Option[Long], begin: Option[Long], end: Option[Long]) = TODO
}