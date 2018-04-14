import akka.actor.{ActorSystem, Props}
import com.pushp.ParkingGateOne
import scala.io.StdIn
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object MainParking extends App{
  val actorSystem = ActorSystem("parking-lot")
  val parkingGateOneActor = actorSystem.actorOf(Props[ParkingGateOne],name = "Parking-gate-1")

/*  parkingGateOneActor ! "Car entered"
  parkingGateOneActor ! "Car"*/

  actorSystem.scheduler.schedule(2 seconds, 5 seconds, parkingGateOneActor, "Scheduled Msg")

  StdIn.readLine()
  actorSystem.terminate()
}
