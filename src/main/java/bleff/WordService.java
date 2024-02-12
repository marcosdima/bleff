package bleff;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    public Word getWordById(String id) {
        return wordRepository.findById(id).orElse(null);
    }

    public Word createWord(Word word) {
        return wordRepository.save(word);
    }

    public void deleteWord(String id) {
        wordRepository.deleteById(id);
    }
}
