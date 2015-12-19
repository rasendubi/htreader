package dtos

import java.util.Date

import dtos.utils.Util
import models.Extract
import play.api.Play.current
import play.api.db.DB

import scala.collection.mutable.ListBuffer

object ExtractDto {

  def save(extract: Extract): Extract = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("INSERT INTO Extract (text, article, begin, end, repetition, nextDate) VALUES (?, ?, ?, ?, ?, ?)",
        java.sql.Statement.RETURN_GENERATED_KEYS)
      statement.setString(1, extract.text)
      statement.setLong(2, extract.article.getOrElse(0))
      statement.setLong(3, extract.begin.getOrElse(0))
      statement.setLong(4, extract.end.getOrElse(0))
      statement.setInt(5, extract.repetition)
      statement.setDate(6, new java.sql.Date(extract.nextDate.getTime))
      statement.executeUpdate()
      val generatedKey = statement.getGeneratedKeys
      if (generatedKey.next()) new Extract(generatedKey.getLong(1), extract)
      else extract
    }
  }

  def delete(id: Long) = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("DELETE FROM Extract WHERE id=?")
      statement.setLong(1, id)
      statement.executeUpdate()
    }
  }

  def update(extract: Extract): Extract = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("UPDATE Extract SET text=?, article=?, begin=?, end=?, repetition=?, nextDate=? WHERE id=?")
      statement.setString(1, extract.text)
      statement.setLong(2, extract.article.getOrElse(0))
      statement.setLong(3, extract.begin.getOrElse(0))
      statement.setLong(4, extract.end.getOrElse(0))
      statement.setInt(5, extract.repetition)
      statement.setDate(6, new java.sql.Date(extract.nextDate.getTime))
      statement.setLong(7, extract.id)
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
        Util.fromId(resultSet.getLong("begin")), Util.fromId(resultSet.getLong("end")),
        resultSet.getInt("repetition"), resultSet.getDate("nextDate"))
      else null
    }
  }

  def getAll: List[Extract] = {
    val extracts = new ListBuffer[Extract]()
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("SELECT * FROM Extract")
      val resultSet = statement.executeQuery()
      while (resultSet.next()) {
        extracts += new Extract(resultSet.getLong("id"), resultSet.getString("text"),
          Util.fromId(resultSet.getLong("article")),
          Util.fromId(resultSet.getLong("begin")), Util.fromId(resultSet.getLong("end")),
          resultSet.getInt("repetition"), resultSet.getDate("nextDate"))
      }
    }
    extracts.toList
  }

  def getDueTo(date: Date) = {
    val extracts = new ListBuffer[Extract]()
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("SELECT * FROM Extract WHERE nextDate<=?")
      statement.setDate(1, new java.sql.Date(date.getTime))
      val resultSet = statement.executeQuery()
      while (resultSet.next()) {
        extracts += new Extract(resultSet.getLong("id"), resultSet.getString("text"),
          Util.fromId(resultSet.getLong("article")),
          Util.fromId(resultSet.getLong("begin")), Util.fromId(resultSet.getLong("end")),
          resultSet.getInt("repetition"), resultSet.getDate("nextDate"))
      }
    }
    extracts.toList
  }
}
