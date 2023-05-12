package screenplay.custom;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.conditions.ConditionalPerformable;
import net.serenitybdd.screenplay.conditions.ConditionalPerformableOnQuestion;
import org.hamcrest.Matcher;

public class CustomWait {


    /**
     * @author Luisa.
     *
     * <p>Custom Conditional para utilizar questions de cualquier tipo generico,
     * la limitante es que el parametro question de la clase Check.whether de la libreria
     * de screenplay no admite objetos de tipo genérico donde el argumento de tipo es un comodín
     * solo de tipo concreto.
     * Ejemplos de tipos paramterizados genericos donde el argumento de tipo es un comodin:
     * <pre>{@code
     *       Collection<?>
     *       List<? extiende Número>
     *       Comparador<? super String>
     *       }</pre>
     * El metodo se crea para aceptar questions con parametros de tipo generico y Matcher acepte esos
     * parametros de una instancia de tipo generico con cuaquier argumento
     * Un objecto List y todas sus variantes que requiere
     * argumentos de tipo
     *
     * </a>
     * @param question Question<? extends T>
     * @param matcher Matcher<T>
     *
     * */
    public static <T> ConditionalPerformable checkWhether(Question<? extends T> question, Matcher<T> matcher) {
        Question<Boolean> condition = (actor) -> matcher.matches(question.answeredBy(actor));
        return new ConditionalPerformableOnQuestion(condition);
    }
}
