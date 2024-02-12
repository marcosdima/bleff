package bleff;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
public class WordController {
    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public ResponseEntity<List<Word>> getAllWords() {
        List<Word> words = wordService.getAllWords();
        return ResponseEntity.ok(words);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Word> getWordById(@PathVariable String id) {
        Word word = wordService.getWordById(id);
        if (word == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(word);
    }

    @PostMapping
    public ResponseEntity<Word> createWord(@RequestBody Word word) {
        Word createdWord = wordService.createWord(word);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWord(@PathVariable String id) {
        wordService.deleteWord(id);
        return ResponseEntity.noContent().build();
    }
}
