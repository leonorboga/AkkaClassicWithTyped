import TypedChocCoordinatorActor.{ OfferDarkChocolate, OfferMilkChocolate }
import akka.actor.{ ActorSystem => ClassicSystem }
import akka.actor.typed.scaladsl.adapter._

object Main extends App {
  // Because we want to reproduce the scenario of adding typed actor to a project that has legacy
  // classic actors, and so a classic ActorSystem
  val system = ClassicSystem()

  val chocCoordinatorActor = system.spawn(TypedChocCoordinatorActor(), "TypedChocCoordinatorActor")

  chocCoordinatorActor ! OfferDarkChocolate
  chocCoordinatorActor ! OfferDarkChocolate
  chocCoordinatorActor ! OfferMilkChocolate

  system.terminate()
}
