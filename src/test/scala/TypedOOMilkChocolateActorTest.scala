import TypedOOMilkChocolateActor.{ GiveMilkChocolate, MilkChocolateProtocol }
import akka.actor.testkit.typed.scaladsl.{ LoggingTestKit, ScalaTestWithActorTestKit }
import akka.actor.typed.ActorRef
import org.scalatest.flatspec.AnyFlatSpecLike

class TypedOOMilkChocolateActorTest extends ScalaTestWithActorTestKit with AnyFlatSpecLike {
  val milkChocActor: ActorRef[MilkChocolateProtocol] =
    testKit.spawn(TypedOOMilkChocolateActor(), "TypedOOMilkChocolateActor")

  "TypedOOMilkChocolateActor" should "give free milk chocolate" in {
    LoggingTestKit.info("Please collect your milk chocolate").expect{
      milkChocActor ! GiveMilkChocolate
    }
  }
}
