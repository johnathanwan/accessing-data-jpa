package com.example.accessingdatajpa

import mu.*
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AccessingDataJpaApplication {

    companion object {
        private var logger = KotlinLogging.logger {}
    }

    @Bean
    fun demo(repository: CustomerRepository): CommandLineRunner {
        return CommandLineRunner {
            // save a few customers
            repository.save(Customer("Jack", "Bauer"))
            repository.save(Customer("Chloe", "O'Brian"))
            repository.save(Customer("Kim", "Bauer"))
            repository.save(Customer("David", "Palmer"))
            @Suppress("SpellCheckingInspection")
            repository.save(Customer("Michelle", "Dessler"))

            // fetch all customers
            logger.info { "Customers found with findAll():" }
            logger.info { "-------------------------------" }
            repository.findAll().forEach {
                logger.info { it.toString() }
            }
            logger.info { "" }

            // fetch an individual customer by ID
            val customer = repository.findById(1L).get()
            logger.info { "Customer found with findById(1L)" }
            logger.info { "--------------------------------" }
            logger.info { customer.toString() }
            logger.info { "" }

            // fetch customers by last name
            logger.info { "Customer found with findByLastName('Bauer')" }
            logger.info { "-------------------------------------------" }
            repository.findByLastName("Bauer").forEach {
                logger.info { it.toString() }
            }
            logger.info { "" }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<AccessingDataJpaApplication>(*args)
}
