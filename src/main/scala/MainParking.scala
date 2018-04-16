import akka.actor.{ActorSystem, Props}
import com.pushp.ParkingGateOne

import scala.concurrent.ExecutionContext
import scala.io.StdIn
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object MainParking extends App{
  val actorSystem = ActorSystem("parking-lot")
  val parkingGateOneActor = actorSystem.actorOf(Props[ParkingGateOne],name = "Parking-gate-1")
  val parkingGateTwoActor = actorSystem.actorOf(Props[ParkingGateOne].withDispatcher("blocking-io-dispatcher"),name = "Parking-gate-2")
  //implicit val executionContext: ExecutionContext = actorSystem.dispatchers.lookup("my-custom-dispatcher")
/*  parkingGateOneActor ! "Car entered"
  parkingGateOneActor ! "Car"*/

  actorSystem.scheduler.schedule(2 seconds, 5 seconds, parkingGateOneActor, "Scheduled Msg")
  actorSystem.scheduler.schedule(2 seconds, 5 seconds, parkingGateTwoActor, "Scheduled Msg")

  StdIn.readLine()
  actorSystem.terminate()
}
