package com.dependency.demo;


import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class jsoncmd implements CommandLineRunner {

//    @Bean
//    CommandLineRunner runner(TestService testService) {
//        return args -> {
//            // read json and write to db
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            TypeReference<List<Cpe_Item>> typeReference = new TypeReference<List<Cpe_Item>>(){};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/tests.json");
//            try {
//                List<Cpe_Item> test = mapper.readValue(inputStream,typeReference);
//                testService.save(test);
//                System.out.println("Saved!");
//            } catch (IOException e){
//                System.out.println("Unable to save: " + e.getMessage());
//            }
//        };
//    }

   // @Value("${demo.json.string}") private String jsonString;
    //    @Autowired
    private CpeRepository cpeRepository;


    @Bean
    @Override
    public void run (String... args) throws Exception{
        XmlToJson xmlToJson=new XmlToJson();
        String jsonString=xmlToJson.ToXml();
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Root value = mapper.readValue(jsonString,Root.class);
        Root save= cpeRepository.save(value);

        //log.info("CpeList info" + save.toString());

    }

}
