package com.sparkTutorial.rdd

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark._

object WordCount {

  def main(args: Array[String]) {


    //se crea un logger para redirecciar las salida  a otro sitio
    Logger.getLogger("org").setLevel(Level.ERROR)


    val conf = new SparkConf().setAppName("wordCounts").setMaster("local[*]")


    //"spark://192.168.1.96:4040

    //val conf = new SparkConf().setAppName("wordCounts").setMaster("spark://192.168.1.96:4040")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("in/word_count.text")


    val words = lines.flatMap(line => line.split(" "))


    val wordCounts = words.countByValue()

    for ((word, count) <- wordCounts) println(word + " : " + count)



  }
}
