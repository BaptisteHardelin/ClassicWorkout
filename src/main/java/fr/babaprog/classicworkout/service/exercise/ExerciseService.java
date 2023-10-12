package fr.babaprog.classicworkout.service.exercise;

import fr.babaprog.classicworkout.dto.exercise.ExerciseRequest;
import fr.babaprog.classicworkout.models.exercise.Exercise;
import fr.babaprog.classicworkout.repositories.exercise.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;


    public Exercise savedExercise(ExerciseRequest exerciseRequest) {
        var newExercise = Exercise
                .builder()
                .french_name(exerciseRequest.getFrench_name())
                .english_name(exerciseRequest.getEnglish_name())
                .muscular_group(exerciseRequest.getMuscular_group())
                .weight(exerciseRequest.getWeight())
                .last_time_done(exerciseRequest.getLast_time_done())
                .build();

        newExercise = exerciseRepository.save(newExercise);
        return newExercise;
    }
}
