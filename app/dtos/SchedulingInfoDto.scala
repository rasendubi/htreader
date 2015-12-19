package dtos

import models.SchedulingInfo
import play.api.Play.current
import play.api.db.DB

import scala.collection.mutable.ListBuffer

object SchedulingInfoDto {

  def save(info: SchedulingInfo): SchedulingInfo = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("INSERT INTO SchedulingInfo (cardId, eFactor, repetition, interval, nextDate) VALUES (?, ?, ?, ?, ?)",
        java.sql.Statement.RETURN_GENERATED_KEYS)
      statement.setLong(1, info.cardId)
      statement.setDouble(2, info.eFactor)
      statement.setInt(3, info.repetition)
      statement.setLong(4, info.interval)
      statement.setDate(5, new java.sql.Date(info.nextDate.getTime))
      statement.executeUpdate()
      val generatedKey = statement.getGeneratedKeys
      if (generatedKey.next()) new SchedulingInfo(generatedKey.getLong(1), info)
      else info
    }
  }

  def update(info: SchedulingInfo): SchedulingInfo = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("UPDATE SchedulingInfo SET cardId=?, eFactor=?, repetition=?, interval=?, nextDate=? WHERE id=?")
      statement.setLong(1, info.cardId)
      statement.setDouble(2, info.eFactor)
      statement.setInt(3, info.repetition)
      statement.setLong(4, info.interval)
      statement.setDate(5, new java.sql.Date(info.nextDate.getTime))
      statement.setLong(6, info.id)
      statement.executeUpdate()
    }
    info
  }

  def get(id: Long): SchedulingInfo = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("SELECT * FROM SchedulingInfo WHERE id=?")
      statement.setLong(1, id)
      val resultSet = statement.executeQuery()
      if (resultSet.next()) new SchedulingInfo(resultSet.getLong("id"), resultSet.getLong("cardId"), resultSet.getLong("eFactor"),
        resultSet.getInt("repetition"), resultSet.getLong("interval"), resultSet.getDate("nextDate"))
      else null
    }
  }

  def getAll: List[SchedulingInfo] = {
    val infos = new ListBuffer[SchedulingInfo]()
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("SELECT * FROM SchedulingInfo")
      val resultSet = statement.executeQuery()
      while (resultSet.next()) {
        infos += new SchedulingInfo(resultSet.getLong("id"), resultSet.getLong("cardId"), resultSet.getLong("eFactor"),
          resultSet.getInt("repetition"), resultSet.getLong("interval"), resultSet.getDate("nextDate"))
      }
    }
    infos.toList
  }
}
