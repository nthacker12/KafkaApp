package serializer;

import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.FarmClass;

import java.util.Map;

public class FarmDeserializer implements Deserializer {

    @Override
    public void close(){

    }


    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public FarmClass deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        FarmClass farm = null;
        try{
            farm = mapper.readValue(arg1, FarmClass.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return farm;
    }
}
