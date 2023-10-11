package fr.babaprog.classicworkout.controllers.exercise;

import fr.babaprog.classicworkout.dto.exercise.ExerciseRequest;
import fr.babaprog.classicworkout.models.exercise.Exercise;
import fr.babaprog.classicworkout.repositories.exercise.ExerciseRepository;
import fr.babaprog.classicworkout.service.exercise.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercise() {
        return ResponseEntity.ok(exerciseRepository.findAll());
    }

    @GetMapping
    public ResponseEntity<Exercise> getExerciseByName(@RequestParam String name) {
        var exercise = exerciseRepository.findByFrenchNameOrEnglishName(name);
        return exercise.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Exercise saveExercise(@RequestBody ExerciseRequest request) {
        return exerciseService.savedExercise(request);
    }


}
