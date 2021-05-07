import TypedFPMilkChocolateActor.{ GiveMilkChocolate, MilkChocolateProtocol }
import akka.actor.testkit.typed.scaladsl.{ BehaviorTestKit, LoggingTestKit, ScalaTestWithActorTestKit }
import org.scalatest.flatspec.AnyFlatSpecLike

class TypedFPMilkChocolateActor_BehaviorTestKit_Test extends ScalaTestWithActorTestKit with AnyFlatSpecLike  {
  val milkChocActor: BehaviorTestKit[MilkChocolateProtocol] = BehaviorTestKit(TypedFPMilkChocolateActor())

  "TypedFPMilkChocolateActor_BehaviorTestKit_Test" should "give free milk chocolate" in {
    LoggingTestKit.info("Please collect your milk chocolate").expect{
      milkChocActor.run(GiveMilkChocolate)
    }
  }
}
