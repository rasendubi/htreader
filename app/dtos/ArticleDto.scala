package dtos

import models.Article
import play.api.Play.current
import play.api.db.DB

import scala.collection.mutable.ListBuffer

object ArticleDto {

  def save(article: Article): Article = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("INSERT INTO Article (title, text, source) VALUES (?, ?, ?)",
        java.sql.Statement.RETURN_GENERATED_KEYS)
      statement.setString(1, article.title)
      statement.setString(2, article.text)
      statement.setString(3, article.source)
      statement.executeUpdate()
      val generatedKey = statement.getGeneratedKeys
      if (generatedKey.next()) new Article(generatedKey.getLong(1), article)
      else article
    }
  }

  def update(article: Article): Article = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("UPDATE Article SET title=?, text=?, source=? WHERE id=?")
      statement.setString(1, article.title)
      statement.setString(2, article.text)
      statement.setString(3, article.source)
      statement.setLong(4, article.id)
      statement.executeUpdate()
    }
    article
  }

  def delete(id: Long) = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("DELETE FROM Article WHERE id=?")
      statement.setLong(1, id)
      statement.executeUpdate()
    }
  }

  def get(id: Long): Article = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("SELECT * FROM Article WHERE id=?")
      statement.setLong(1, id)
      val resultSet = statement.executeQuery()
      if (resultSet.next()) new Article(resultSet.getLong("id"), resultSet.getString("title"),
        resultSet.getString("text"), resultSet.getString("source"))
      else null
    }
  }

  def getAll: List[Article] = {
    val articles = new ListBuffer[Article]()
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("SELECT * FROM Article")
      val resultSet = statement.executeQuery()
      while (resultSet.next()) {
        articles += new Article(resultSet.getLong("id"), resultSet.getString("title"),
          resultSet.getString("text"), resultSet.getString("source"))
      }
    }
    articles.toList
  }
}
