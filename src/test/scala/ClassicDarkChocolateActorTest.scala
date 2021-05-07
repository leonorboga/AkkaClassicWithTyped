import ClassicDarkChocolateActor.GiveDarkChocolate
import akka.actor.ActorSystem
import akka.testkit.{ EventFilter, TestActorRef, TestKit }
import com.typesafe.config.ConfigFactory
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpecLike

class ClassicDarkChocolateActorTest extends TestKit(ActorSystem("DarkChocolate_System", ConfigFactory.parseString("""
  akka.loggers = ["akka.testkit.TestEventListener"]
  """)))
  with AnyFlatSpecLike with BeforeAndAfterAll{

  val darkChocActor = TestActorRef(new ClassicDarkChocolateActor())

  "ClassicDarkChocolateActor" should "give free dark chocolate" in {
    EventFilter.info("Please collect your dark chocolate").intercept {
      darkChocActor ! GiveDarkChocolate
    }
  }

  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system, verifySystemShutdown = true)
  }
}
