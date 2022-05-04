package com.example.roomenandroidconkotlintarea1ap2.data.model.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomenandroidconkotlintarea1ap2.data.model.database.entities.QuoteEntity

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quote_table ORDER BY author DESC")
    suspend fun getAllQuote():List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<QuoteEntity>)

    @Query("DELETE FROM quote_table")
    suspend fun deleteAllQuotes()
}