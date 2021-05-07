import TypedChocCoordinatorActor.OfferMilkChocolate
import akka.actor.testkit.typed.scaladsl.{ LoggingTestKit, ScalaTestWithActorTestKit }
import org.scalatest.flatspec.AnyFlatSpecLike

class TypedChocCoordinatorActorTest extends ScalaTestWithActorTestKit with AnyFlatSpecLike {

  val chocCoordinator = testKit.spawn(TypedChocCoordinatorActor(), "ChocCoordinatorActor")

  "TypedChocCoordinatorActor" should "offer a milk chocolate" in {
    LoggingTestKit.info("Going to offer a milk chocolate").expect {
      chocCoordinator ! OfferMilkChocolate
    }
  }
}
