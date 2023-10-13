package fr.babaprog.classicworkout.repositories.workout;

import fr.babaprog.classicworkout.models.workout.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Optional<Workout> findByWorkoutName(String workoutName);
}
