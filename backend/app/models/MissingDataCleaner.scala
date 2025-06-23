package models

import java.io._
import scala.io.Source

object MissingDataCleaner {

def clean(inputFile: File): File = {

val lines = Source.fromFile(inputFile).getLines().toList  
val header = lines.head  
val data = lines.tail.map(_.split(",").map(_.trim))  

// Nettoyage simple : supprimer lignes avec valeurs manquantes  
val cleanedData = data.filterNot(row => row.contains(""))  

val tempDir = System.getProperty("java.io.tmpdir")  
val outputFile = new File(tempDir, s"cleaned_${inputFile.getName}")  
val writer = new PrintWriter(outputFile)  

writer.println(header)  
cleanedData.foreach(r => writer.println(r.mkString(",")))  
writer.close()  

outputFile  
}
}