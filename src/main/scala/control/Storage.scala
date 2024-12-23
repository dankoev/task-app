package control

trait Storage {

  def addTask(task: String): Unit  

  def deleteTask(index: Int): Boolean

  def getTasks(): List[String]
} 
