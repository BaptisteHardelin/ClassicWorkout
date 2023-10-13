package fr.babaprog.classicworkout.dto.workout;

import fr.babaprog.classicworkout.models.exercise.Exercise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutRequest {

    private String workoutName;
    private List<String> muscularGroup;
    private List<String> exercises;
    private LocalDateTime lastTimeDone;
}
