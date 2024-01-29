package com.example.kitchen

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Service

@Service
class Kitchen(val kafkaTemplate: KafkaTemplate<String, String>) {

    val topic = "kitchen_topic"

    @KafkaListener(id = "myConsumer", topics = ["kitchen_topic"], groupId = "spring-boot", autoStartup = "false")
    fun listen(value: String,
               @Header(KafkaHeaders.RECEIVED_TOPIC) topic: String,
               @Header(KafkaHeaders.RECEIVED_KEY) key: String) {

        println("Message received: " + value)
        prepareMeal()
        sendMessage(key, "done")
    }

    fun sendMessage(key: String, message: String) {
        println("Sending message")
        kafkaTemplate.send(topic, key, message)
    }

    fun prepareMeal() {
        Thread.sleep(5000)
    }
}