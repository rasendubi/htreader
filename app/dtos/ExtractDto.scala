package dtos

import dtos.utils.Util
import models.Extract
import play.api.Play.current
import play.api.db.DB

import scala.collection.mutable.ListBuffer

object ExtractDto {

  def save(extract: Extract): Extract = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("INSERT INTO Extract (text, article, begin, end) VALUES (?, ?, ?, ?)",
        java.sql.Statement.RETURN_GENERATED_KEYS)
      statement.setString(1, extract.text)
      statement.setLong(2, extract.article.getOrElse(0))
      statement.setLong(3, extract.begin.getOrElse(0))
      statement.setLong(4, extract.end.getOrElse(0))
      statement.executeUpdate()
      val generatedKey = statement.getGeneratedKeys
      if (generatedKey.next()) new Extract(generatedKey.getLong(1), extract)
      else extract
    }
  }

  def update(extract: Extract): Extract = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("UPDATE Extract SET text=?, article=?, begin=?, end=? WHERE id=?")
      statement.setString(1, extract.text)
      statement.setLong(2, extract.article.getOrElse(0))
      statement.setLong(3, extract.begin.getOrElse(0))
      statement.setLong(4, extract.end.getOrElse(0))
      statement.setLong(5, extract.id)
      statement.executeUpdate()
    }
    extract
  }

  def get(id: Long): Extract = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("SELECT * FROM Extract WHERE id=?")
      statement.setLong(1, id)
      val resultSet = statement.executeQuery()
      if (resultSet.next()) new Extract(resultSet.getLong("id"), resultSet.getString("text"),
        Util.fromId(resultSet.getLong("article")),
        Util.fromId(resultSet.getLong("begin")), Util.fromId(resultSet.getLong("end")))
      else null
    }
  }

  def getAll: List[Extract] = {
    val articles = new ListBuffer[Extract]()
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("SELECT * FROM Extract")
      val resultSet = statement.executeQuery()
      while (resultSet.next()) {
        articles += new Extract(resultSet.getLong("id"), resultSet.getString("text"),
          Util.fromId(resultSet.getLong("article")),
          Util.fromId(resultSet.getLong("begin")), Util.fromId(resultSet.getLong("end")))
      }
    }
    articles.toList
  }
}
