package fr.babaprog.classicworkout.service;

import fr.babaprog.classicworkout.dto.workout.WorkoutRequest;
import fr.babaprog.classicworkout.models.workout.Workout;
import fr.babaprog.classicworkout.repositories.workout.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;


    public Workout savedWorkout(WorkoutRequest workoutRequest) {
        var workout = Workout
                .builder()
                .workoutName(workoutRequest.getWorkoutName())
                .muscularGroup(workoutRequest.getMuscularGroup())
                .exercises(workoutRequest.getExercises())
                .lastTimeDOne(workoutRequest.getLastTimeDone())
                .build();

        workout = workoutRepository.save(workout);
        return workout;
    }
}
