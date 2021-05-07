## Testing Akka Classic together with Akka Typed

After having issues testing a legacy system to which Akka Typed actors were added, I decided to test the coexistence
in this sample project

Currently some test fail:
TypedFPMilkChocolateActor_BehaviorTestKit_Test
TypedOOMilkChocolateActor_BehaviorTestKit_Test

Logs are not printed which make the test fail
