package co.com.test.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.test.choucair.userinterface.PageBuscarQVF.BTNCLOSE;

public class CheckQ implements Question<Boolean>
{
    String word;
    public CheckQ(String word)
    {
        this.word = word;
    }
    public static CheckQ is(String questionv) {
        return new CheckQ(questionv);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println(BTNCLOSE);
        String text = Text.of(BTNCLOSE).viewedBy(actor).asString();
        System.out.println(text);

       do {
           word.equals(text );
           text = Text.of(BTNCLOSE).viewedBy(actor).asString();

        } while (!word.equals(text ));
        return word.equals(text );
    }
}