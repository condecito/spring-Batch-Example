package main.handlers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

@Slf4j
public class Reader implements ItemReader<String> {
    String[] messages = {"data1", "data2", "data 3"};
    int count=0;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException,
            NonTransientResourceException {
        log.info("invoke reader");
        if (count < messages.length )
            return messages[count++];
        else
            return null; //can't read
    }


    private String[] simulateRead() {

        return messages;
    }
}
