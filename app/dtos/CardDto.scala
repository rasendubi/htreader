package dtos

import models.Card

object CardDto {

  def save(article: Card): Card = ???
  def update(article: Card): Card = ???
  def get(id: Long): Card = ???
  def getAll: List[Card] = ???
}
