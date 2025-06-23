package controllers

import javax.inject._
import play.api.mvc._
import java.io.File
import models.MissingDataCleaner
import scala.concurrent.ExecutionContext

@Singleton
class MissingDataController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

def index = Action { implicit request: Request[AnyContent] =>
Ok("Backend opérationnel. Utilise POST /clean pour envoyer un CSV.")
}

def cleanData = Action(parse.multipartFormData) { request =>

request.body.file("csvFile").map { csv =>

val inputFile = csv.ref.path.toFile
val cleanedFile = MissingDataCleaner.clean(inputFile)

Ok.sendFile(
content = cleanedFile,
fileName = _ => Some(s"cleaned_${inputFile.getName}"),
inline = false
)

}.getOrElse {
BadRequest("Fichier CSV manquant.")
}
}
}