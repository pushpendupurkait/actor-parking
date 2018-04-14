import akka.actor.{ActorSystem, Props}
import com.pushp.ParkingGateOne
import scala.io.StdIn

object MainParking extends App{
  val actorSystem = ActorSystem("parking-lot")
  val parkingGateOneActor = actorSystem.actorOf(Props[ParkingGateOne],name = "Parking-gate-1")

  parkingGateOneActor ! "Car entered"
  parkingGateOneActor ! "Car"

  StdIn.readLine()
  actorSystem.terminate()
}
