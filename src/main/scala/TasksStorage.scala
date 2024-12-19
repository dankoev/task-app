import scala.collection.mutable.ArrayBuffer

object TasksStorage {
  private var tasks: List[String] = Nil

  def addTask(task: String): Unit = {
    tasks = task :: tasks
  }

  def deleteTask(index: Int): Boolean = {
    if (index >= 0 && index < tasks.length) {
      tasks = tasks.take(index) ::: tasks.drop(index + 1)
      true
    } else {
      false
    }
  }

  def getTasks(): List[String] = tasks
}
