package dtos

import play.api.db.DB
import play.api.Play.current
import models.SchedulingInfo

import scala.collection.mutable.ListBuffer

object SchedulingInfoDto {

  def getAll: List[SchedulingInfo] = {
    val infos = new ListBuffer[SchedulingInfo]()
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("SELECT * FROM SchedulingInfo")
      val resultSet = statement.executeQuery()
      while (resultSet.next()) {
        infos += new SchedulingInfo(resultSet.getLong("id"), resultSet.getLong("eFactor"),
          resultSet.getInt("repetition"), resultSet.getLong("interval"), resultSet.getDate("nextDate"))
      }
    }
    infos.toList
  }

  def save(info: SchedulingInfo) = {
    DB.withConnection { conn =>
      val statement = conn.prepareStatement("INSERT INTO SchedulingInfo (eFactor, repetition, interval, nextDate) VALUES (?, ?, ?, ?)")
      statement.setDouble(1, info.eFactor)
      statement.setInt(2, info.repetition)
      statement.setLong(3, info.interval)
      statement.setDate(4, new java.sql.Date(info.nextDate.getTime))
      statement.executeUpdate()
    }
  }
}
