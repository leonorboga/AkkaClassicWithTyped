import akka.actor.{ Actor, ActorLogging, Props }

class ClassicDarkChocolateActor() extends Actor with ActorLogging {
  import ClassicDarkChocolateActor._

  override def receive: Receive = {
    case GiveDarkChocolate =>
      log.info("Please collect your dark chocolate")
  }
}

object ClassicDarkChocolateActor {
  sealed trait DarkChocolateProtocol
  case object GiveDarkChocolate

  def props(): Props = Props(new ClassicDarkChocolateActor())
}
