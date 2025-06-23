error id: file:///C:/CodeMine/dataprocess/backend/app/controllers/MissingDataController.scala:`<none>`.
file:///C:/CodeMine/dataprocess/backend/app/controllers/MissingDataController.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -javax/inject/Request#
	 -play/api/mvc/Request#
	 -Request#
	 -scala/Predef.Request#
offset: 432
uri: file:///C:/CodeMine/dataprocess/backend/app/controllers/MissingDataController.scala
text:
```scala
// For Black (Vérifier la présence des valeurs manquantes et les traités)
package controllers

import javax.inject._
import play.api.mvc._
import java.io.File
import models.MissingDataCleaner
import scala.concurrent.ExecutionContext

@Singleton
class MissingDataController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

def index = Action { implicit request: Request@@[AnyContent] =>
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
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.