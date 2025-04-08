package fr.mosef.scala.template.writer

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}
import java.util.Properties

class Writer(sparkSession: SparkSession, config: Properties) {

  // Convertit une chaîne en SaveMode Spark
  def parseSaveMode(modeStr: String): SaveMode = modeStr.toLowerCase match {
    case "overwrite"     => SaveMode.Overwrite
    case "append"        => SaveMode.Append
    case "ignore"        => SaveMode.Ignore
    case "errorifexists" => SaveMode.ErrorIfExists
    case other           => throw new IllegalArgumentException(s"❌ Mode d'écriture non supporté: $other")
  }

  // Écrit un DataFrame au format spécifié dans le chemin donné
  def write(data: DataFrame, outputPath: String): Unit = {
    val outputFormat  = config.getProperty("format", "csv")
    val saveMode      = config.getProperty("mode", "overwrite")
    val shouldMerge   = config.getProperty("coalesce", "false").toBoolean
    val includeHeader = config.getProperty("header", "true")
    val fieldSep      = config.getProperty("separator", ",")

    val dfToWrite = if (shouldMerge) data.coalesce(1) else data

    val writer = dfToWrite.write
      .option("header", includeHeader)
      .option("sep", fieldSep)
      .mode(parseSaveMode(saveMode))

    outputFormat match {
      case "csv"     => writer.csv(outputPath)
      case "parquet" => writer.parquet(outputPath)
      case "json"    => writer.json(outputPath)
      case _         => throw new IllegalArgumentException(s"❌ Format de sortie inconnu : $outputFormat")
    }
  }

  def showDataFrame(data: DataFrame, numRows: Int = 10): Unit = {
    data.show(numRows, truncate = false)
  }
}
