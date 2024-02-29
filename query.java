///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS dev.langchain4j:langchain4j-bom:0.27.1@pom
//DEPS dev.langchain4j:langchain4j
//DEPS dev.langchain4j:langchain4j-open-ai
//DEPS org.slf4j:slf4j-simple:2.0.12

import static java.lang.System.*;

import dev.langchain4j.model.openai.*;

class query {

    static final String OPENAI_API_KEY = getenv("OPENAI_API_KEY");

    public static void main(String... args) {
        if (args.length < 1) {
            out.println("Usage:");
            out.println("  jbang query.java [prompt]");
            return;
        }

        if (OPENAI_API_KEY == null) {
            err.println("Provide OPENAI_API_KEY as environment variable");
            return;
        }

        var prompt = args[0];
        var model = OpenAiChatModel.withApiKey(OPENAI_API_KEY);
        var answer = model.generate(prompt);
        out.println(answer);
    }
}
