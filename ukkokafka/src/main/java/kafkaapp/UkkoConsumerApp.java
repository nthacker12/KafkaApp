package kafkaapp;

import domain.FarmClass;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UkkoConsumerApp {
    public static void main(String[] args){

        //Create a properties dictionary for the required/optional Producer config settings:
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092, localhost:9093");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // --> props.put("config.setting", "value");
        // :: http://kafka.apache.org/documentation.html#consumerconfigs

        Pattern p = Pattern.compile("/[a-zA-Z]+/g");

        KafkaConsumer myConsumer = new KafkaConsumer(props);

        ArrayList<String> topics = new ArrayList<>();
        topics.add("FarmTopic");

        myConsumer.subscribe(topics);

        try{
            while(true){
                ConsumerRecords<String, String> records = myConsumer.poll(10);
                for (ConsumerRecord<String, String> record : records){
                    // Process each record:
                    Matcher m = p.matcher(record.value());
//                    System.out.println(String.format("Topic: %s, Partition: %d. Offset: %d. Key: %s, Value: %s",
//                            record.topic(), record.partition(), record.offset(), record.key(), record.value()));
                    if (m.group(1) == "create"){
                        FarmClass farm = new FarmClass(m.group(2), m.group(3));
                        farm.toString();
                    }else if (m.group(1) == "update"){

                    }else if (m.group(1) == "get"){

                    }else if (m.group(1) == "delete"){

                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            myConsumer.close();
        }
    }
}
