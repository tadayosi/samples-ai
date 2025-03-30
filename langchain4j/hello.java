///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS dev.langchain4j:langchain4j-bom:1.0.0-beta2@pom
//DEPS dev.langchain4j:langchain4j
//DEPS dev.langchain4j:langchain4j-open-ai
//DEPS org.slf4j:slf4j-simple:2.0.12

import static java.lang.System.*;

import dev.langchain4j.model.openai.*;

class hello {

    static final String OPENAI_API_KEY = getenv("OPENAI_API_KEY");

    public static void main(String... args) {
        if (OPENAI_API_KEY == null) {
            err.println("Provide OPENAI_API_KEY as environment variable");
            return;
        }

        var model = OpenAiChatModel.withApiKey(OPENAI_API_KEY);
        var answer = model.generate("Say Hello");
        out.println(answer);
    }
}
