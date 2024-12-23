package control

import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._

object JsonStorage extends Storage {

  private val storagePath = "./data/storage.json"
  private var tasks: List[String] = Nil

  def addTask(task: String): Unit = {
    tasks = task :: tasks
    save()
  }

  def deleteTask(index: Int): Boolean = {
    if (index >= 0 && index < tasks.length) {
      tasks = tasks.take(index) ::: tasks.drop(index + 1)
      save()
      true
    } else {
      false
    }
  }

  def getTasks(): List[String] = tasks

  def save(): Unit = {
    val a = tasks.asJson
    println(a)
  }
}
