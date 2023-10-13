package fr.babaprog.classicworkout.controllers.workout;

import fr.babaprog.classicworkout.dto.workout.WorkoutRequest;
import fr.babaprog.classicworkout.models.workout.Workout;
import fr.babaprog.classicworkout.repositories.workout.WorkoutRepository;
import fr.babaprog.classicworkout.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workout")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutRepository workoutRepository;
    private final WorkoutService workoutService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Workout>> getAllWorkout() {
        return ResponseEntity.ok(workoutRepository.findAll());
    }

    @GetMapping("/name")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Workout> getWorkoutByName(@RequestParam String name) {
        var workout = workoutRepository.findByWorkoutName(name.toLowerCase().trim());
        return workout.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Workout savedWorkout(@RequestBody WorkoutRequest workoutRequest) {
        return workoutService.savedWorkout(workoutRequest);
    }


}
