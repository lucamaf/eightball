package org.acme;

import java.util.ArrayList;
import java.util.Random;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;


@Path("/answer")
public class AnswersResource{

    private ArrayList<Answer> answers = new ArrayList<>();
    private static final Logger LOG = Logger.getLogger(AnswersResource.class);




    public AnswersResource() {
        answers.add(new Answer(1, "It is certain", 1));
        answers.add(new Answer(2, "It is decidedly so", 1));
        answers.add(new Answer(3, "Without a doubt", 1));
        answers.add(new Answer(4, "Yes – definitely", 1));
        answers.add(new Answer(5, "You may rely on it", 1));
        answers.add(new Answer(6, "As I see it, yes", 1));
        answers.add(new Answer(7, "Most likely", 1));
        answers.add(new Answer(8, "Outlook good", 1));
        answers.add(new Answer(9, "Yes", 1));
        answers.add(new Answer(10, "Signs point to yes", 1));
        answers.add(new Answer(11, "Reply hazy, try again", 0));
        answers.add(new Answer(12, "Ask again later", 0));
        answers.add(new Answer(13, "Better not tell you now", 0));
        answers.add(new Answer(14, "Cannot predict now", 0));
        answers.add(new Answer(15, "Concentrate and ask again", 0));
        answers.add(new Answer(16, "Don't count on it", -1));
        answers.add(new Answer(17, "My reply is no", -1));
        answers.add(new Answer(18, "My sources say no", -1));
        answers.add(new Answer(19, "Outlook not so good", -1));
        answers.add(new Answer(20, "Very doubtful", -1));
    }
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Answer getone(@DefaultValue("random") @QueryParam("sentiment") String sentiment) {
        Random rand = new Random();
        if(sentiment.equals("positive")){
            Answer randomElement = answers.get(rand.nextInt(10));
            LOG.info("Requested positive answer");
            return randomElement;
        }else if(sentiment.equals("neutral")){
            Answer randomElement = answers.get(rand.nextInt(5)+10);
            LOG.info("Requested neutral answer");
            return randomElement;
        }else if(sentiment.equals("negative")){
            Answer randomElement = answers.get(rand.nextInt(5)+15);
            LOG.info("Requested negative answer");
            return randomElement;
        }else{
            Answer randomElement = answers.get(rand.nextInt(answers.size()));
            LOG.info("Requested random answer");
            return randomElement;
        }
        
    }


}