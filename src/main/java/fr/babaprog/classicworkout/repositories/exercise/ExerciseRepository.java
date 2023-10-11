package fr.babaprog.classicworkout.repositories.exercise;

import fr.babaprog.classicworkout.models.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query("SELECT e FROM Exercise e WHERE e.frenchName = :name or e.englishName = :name")
    Optional<Exercise> findByFrenchNameOrEnglishName(String exerciseName);

}
