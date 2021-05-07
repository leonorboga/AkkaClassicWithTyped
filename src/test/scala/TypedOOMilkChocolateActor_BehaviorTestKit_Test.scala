import TypedOOMilkChocolateActor.{ GiveMilkChocolate, MilkChocolateProtocol }
import akka.actor.testkit.typed.scaladsl.{ BehaviorTestKit, LoggingTestKit, ScalaTestWithActorTestKit }
import org.scalatest.flatspec.AnyFlatSpecLike

class TypedOOMilkChocolateActor_BehaviorTestKit_Test extends ScalaTestWithActorTestKit with AnyFlatSpecLike {
  val milkChocActor: BehaviorTestKit[MilkChocolateProtocol] = BehaviorTestKit(TypedOOMilkChocolateActor())

  "TypedOOMilkChocolateActor_BehaviorTestKit_Test" should "give free milk chocolate" in {
    LoggingTestKit.info("Please collect your milk chocolate").expect{
      milkChocActor.run(GiveMilkChocolate)
    }
  }
}
