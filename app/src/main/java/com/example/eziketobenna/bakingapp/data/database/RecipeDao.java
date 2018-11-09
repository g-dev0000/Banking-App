package com.example.eziketobenna.bakingapp.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {

    @Query("SELECT * FROM recipe")
    LiveData<List<Recipe>> getAllRecipe();

    @Query("SELECT * FROM recipe WHERE id = :id")
    LiveData<Recipe> getRecipeById(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void BulkInsert(Recipe... recipes);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Recipe item);

    @Delete
    void delete(Recipe item);

    @Query("DELETE FROM recipe")
    void deleteAllMovies();
}
