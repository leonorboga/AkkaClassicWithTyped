import TypedOOMilkChocolateActor.MilkChocolateProtocol
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.{ AbstractBehavior, ActorContext, Behaviors }

object TypedOOMilkChocolateActor {
  sealed trait MilkChocolateProtocol
  case object GiveMilkChocolate extends MilkChocolateProtocol

  def apply(): Behavior[MilkChocolateProtocol] = Behaviors.setup(context => new TypedOOMilkChocolateActor(context))
}

class TypedOOMilkChocolateActor(context: ActorContext[MilkChocolateProtocol])
  extends AbstractBehavior[MilkChocolateProtocol](context) {
import TypedOOMilkChocolateActor._

  def onMessage(msg: MilkChocolateProtocol): Behavior[MilkChocolateProtocol]  =
    msg match {
        case GiveMilkChocolate =>
          context.log.info("Please collect your milk chocolate")
          Behaviors.same
    }
}
