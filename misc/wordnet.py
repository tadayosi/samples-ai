import nltk
from nltk.corpus import wordnet as wn

nltk.download("wordnet")

word = wn.synsets("dingo", pos=wn.NOUN)
for s in word:
    print(s.lemma_names()[0])
    for h in s.hypernyms():
        print(f"  => {h.lemma_names()[0]}")
