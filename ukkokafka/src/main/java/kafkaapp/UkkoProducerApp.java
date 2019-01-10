package kafkaapp;

import domain.FarmClass;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class UkkoProducerApp {
    public static void main(String[] args){

        String input = "";
        // Create a properties dictionary for the required/optional Producer config settings:
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // --> props.put("config.setting", "value");
        // :: http://kafka.apache.org/documentation.html#producerconfigs

        KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(props);

        try{
            while(true){
                myProducer.send(new ProducerRecord<String, String>("FarmTopic", input));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            myProducer.close();
        }

    }
}
