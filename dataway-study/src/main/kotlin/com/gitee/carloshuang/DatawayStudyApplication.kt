package com.gitee.carloshuang

import net.hasor.spring.boot.EnableHasor
import net.hasor.spring.boot.EnableHasorWeb
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableHasor()
@EnableHasorWeb()
@SpringBootApplication
class DatawayStudyApplication

fun main(args: Array<String>) {
	runApplication<DatawayStudyApplication>(*args)
}
