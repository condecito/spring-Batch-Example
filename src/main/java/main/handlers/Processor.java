package main.handlers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
@Slf4j
public class Processor implements ItemProcessor<String,String> {
    @Override
    public String process(String data) throws Exception {
        log.info("Invoke processor");
        return data.toUpperCase().concat("\nProcessed");
    }
}
