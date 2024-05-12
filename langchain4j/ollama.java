///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS dev.langchain4j:langchain4j-bom:0.30.0@pom
//DEPS dev.langchain4j:langchain4j
//DEPS dev.langchain4j:langchain4j-ollama
//DEPS org.slf4j:slf4j-simple:2.0.12

import static java.lang.System.*;

import dev.langchain4j.model.ollama.*;

class ollama {

    static final String OLLAMA_URL = "http://localhost:11434";

    public static void main(String... args) {
        if (args.length < 2) {
            out.println("Usage:");
            out.println("  jbang ollama.java [model] [prompt]");
            return;
        }

        var modelName = args[0];
        var prompt = args[1];
        var model = OllamaChatModel.builder()
            .baseUrl(OLLAMA_URL)
            .modelName(modelName)
            .build();
        var answer = model.generate(prompt);
        out.println(answer);
    }
}
