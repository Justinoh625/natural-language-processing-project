import java.util.ArrayList;

public class NLPRunner {
  public static void main(String[] args) {

    SpamCatcher nlp = new SpamCatcher();
    nlp.displaySpamWords();
    nlp.exampleEmail1();
    nlp.checkUserEmail();
  }
}