import ClassicDarkChocolateActor.GiveDarkChocolate
import TypedChocCoordinatorActor.TypedChocCoordinatorActorProtocol
import TypedOOMilkChocolateActor.GiveMilkChocolate
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.adapter._
import akka.actor.typed.scaladsl.{ ActorContext, Behaviors }

class TypedChocCoordinatorActor(context: ActorContext[TypedChocCoordinatorActorProtocol]) {
  import TypedChocCoordinatorActor._
  private val log = context.log

  val darkChocActor = context.toClassic.actorOf(ClassicDarkChocolateActor.props(), "DarkChocActor")
  val milkChocActor = context.spawn(TypedOOMilkChocolateActor(), "MilkChocActor")

  def apply(): Behavior[TypedChocCoordinatorActorProtocol] = coordinateChocOffers()

  private def coordinateChocOffers(): Behavior[TypedChocCoordinatorActorProtocol] =
    Behaviors.receiveMessage {
      case OfferDarkChocolate =>
        log.info("Going to offer a dark chocolate")
        darkChocActor ! GiveDarkChocolate
        Behaviors.same
      case OfferMilkChocolate =>
        log.info("Going to offer a milk chocolate")
        milkChocActor ! GiveMilkChocolate
        Behaviors.same
    }
}

object TypedChocCoordinatorActor {
  def apply(): Behavior[TypedChocCoordinatorActorProtocol] =
    Behaviors.setup(context => new TypedChocCoordinatorActor(context).coordinateChocOffers())

  trait TypedChocCoordinatorActorProtocol

  case object OfferDarkChocolate extends TypedChocCoordinatorActorProtocol
  case object OfferMilkChocolate extends TypedChocCoordinatorActorProtocol
}
