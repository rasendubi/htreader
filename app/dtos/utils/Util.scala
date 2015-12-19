package dtos.utils

object Util {

  def fromId(id: Long): Option[Long] = {
    if (id == 0) None
    else Some(id)
  }
}
