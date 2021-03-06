package gargt.words.Dao;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import gargt.words.model.Word;

@Dao
public interface WordDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Word word);

    @Query("DELETE from word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER by word ASC")
    //LiveData<List<Word>> getAllWords();
    public abstract DataSource.Factory<Integer, Word> getAllWords();
}
