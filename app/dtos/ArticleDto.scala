package dtos

import models.Article

object ArticleDto {

  def save(article: Article): Article = ???
  def update(article: Article): Article = ???
  def get(id: Long): Article = ???
  def getAll: List[Article] = ???
}
