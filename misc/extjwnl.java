///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS net.sf.extjwnl:extjwnl:2.0.5
//DEPS net.sf.extjwnl:extjwnl-data-wn31:1.2
//DEPS org.slf4j:slf4j-nop:1.7.36

import static java.lang.System.out;

import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.PointerUtils;
import net.sf.extjwnl.dictionary.Dictionary;

public class extjwnl {

    public static void main(String... args) throws Exception {
        if (args.length < 1) {
            out.println("Usage:");
            out.println("  ./extjwnl.java <word>");
            return;
        }

        var dic = Dictionary.getDefaultResourceInstance();
        var word = dic.getIndexWord(POS.NOUN, args[0]);
        if (word == null) {
            out.println("Word not found: " + args[0]);
            return;
        }
        var tree = PointerUtils.getHypernymTree(word.getSenses().get(0));
        out.println("Word: " + word.getLemma());
        tree.toList().forEach(hypernyms -> {
            hypernyms.stream()
                    .map(h -> h.getSynset().getWords().get(0).getLemma())
                    .forEach(l -> out.println("  => " + l));
        });
    }
}
