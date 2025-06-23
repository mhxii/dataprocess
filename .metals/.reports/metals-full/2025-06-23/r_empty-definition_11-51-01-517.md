error id: file:///C:/CodeMine/dataprocess/backend/app/controllers/NormalizerController.scala:`<none>`.
file:///C:/CodeMine/dataprocess/backend/app/controllers/NormalizerController.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -javax/inject/NormalizerController.
	 -javax/inject/NormalizerController#
	 -javax/inject/NormalizerController().
	 -play/api/mvc/NormalizerController.
	 -play/api/mvc/NormalizerController#
	 -play/api/mvc/NormalizerController().
	 -models/NormalizerController.
	 -models/NormalizerController#
	 -models/NormalizerController().
	 -NormalizerController.
	 -NormalizerController#
	 -NormalizerController().
	 -scala/Predef.NormalizerController.
	 -scala/Predef.NormalizerController#
	 -scala/Predef.NormalizerController().
offset: 169
uri: file:///C:/CodeMine/dataprocess/backend/app/controllers/NormalizerController.scala
text:
```scala
// Mohamed SALL (Et en fin normalisé les données )
package controllers

import javax.inject._
import play.api.mvc._
import java.io.File
import models.NormalizerCon@@troller
import scala.concurrent.ExecutionContext

@Singleton
class DuplicatesController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

def index = Action { implicit request: Request[AnyContent] =>
Ok("Backend opérationnel. Utilise POST /clean pour envoyer un CSV.")
}

def cleanDuplicates = Action(parse.multipartFormData) { request =>

request.body.file("csvFile").map { csv =>

val inputFile = csv.ref.path.toFile
val cleanedFile = DuplicatesCleaner.clean(inputFile)

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
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.