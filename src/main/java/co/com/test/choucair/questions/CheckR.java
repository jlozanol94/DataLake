package co.com.test.choucair.questions;

import co.com.test.choucair.util.Constants;
import co.com.test.choucair.util.FileText;
import co.com.test.choucair.util.log;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CheckR implements Question<Boolean>
{
    String word;
    public CheckR(String word)
    {
        this.word = word;
    }

    public static CheckR is(String questionr) {
        return new CheckR(questionr);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<String> milista = new ArrayList<>();
        try {
            milista = FileText.read(Constants.path2.concat("\\").concat(log.path()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message = milista.get(milista.size() - 2);
        return message.contains(word);
    }
}