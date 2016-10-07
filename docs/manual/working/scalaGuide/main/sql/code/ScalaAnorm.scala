package scalaGuide.main.sql

import org.specs2.mutable.Specification
import play.api.test._
import play.api.test.Helpers._

object ScalaAnorm extends Specification {
  "Code samples" title

  "Anorm" should {
    "be usable in play" in new WithApplication(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
      //#playdb
      import play.api.db.Database
      import anorm._
      import com.google.inject.Inject


      class PlayAnorm @Inject () (db: Database)  {
        db.withConnection { implicit connection =>
          val result: Boolean = SQL("Select 1").execute()
        }
      }
      //#playdb
      ok
    }
  }
}