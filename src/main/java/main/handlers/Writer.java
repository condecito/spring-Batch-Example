package main.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;
@Slf4j
public class Writer implements ItemWriter <String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        log.info("Invoke writer");
        for(String msg : list){
            System.out.println("Writing the data " + msg);
        }
        //log.info("end writer");
    }
}
