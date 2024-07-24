from nltk.corpus import wordnet as wn

word = wn.synsets("dingo", pos=wn.NOUN)
for s in word:
    print(s.lemma_names()[0])
    for h in s.hypernyms():
        print("  => " + h.lemma_names()[0])
