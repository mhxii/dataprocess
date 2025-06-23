error id: file:///C:/CodeMine/dataprocess/backend/app/models/Normalizer.scala:`<none>`.
file:///C:/CodeMine/dataprocess/backend/app/models/Normalizer.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 336
uri: file:///C:/CodeMine/dataprocess/backend/app/models/Normalizer.scala
text:
```scala
package models

import java.io._
import scala.io.Source

object Normalizer {

def clean(inputFile: File): File = {

val lines = Source.fromFile(inputFile).getLines().toList  
val header = lines.head  
val data = lines.tail.map(_.split(",").map(_.trim))  

// Faire le traitement ici  

val cleanedData
// Generation du c@@sv apres traitement
val tempDir = System.getProperty("java.io.tmpdir")  
val outputFile = new File(tempDir, s"cleaned_${inputFile.getName}")  
val writer = new PrintWriter(outputFile)  
writer.println(header)  
cleanedData.foreach(r => writer.println(r.mkString(",")))  
writer.close()  

outputFile  
}
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.