import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object TypedFPMilkChocolateActor {
  sealed trait MilkChocolateProtocol
  case object GiveMilkChocolate extends MilkChocolateProtocol

  def apply(): Behavior[MilkChocolateProtocol] = giveChocolate()

  def giveChocolate(): Behavior[MilkChocolateProtocol]  =
    Behaviors.receive { (context, message) =>
      message match {
        case GiveMilkChocolate =>
          context.log.info("Please collect your milk chocolate")
          Behaviors.same
      }
    }
}
