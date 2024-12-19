import scala.io.StdIn.*
import javax.print.DocFlavor.STRING
import scala.collection.mutable.ArrayBuffer
import scala.annotation.tailrec

@main
def main: Unit =
  run()

@tailrec
def run(): Unit = {
  def menu: String =
    s"""0. Добавить задачу
        |1. Посмотреть список задач
        |2. Удалить задачу
        |3. Выйти""".stripMargin
  println(menu)
  val result = choice()
  result match
    case Right(_) =>
      println()
      run()
    case Left("Exit") => println("Exit")
    case Left(exitMessage) =>
      println(exitMessage)
      run()
}

def choice(): Either[String, Unit] = {
  print("Введите номер: ")
  val key: String = readLine()
  key match
    case "0" =>
      print("Введите задачу: ")
      TasksStorage.addTask(readLine())
      Right(())
    case "1" =>
      val tasks = TasksStorage
        .getTasks()
        .zipWithIndex
        .map { case (task, index) => s"$index - $task" }
        .mkString("Задачи:\n", "\n", "\n")
      Right(print(tasks))
    case "2" => {
      try {
        print("Введите индекс для удаления: ")
        val index = readInt()
        if (!TasksStorage.deleteTask(index))
          Left("Неверный индекс удаления")
        else
          Right(())

      } catch {
        case _ => Left("Error read int")
      }
    }
    case "3" =>
      println("Вы уверены, что хотите выйти? (y/n)")
      if (readLine().toLowerCase == "y") Left("Exit") else Right(())
    case _ => Right(println("Неверный номер операции"))
}
