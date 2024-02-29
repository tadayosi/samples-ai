///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS dev.langchain4j:langchain4j-bom:0.27.1@pom
//DEPS dev.langchain4j:langchain4j
//DEPS dev.langchain4j:langchain4j-open-ai
//DEPS org.slf4j:slf4j-simple:2.0.12

import static java.lang.System.*;

import dev.langchain4j.model.openai.*;

public class hello {

    static final String OPENAI_API_KEY = getenv("OPENAI_API_KEY");

    public static void main(String... args) {
        var model = OpenAiChatModel.withApiKey(OPENAI_API_KEY);
        var answer = model.generate("Say Hello");
        out.println(answer);
    }
}
