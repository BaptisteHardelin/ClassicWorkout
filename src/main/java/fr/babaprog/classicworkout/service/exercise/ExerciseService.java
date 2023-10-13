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
                .frenchName(exerciseRequest.getFrenchName())
                .englishName(exerciseRequest.getEnglishName())
                .muscularGroup(exerciseRequest.getMuscularGroup())
                .weight(exerciseRequest.getWeight())
                .lastTimeDone(exerciseRequest.getLastTimeDone())
                .build();

        newExercise = exerciseRepository.save(newExercise);
        return newExercise;
    }
}
